package CENG112_HW3_41;

public class Computation implements Comparable<Computation>{
	private IProcess process;
	private int occupation;
	
	// Constructor
	public Computation(Process aProcess) {
		occupation = (int)((Math.random()*10)+1);
		process = aProcess;
	}
	/** And the Queen 'compareTo' which is the main character in priorities and therefore in everything*/
	public int compareTo(Computation other) {
		if(this.process.getPriority() == other.getProcess().getPriority()) {
			return 0;
		}
		else if(this.process.getPriority() < other.getProcess().getPriority()) {
			return 1;
		}	
		else {
			return -1;
		}
	}
	
	public String toString() {
		return process.toString()+", "+occupation+"ns";
	}
	public int getOccupation() {
		return occupation;
	}
	public IProcess getProcess() {
		return process;
	}
}
