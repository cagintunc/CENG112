package CENG112_HW1_41;
import java.util.*;
public class ShoppingApp {
	
	private ShoppingBasket<Item> basket;
	private FileIO dc;
	private InventoryBag<Item> myInventoryArray;
	private Scanner scanner;
	private boolean stateOfSetUp = false, flagToSayHello = true;
	private int quantity, maxNumberOfItems, minMeats = 10000, minBeverages = 10000, minSnacks = 10000, minVegetables = 10000;
	private int minQuantity = 10000, numberOfItems = 0;
	private String item, category; 
	private MeatsCompartment<Item> unitOfMeats;
	private BevaragesCompartment<Item> unitOfBeverages;
	private SnacksCompartment<Item> unitOfSnacks;
	private VegetablesFruitsCompartment<Item> unitOfVegetables;
	
	/**Constructor(Creator)**/
	public ShoppingApp() {
		basket = new ShoppingBasket<Item>();
		scanner = new Scanner(System.in);
		stateOfSetUp = true;
	}
	
	/**Main method**/
	public static void main(String[] args)
	{	
		ShoppingApp newApp = new ShoppingApp();
		if(newApp.setUpShopApp()) 
		{
			System.out.println("Whole components are filled. Mission is managed!!!");
		}
		System.out.println("We hope you've enjoyed with the Shopping Application.\nGood by.");
	}
	
	/**This method sets up the Shop Application.
	 @return True if the fridge's components are filled, or false otherwise**/
	private boolean setUpShopApp() {
		if(stateOfSetUp) {
			dc = new FileIO();
			boolean isFull;
			
			myInventoryArray = dc.readInventory();
			maxNumberOfItems = minMaxItems(myInventoryArray);
			
			unitOfMeats = new MeatsCompartment<Item>(minMeats);
			unitOfBeverages = new BevaragesCompartment<Item>(minBeverages);
			unitOfSnacks = new SnacksCompartment<Item>(minSnacks);
			unitOfVegetables = new VegetablesFruitsCompartment<Item>(minVegetables);
			
			while(!(isFull = isFridgeFull()))
			{	
				int userChoice = this.getUserInput();
				if(userChoice == 1) {
					this.beginToShop(maxNumberOfItems);
				}else if(userChoice == 2) {
					this.getTheStatus();
				}else if(userChoice == 3) {
					scanner.close();
					break;
				}
			}
			return isFull;
		} else {
			throw new SecurityException("ShoppingApp object is not initialized properly");
		}
	}
	
	/**This method is the beginning of the shopping process.
	 @param maxNum  The integer that shows the maximum possible collectible item number for the market.**/
	private void beginToShop(int maxNum) {
		int input2;
		int input3;
		basket = new ShoppingBasket<>(maxNum);
		numberOfItems = 0;
		
		this.getTheInformation();
		while((input2 = this.getUserInput2()) != 3) {
			if(input2 == 1) {
				System.out.println("\nPlease enter the number of your item:");
				input3 = scanner.nextInt();
				if((input3 < 1) || (input3 > 14)) {
					System.out.println("Some problem has occured, please try again;");
					continue;
				}
				this.addItemToBasket(input3-1);
				System.out.println("You have: ");
				basket.displayItems();
				System.out.println("Current basket capacity: " + basket.getCapacity()+"\n");
				if(basket.getCapacity() == 0) {
					System.out.println("The basket is FULL now, you can't put additional thing in it.\n");
				}
			}else if(input2 == 2) {
				if(!basket.isEmpty()) {
					Item removedItem;
					System.out.println("\nYou have following items, and their number:");
					basket.displayItems();
					scanner = new Scanner(System.in);
					System.out.println("\nEnter the number which corresponds your deletion:");
					input3 = scanner.nextInt();
					if((input3 < 1) || (input3 > basket.getItemCount())) {
						System.out.println("Some problem has occured, please try again;");
						continue;
					}
					removedItem = basket.removeByIndex(input3-1);
					basket.setCapacityA(removedItem.getMass());
					if(basket.isEmpty()) 
						System.out.println("After the deletion there is no item in your basket.\n");
					else {
						System.out.println("After the deletion, the basket includes:");
						basket.displayItems();
					}
					System.out.println("Current basket capacity: " + basket.getCapacity()+"\n");
				}else {
					System.out.println("\nYou don't have any items:'(");
				}
			}
		}if(!basket.isEmpty()) {
			this.goToTheHome(basket);
		}
	}
	
