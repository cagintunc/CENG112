package CENG112_HW2_41;

import java.util.*;
/**The main class which associated the whole process*/
public class IZTECHEA {
	private QueueInterface<IProduct> productionLine; //Queue
	private Scanner scanner;
	private MarketingAnalyst analyst;
	private StorageChief chief;
	private Customer customer;
	private int requestCycles;
	private int numberOfBed, numberOfSofa, numberOfChair, numberOfDresser, 
	numberOfTable, numberOfBookcase;
	
	/*Constructor*/
	public IZTECHEA() {
		productionLine = new ProductionLine<>();;
		scanner = new Scanner(System.in);
	}
	
	/*Main method*/
	public static void main(String[] args) {
		IZTECHEA iztechea = new IZTECHEA();
		iztechea.startSimulation();
	}
	
	/**Set up the application*/
	private void startSimulation() {
		chief = new StorageChief();
		analyst = new MarketingAnalyst();
		customer = new Customer();
		
		System.out.println("Enter the number of random request cycles:");
		requestCycles = scanner.nextInt();
		int randomNumber;
		for(int index = 1; index <= requestCycles; index++) {
			System.out.print(index+". ");
			randomNumber = (int)(Math.random()*3);
			putIntoProcess(randomNumber);
		}
		System.out.println("\nREPORT: \n");
		displayFactoryLine();
		System.out.println();
		chief.displayWarehouses();
		System.out.println();
		chief.displaySold();
	}
	
	/**According to the random number between 0-2 the proper process chosen here*/
	public void putIntoProcess(int randomNumber) {
		if(randomNumber == 0) {
			analyst.setNumber();
			IProduct product = analyst.getProduct();
			productionLine.enqueue(product);
		}else if(randomNumber == 1) {
			if(productionLine.isEmpty()) {
				System.out.println("Storage Chief cannot store anything, factory is empty, FAIL");
				return;
			}
			IProduct product = productionLine.dequeue();
			chief.setProduct(product);
		}else if(randomNumber == 2) {
			customer.setNumber();
			customer.searchInWarehouse();
		}
	}
	/**Method for displaying what we have and how much we have.*/
	private void displayFactoryLine() {
		IProduct furniture;
		while(!productionLine.isEmpty()) {
			IProduct temp = (IProduct) productionLine.dequeue();
			furniture = temp;
			if(furniture.toString().equals("Sofa"))
				numberOfSofa++;
			else if(furniture.toString().equals("Bed"))
				numberOfBed++;
			else if(furniture.toString().equals("Chair"))
				numberOfChair++;
			else if(furniture.toString().equals("Dresser"))
				numberOfDresser++;
			else if(furniture.toString().equals("Table"))
				numberOfTable++;
			else if(furniture.toString().equals("Bookcase"))
				numberOfBookcase++;
		}
		System.out.println("Amount of Sofa in Factory Line: "+numberOfSofa);
		System.out.println("Amount of Bed in Factory Line: "+numberOfBed);
		System.out.println("Amount of Chair in Factory Line: "+numberOfChair);
		System.out.println("Amount of Dresser in Factory Line: "+numberOfDresser);
		System.out.println("Amount of Table in Factory Line: "+numberOfTable);
		System.out.println("Amount of Bookcase in Factory Line: "+numberOfBookcase);
	}
}






















