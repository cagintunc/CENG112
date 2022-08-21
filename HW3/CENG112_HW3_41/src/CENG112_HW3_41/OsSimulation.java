package CENG112_HW3_41;

public class OsSimulation {
	private static final String[] priorities = {"High", "Normal", "Low"};
	private int[] latestComputation = {0, 0, 0}; // For High, Normal, and Low respectively.
	private static int numberOfSimulation = 0;
	private int lastComputation; 
	private ListInterface<Process> processList;
	private PriorityQueueInterface<Computation> computationQueue;
	private int numberOfProcess;
	private int[] timeWaiting;
	private int[] numberOfType;
	
	//Constructor
	public OsSimulation(int number) {
		numberOfProcess = number;
		processList = new LinkedList<>();
		computationQueue = new PriorityQueue<>();
		timeWaiting = new int[number];
		numberOfType = new int[number];
	}
	
	public final void setUp() {
		numberOfSimulation++;
		System.out.println("Simulation Number: " + numberOfSimulation);
		for(int i = 1; i <= numberOfProcess; i++) {
			Process process = new Process();
			processList.add(process);
		}
		setTimes(); // For clone list and queue, we will use them when we set the time for each priorities.
		while(!processList.isEmpty()) {
			computationQueue.add(processList.remove().getComputation());
		}
		new Process().resetNumberOfProcess();
		System.out.print("Computation Queue: ");
		while(!computationQueue.isEmpty()) {		
			System.out.print(computationQueue.remove());
			if(!computationQueue.isEmpty())
				System.out.print(" <- ");
		}
		System.out.println();
		System.out.println("Total number of computations: " + numberOfProcess);
		System.out.println();
		getTheStatistics(); // To see the statistics
	}
	
	// Implementation details
	
	/**To constitute the timeWaiting list and numberOfType list*/
	private void setTimes() {
		// Clones 
		ListInterface<Process> cloneList = new LinkedList<>();
		PriorityQueueInterface<Computation> cloneQueue = new PriorityQueue<>();
		int length = processList.getLentgh();
		
		for(int index = 1; index <= length; index++) {
			cloneList.add(index, processList.getEntry(index));
		}
		while(!cloneList.isEmpty()) {
			cloneQueue.add(cloneList.remove().getComputation());
		}
		while(!cloneQueue.isEmpty()) {
			Computation currentComputation = cloneQueue.remove();
			int occupation = currentComputation.getOccupation();
			int priority = currentComputation.getProcess().getPriority();
			
			if(priority == 0) {
				latestComputation[0] = occupation;
				timeWaiting[0] += occupation;
				numberOfType[0]++;
			} else if(priority == 1) {
				latestComputation[1] = occupation;
				timeWaiting[1] += occupation;
				numberOfType[1]++;
			} else {
				latestComputation[2] = occupation;
				timeWaiting[2] += occupation;
				numberOfType[2]++;
			}
			lastComputation = occupation;
		}// End of while
	}
	/**This method is about the whole printing process*/
	private void getTheStatistics() {
		int totalWaitingTime = (timeWaiting[0] + timeWaiting[1] + 
				timeWaiting[2]) - lastComputation;
		int totalComputation = numberOfType[0] + numberOfType[1] + numberOfType[2];
		System.out.println("Total waiting time: " + totalWaitingTime);
		System.out.println("Average waiting time: "+ totalWaitingTime/totalComputation );
		System.out.println();
		for(int index = 0; index < 3; index++) 
			System.out.println("Total number of computations for " + 
					priorities[index] + ": " + numberOfType[index]);
		System.out.println();
		int total = 0;
		for(int index = 0; index < 3; index++) {
			if(timeWaiting[index] != 0) {
				int timeFor = total + (timeWaiting[index]-latestComputation[index]);
				System.out.println("Total waiting time for " + 
						priorities[index] + ": " + timeFor);
				if(numberOfType[index] != 0)
					System.out.println("Average waiting time for " + 
							priorities[index] + ": " + (timeFor/numberOfType[index]));
				else
					System.out.println("Average waiting time for " + 
							priorities[index] + ": " + 0);
				System.out.println();
				total += timeWaiting[index];
			} else {
				System.out.println("Total waiting time for " + priorities[index] + ": " + 0);
				System.out.println("Average waiting time for " + priorities[index] + ": " + 0);
				System.out.println();
			}
		}
		
	}
}





