import java.io.*;
import java.io.File;
import java.util.Scanner;

public class ReadingFile {
	private FoodArray<Food> itemsArray;
	private Food[] items = new Food[21];
	private RestaurantArray<Restaurant> itemsArray1;
	private Restaurant[] items1 = new Restaurant[21];
	
	public FoodArray<Food> ReadingFile1()  {
		try{
			Scanner scanner = new Scanner(new File("CENG112_HW4.csv"));
			int i = 0;
			while(scanner.hasNextLine()) {
				String token = scanner.nextLine();
				String[] separatedToken = token.split(",");
				if (i!=0) {
					items[i-1] = new Food(separatedToken[0],Double.parseDouble(separatedToken[1]) ,Integer.parseInt((separatedToken[2]).trim()));

					itemsArray = new FoodArray<>(items);
				}
				
				i++;
			}
			
			return itemsArray;
		}catch(IOException ex) {
			System.out.println("File cannot be found.");
			ex.printStackTrace();
		}
		return null;
	}
	public FoodArray<Food> getInventoryArray() {
		return itemsArray;
	}
	
	public RestaurantArray<Restaurant> ReadingFile2()  {
			try{
				Scanner scanner = new Scanner(new File("CENG112_HW4.csv"));
				int i = 0;
				while(scanner.hasNextLine()) {
					String token = scanner.nextLine();
					String[] separatedToken = token.split(",");
					if (i!=0) {
						items1[i-1]=new Restaurant(separatedToken[3],Double.parseDouble(separatedToken[4]),separatedToken[5],Integer.parseInt((separatedToken[6]).trim()));
						itemsArray1 = new RestaurantArray<>(items1);

					}
					
					
					i++;
				}
				
				return itemsArray1;
			}catch(IOException ex) {
				System.out.println("File cannot be found.");
				ex.printStackTrace();
			}
			return null;
		}
		public RestaurantArray<Restaurant> getInventoryArray1() {
			return itemsArray1;
		
		
		
	}
}