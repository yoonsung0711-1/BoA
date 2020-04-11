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