	/**This method is for the user input.
	 @return int  That corresponds to the user input.**/
	private int getUserInput() 
	{
		String inputStatement = "";
		
		if(flagToSayHello) {
			inputStatement = "Wellcome to the Shopping App!!\nYou need to enter a number which" 
							+ "associated with your choice:\n\n";
			System.out.print(inputStatement);
			flagToSayHello = false;
		} 
		
		inputStatement = "\n[1]Go to shop\n"
				 + "[2]See the status of the fridge\n"
		         +"[3]Exit the Shop App :(\n\n"
		         +"Please enter a number that indicates the correct action:";
		
		System.out.println(inputStatement);
		int userChoice = scanner.nextInt();
		while(!(userChoice == 1)&&!(userChoice == 2)&&!(userChoice == 3))
		{
			System.out.println("\nThis number is not associated any action. Please enter an available number:");
			userChoice = scanner.nextInt();
		}
		return userChoice;
		
	}
	
	/**This method is for the user input. We must check it for every scenario
	 @return int  That corresponds to the user input.**/
	private int getUserInput2() {
		System.out.print("Please enter the number which corresponds to your choice:\n"
							+ "[1]Add an item to your basket.\n"
							+ "[2]Remove an item from your basket.\n"
							+ "[3]Go to the home.\n:");
		int input2 = scanner.nextInt();
		while(!(input2 == 1)&&!(input2 == 2)&&!(input2 == 3)) {
			System.out.println("Please enter an available number: ");
			input2 = scanner.nextInt();
		}
		if(basket.isFull()&&input2 == 1) {
			System.out.println("Your basket is full you can't add a new item.");
			return getUserInput2();
		}
		return input2;
	}
	
	/**Get the information in this market, and show them to the user.**/
	private void getTheInformation() {
		System.out.println("\nMarket Information\n");
		for(int i = 0; i < 14; i++) {
			System.out.print("["+myInventoryArray.getArray()[i].getNumber()+"]");
			System.out.print(myInventoryArray.getArray()[i].getName()+" : ");
			System.out.println(myInventoryArray.getArray()[i].getMass()+" gr");
		}
		System.out.println("\n");
	}
	
	/**To see the status of the fridge's compartments and their remaining capacity**/
	private void getTheStatus() {
		System.out.print("[Meat compartment] ");
		System.out.println("Remaining capacity: "+unitOfMeats.getCapacity()+" grams");
		unitOfMeats.displayItems();
		System.out.print("[Vegetabels compartment] ");
		System.out.println("Remaining capacity: "+unitOfVegetables.getCapacity()+" grams");
		unitOfVegetables.displayItems();
		System.out.print("[Beverages compartment] ");
		System.out.println("Remaining capacity: "+unitOfBeverages.getCapacity()+" grams");
		unitOfBeverages.displayItems();
		System.out.print("[Snacks compartment] ");
		System.out.println("Remaining capacity: "+unitOfSnacks.getCapacity()+" grams");
		unitOfSnacks.displayItems();
	}
	
