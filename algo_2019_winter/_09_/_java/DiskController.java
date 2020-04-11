import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DiskController {
	static final AtomicInteger TIME = new AtomicInteger(0);
	static final ConsoleQue OUT = new ConsoleQue();
	static final JobQue JOB_QUE = new JobQue(OUT, TIME);

	public static void main(final String[] args) {
		int[][] data = { { 0, 3 }, { 2, 6 }, { 1, 9 }, { 100, 5 } };
		ArrayList<Job> backlog = new ArrayList<>();
		for (int[] arr : data) {
			backlog.add(new Job(arr[0], arr[1]));
		}

		Thread producer = new Thread(new Runnable() {
			public void run() {
				while (true) {
					ArrayList<Integer> cachedIndex = new ArrayList<>();
					ArrayList<Job> cachedJobs = new ArrayList<>(); 
					/* 종료 조건 */ if (backlog.isEmpty()) { 
						System.out.println("###producer out");
						break; 
					} 
					/* 호출된 작업 찾기 */
					int currentTime = JOB_QUE.getCurrentTime();
					for (int j = backlog.size() - 1; j > -1; j--) {
						if (backlog.get(j).getCallTime() <= currentTime) {
							cachedIndex.add(j);
						}
					}
					/* 호출된 작업이 없는 경우 */ 
					if (cachedIndex.isEmpty() && JOB_QUE.isEmpty()) {
						Job job = backlog.get(0);
						backlog.remove(job);
						cachedJobs.add(job);
					}

					if (!cachedIndex.isEmpty()) {
						cachedIndex.forEach(i -> {
							Job clone = new Job();
							clone.setCall(backlog.get(i).getCallTime());
							clone.setExec(backlog.get(i).getExec());
							cachedJobs.add(clone);
							backlog.remove(backlog.get(i));
						});
					}
					while (!JOB_QUE.checkPushable()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					JOB_QUE.pushJobs(cachedJobs);
					cachedIndex.clear();
					cachedJobs.clear();
					while (!JOB_QUE.checkTimeHasChanged()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			public void run() {
				int finishedJobCount = 0;
				while (true) {
					if (finishedJobCount == data.length) {
						System.out.println("###consumer out");
						break;
					}
					try {
						while (!JOB_QUE.checkPoppable()) { 
							Thread.sleep(100);
						}
						/* 작업 꺼내기 */ JOB_QUE.popJob();
						finishedJobCount++;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} finally {
					}
				}
			}
		});

		Thread console = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
						String consoleStr;
						consoleStr = OUT.popConsoleStr();
						if (consoleStr.equals("finished")) {
							System.out.println("###console out");
							break;
						} else System.out.println(consoleStr);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		producer.start();
		consumer.start();
		console.start();
	}
}

class JobQue {
	private ConsoleQue OUT;
	private final AtomicInteger TIME;
	private ArrayList<Job> que = new ArrayList<>();
	private boolean isPoppable = false;
	private boolean isPushable = true;
	private boolean hasTimeChanged = true;

	JobQue(ConsoleQue out, AtomicInteger time) {
		this.TIME = time;
		this.OUT = out;
	}

	boolean checkPoppable() { return isPoppable; }
	boolean checkPushable() { return isPushable; }
	boolean checkTimeHasChanged() { return hasTimeChanged; }
	int getCurrentTime() { return TIME.get(); }
	boolean isEmpty() { return que.size() == 0; }

	void pushJobs(ArrayList<Job> jobs) {
		OUT.DP_TIME(TIME.get());
		jobs.forEach(job -> {
			que.add(job);
			OUT.<Job>DP_QUE_STATUS("\n\n ◀ ︎que pushed: \n\t", job);
		});
		OUT.<ArrayList<Job>>DP_QUE_STATUS("\n  que after push: ", que);
		isPushable = false;
		isPoppable = true;
		hasTimeChanged = false;
	}

	Job popJob() {
		while (!isPoppable && que.isEmpty()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int startTime = TIME.get();
		que = (ArrayList<Job>) que.stream().sorted().collect(Collectors.toList());
		Job job = que.remove(0);
		int finishTime;
		if (job.getCallTime() < startTime) {
			finishTime = TIME.addAndGet(job.getExec());
		} else {
			startTime = job.getCallTime();
			TIME.set(startTime + job.getExec());
			finishTime = TIME.get();
		}
		OUT.<Job>DP_QUE_STATUS("\n\n ◀ ︎que pulled: \n\t", job);
		OUT.<ArrayList<Job>>DP_QUE_STATUS("\n  que after pull: ", que);
		OUT.DP_TIME_CHANGE(startTime, finishTime);
		isPoppable = false;
		isPushable = true;
		hasTimeChanged = true;
		return job;
	}
}

class ConsoleQue {
	private ArrayList<String> que = new ArrayList<>();
	private boolean isTerminated;

	String popConsoleStr() throws InterruptedException {
		while (que.size() <= 0 && !isTerminated) {
			Thread.sleep(1000);
		}
		if (que.size() == 0 && isTerminated) return "finished";
		String out = que.remove(0);
		return out;
	}

	void DP_TIME(int time) {
		String rolename = "producer";
		String message = " ▶ produced job";
		que.add(
			Arrays.asList(new String[] { 
				"\n", 
				"🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰",
				"   current time   : " + time, 
				" ⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻ ", 
				String.format("\t\t(%s)", rolename),
				message, 
				"🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰🀰", 
				"\n" 
			}).stream().collect(Collectors.joining("\n"))
		);
	}

	void DP_TIME_CHANGE(int cached_time, int current_time) {
		String rolename = "consumer";
		String message = " ◀ consumed job";
		que.add(
			Arrays.asList(new String[] { 
				"\n", 
				"===========================",
				"  time changed \n\tfrom: " + cached_time + ", to: " + current_time, 
				" ⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻ ",
				String.format("\t\t(%s)", rolename), message, 
				"===========================", 
				"\n" 
			}).stream().collect(Collectors.joining("\n"))
		);
	}

	<T> void DP_QUE_STATUS(String message, T t) {
		que.add(message + t);
	}
}

class Job implements Comparable<Job> {
    private int call;
    private int exec;
    
    public int getCallTime() {
		return call;
	}

	public int getExec() {
		return exec;
	}

	public Job() {
	}

	public void setCall(int call) {
		this.call = call;
	}

	public void setExec(int exec) {
		this.exec = exec;
	}

	public Job(int call, int exec) {
		this.call = call;
		this.exec = exec;
	}

	public String toString() { return "call: " + call + " exec: " + exec; }

    public int compareTo(final Job target) {
        return this.exec - target.getExec(); 
    }
}
