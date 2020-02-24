import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DiskController {
	static final AtomicInteger current_time = new AtomicInteger(0);
	static final ConsoleDisplay DISPLAY = new ConsoleDisplay(current_time);
    public static void main(final String[] args) {
        final int[][] data = { { 0, 3 }, { 2, 6 }, { 1, 9 } };
        final JobQue jobQue = new JobQue(DISPLAY);

        new Thread(new Runnable() {
          public void run() {
            for (int i = 0; i < data.length * 3; i++) {
              System.out.println(DISPLAY.console_print());
              try { Thread.sleep(1000); } catch (InterruptedException ie) { }
            }
          }
        }).start();

        final Producer producer = new Producer(data, jobQue, DISPLAY);
        producer.start();
        final Consumer consumer = new Consumer(jobQue, DISPLAY);
        consumer.start();
    }
}

class Job implements Comparable<Job> {
    int call;
    int exec;
    void setCall(final int call) { this.call = call; }
    int getCall() { return this.call; }
    void setExec(final int exec) { this.exec = exec; }
    int getExec() { return this.exec; }
    public String toString() { return "call: " + call + " exec: " + exec; }

    public int compareTo(final Job target) {
        return this.exec <= target.getExec() ? 1 : -1;
    }
}

class JobQue {
    boolean isConsumable = false;
    boolean isProducible = true;
    final PriorityQueue<Job> queue = new PriorityQueue<>();
    final ConsoleDisplay __;

    JobQue(ConsoleDisplay __) { this.__ = __; }

    synchronized Job getJob() {
        while (!isConsumable) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }
        Job polled_job = queue.poll();
        isConsumable = false;
        isProducible = true;
        __.DISPLAY(new ArrayList<Job>(){{add(polled_job);}});
        notifyAll();
        return polled_job;
    }

    synchronized void putJob(ArrayList<Job> jobs) {
      while (!isProducible) {
        try {
          wait();
        } catch (InterruptedException ie) {
        }
      }
      isProducible = false;
      isConsumable = true;
      jobs.forEach(job -> queue.offer(job));
      __.DISPLAY(jobs);
      notifyAll();
    }
}

class Producer extends Thread {
    final ConsoleDisplay __;
    ArrayList<Job> backlog = new ArrayList<>();
    JobQue jobQue;

    Producer(final int[][] data, final JobQue jobQue, ConsoleDisplay __) {
        for (int i = 0; i < data.length; i++) {
            final Job job = new Job();
            job.setCall(data[i][0]);
            job.setExec(data[i][1]);
            backlog.add(job);
        }
        this.jobQue = jobQue;
        this.__ = __;
    }

    public void run() {
        ArrayList<Job> cached_jobs = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            for (int j = backlog.size() - 1; j > -1; j--) {
                if (this.backlog.get(j).getCall() <= __.getCurrentTime()) {
                    Job catched_job = backlog.remove(j);
                    cached_jobs.add(catched_job);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
            }
        }
        if (cached_jobs.size() > 0) {
          __.DISPLAY("(producer)");
          jobQue.putJob(cached_jobs);
          cached_jobs.clear();
          __.DISPLAY("(producer)");
        }
    }
}

class Consumer extends Thread {
    final ConsoleDisplay __;
    JobQue jobQue;

    Consumer(final JobQue jobQue, ConsoleDisplay __) {
        this.jobQue = jobQue;
        this.__ = __;
    }

    public void run() {
        for (int i = 0; i < 1; i++) {
            final Job fetched_job = jobQue.getJob();
            __.DISPLAY("(comsumer)");
            try {
                Thread.sleep(2000);
                __.getCurrentTimeAndAdd(fetched_job.getExec());
            } catch (final InterruptedException e) {
            }
            __.DISPLAY("(comsumer)");
        }
    }
};

interface Clock {
  int getCurrentTime();
  int getCurrentTimeAndAdd(int time);
}

class ConsoleDisplay extends Thread {
    ArrayBlockingQueue<String> consoleQue = new ArrayBlockingQueue<String>(10);
    final AtomicInteger current_time;
    final AtomicInteger cached_time = new AtomicInteger(0);
    boolean isOpen = false;
    StringBuilder sb = new StringBuilder();

    String _EMPTY_LINE = "\n\n\n"; 
    String _HEADER = "◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎\n";
    String _DIVIDER = " ⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻⎻ \n";
    String _FOOTER = "◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎◻︎\n";

    String _CURRENT_TIME() { return "current time: " + current_time.get() + "\n"; }
    String _CHANGED_TIME() {
        return "time elapsed\n\tfrom: " + cached_time.get() + ", to: " + current_time.get() + "\n";
    }
    String _ACTOR(String rolename) { return String.format("%23s\n", rolename + "\n"); }
    String _JOB_DESCRIPTION(String message) {
        return "* " + message + ":\n" ;
    }
    
    ConsoleDisplay(AtomicInteger current_time) {
        this.current_time = current_time;
    }
    synchronized String console_print() {
    	while (consoleQue.size() <= 0) {
    		try {
				wait();
    		} catch (InterruptedException ie) {
    		}
    	}
    	notifyAll();
		return consoleQue.poll();
    }

    synchronized void DISPLAY(ArrayList<Job> jobs) {
    	while (consoleQue.size() >= 10) {
    		try {
    			wait();
    		} catch (InterruptedException ie) {
    		}
    	}
    	jobs.forEach(job -> sb.append("\n\t" + job.toString() + "\n"));
    	consoleQue.add(sb.toString());
    	notifyAll();
    }

    synchronized void DISPLAY(String rolename) {
    	while (consoleQue.size() >= 10) {
    		try {
    			wait();
    		} catch (InterruptedException ie) {
    		}
    	}
    	if (!isOpen) {
        if (rolename == "(producer)") {
          sb.append(_EMPTY_LINE)
            .append(_HEADER)
            .append(_CURRENT_TIME())
            .append(_DIVIDER)
            .append(_ACTOR(rolename))
            .append(_JOB_DESCRIPTION("job created"));
          isOpen = !isOpen;
        } else if (rolename == "(consumer)"){
          sb.append(_EMPTY_LINE)
            .append(_HEADER)
            .append(_CHANGED_TIME()) 
            .append(_DIVIDER)
            .append(_ACTOR(rolename))
            .append(_JOB_DESCRIPTION("job fetched"));
          isOpen = !isOpen;
        }
        consoleQue.add(sb.toString());
    	} else {
    		sb.append(_DIVIDER)
    			.append(_FOOTER);
        consoleQue.add(sb.toString());
        isOpen = !isOpen;
    	}
    	notifyAll();
    }

    public int getCurrentTime() { return current_time.get(); }
    
    public int getCurrentTimeAndAdd(int time) {
      cached_time.set(current_time.get());
      return current_time.getAndAdd(time);
    }
}


