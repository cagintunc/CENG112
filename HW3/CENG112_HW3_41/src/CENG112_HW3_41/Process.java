package CENG112_HW3_41;

public class Process implements IProcess {
	private String name;
	private int priorityNumber;
	private String priorityIndicator;
	private Computation computation;
	private static int numberOfProcess = 0;
	private static final String[] currentPriorities = {"High", "Normal", "Low"};
	
	// Constructor
	public Process() {
		priorityNumber = (int)(Math.random()*   3);
		priorityIndicator = currentPriorities[priorityNumber];
		numberOfProcess++;
		name = "P" + numberOfProcess;
		requestComputation();
	}
	
	public String getType() {
		return priorityIndicator;
	}

	public int getPriority() {
		return priorityNumber;
	}
	public Computation getComputation() {
		return computation;
	}
	public String toString() {
		return name + ", " + priorityIndicator;
	}
	public void resetNumberOfProcess() {
		numberOfProcess = 0;
	}
	// Process requests for computation
	private final void requestComputation() {
		computation = new Computation(this);
	}
}
