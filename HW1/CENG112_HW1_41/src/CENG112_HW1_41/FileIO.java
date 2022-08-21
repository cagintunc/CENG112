package CENG112_HW1_41;
import java.io.*;
import java.util.*;
public class FileIO {
	private InventoryBag<Item> itemsArray;
	private Item[] items = new Item[14];
	
	/**This method include the file reading of the market.**/
	public InventoryBag<Item> readInventory() {
		try{
			Scanner scanner = new Scanner(new FileReader("inventory.txt"));
			int i = 0;
			while(scanner.hasNextLine()) {
				String token = scanner.nextLine();
				String[] separatedToken = token.split(",");
				items[i] = new Item(separatedToken[0],separatedToken[1],Integer.parseInt(separatedToken[2]));
				itemsArray = new InventoryBag<>(items);
				i++;
			}
			return itemsArray;
		}catch(IOException ex) {
			System.out.println("File cannot be found.");
			ex.printStackTrace();
		}
		return null;
	}
	public InventoryBag<Item> getInventoryArray() {
		return itemsArray;
	}
}