	/**To find maximum collectible items for this market. While finding possible high number of items,
	  it is also initialize the maximum number of the categories for this market**/
	private int minMaxItems(InventoryBag<Item> itemsList) {
		int max = 1;
		
		for(int index = 0; index < 14; index++) {
			Item item = itemsList.getArray()[index];
			int potentialMax = (new ShoppingBasket<Item>().getCapacity())/(item.getMass()); 
			if(potentialMax > max) 
				max = potentialMax;
			
			if((item.getMass()) < minQuantity)
				minQuantity = item.getMass();
			
			if(item.getCategory().equals("vegetables and fruits")) {
				if(item.getMass() < minVegetables) {
					minVegetables = item.getMass();
				}
			}else if(item.getCategory().equals("meats")) {
				if(item.getMass() < minMeats) {
					minMeats = item.getMass();
				}
			}else if(item.getCategory().equals("beverages")) {
				if(item.getMass() < minBeverages) {
					minBeverages = item.getMass();
				} 
			}else if(item.getCategory().equals("snacks")) {
				if(item.getMass() < minSnacks) {
					minSnacks = item.getMass();
				}
			}
		}
		return max;
	}
	
	/**Now that user finished her/his shopping and come to home to put them
	 @param ShoppingBasket: T = Item userBasket, Item[] items**/
	private void goToTheHome(ShoppingBasket<Item> basket) {
		while(!basket.isEmpty()) {
			Item goingTo = basket.removeByIndex(0);
			String elseStatement = String.format("\nThere are no enough space in %s compartment to put %s\nIf it can be eaten by animal, give it to them; otherwise you should trash it :(\n", goingTo.getCategory(), goingTo.getName());
			if(goingTo.getCategory().equals("meats")) {
				if(goingTo.getMass() <= unitOfMeats.getCapacity()) {
					unitOfMeats.add(goingTo);
					unitOfMeats.setCapacity(goingTo.getMass());
				}else
					System.out.println(elseStatement);
			}else if(goingTo.getCategory().equals("vegetables and fruits")) {
				if(goingTo.getMass() <= unitOfVegetables.getCapacity()) {
					unitOfVegetables.add(goingTo);
					unitOfVegetables.setCapacity(goingTo.getMass());
				}else
					System.out.println(elseStatement);
			}else if(goingTo.getCategory().equals("beverages")) {
				if(goingTo.getMass() <= unitOfBeverages.getCapacity()) {
					unitOfBeverages.add(goingTo);
					unitOfBeverages.setCapacity(goingTo.getMass());
				}else
					System.out.println(elseStatement);
			}else if(goingTo.getCategory().equals("snacks")) {
				if(goingTo.getMass() <= unitOfSnacks.getCapacity()) {
					unitOfSnacks.add(goingTo);
					unitOfSnacks.setCapacity(goingTo.getMass());
				}else
					System.out.println(elseStatement);
			}
		}
		this.getTheStatus();
	}
	
	/**This method is for adding new item to the basket in terms of it's given index.*
	 	@param intiger index  The index of the item.**/
	private void addItemToBasket(int index) {
		item = myInventoryArray.getArray()[index].getName();
		category = myInventoryArray.getArray()[index].getCategory();
		quantity = myInventoryArray.getArray()[index].getMass();
		if(quantity <= basket.getCapacity()) {
			if(basket.add(myInventoryArray.getArray()[index])) {
				numberOfItems++;
				System.out.println(String.format("\n%s is putted in the basket,", item));
				System.out.println("Number of items in basket: " + numberOfItems+"\n");
				basket.setCapacityS(quantity);
			}else
				System.out.println("It is an unpredictable exception. Something strange is happened. ");
		}else {
			System.out.println(String.format("%d grams %s exceeds your basket's current capacity of %d\n", quantity, category, basket.getCapacity()));
		}
	}
	
	/**Look whether the fridge is full or not.
	 	@return True if the fridge is full, or false otherwise.**/
	private boolean isFridgeFull() {
		if(unitOfMeats.isFull() && unitOfBeverages.isFull() && unitOfSnacks.isFull() && unitOfVegetables.isFull()) {
			return true;
		}
		return false;
	}
}




































