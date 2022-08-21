

public class Main {
	
	private static ReadingFile f1;
	private static ReadingFile f2;

	private static FoodArray<Food> myFoodArray;
	private static RestaurantArray<Restaurant> myRestaurantArray;
	private static Food[] FoodItems = new Food[21];
    private static Restaurant[] RestaurantItems=new Restaurant[21];
	
	
	
   
	public static void main(String[] args) {
	

	   
	
        f1 = new ReadingFile();
		f2 = new ReadingFile();

		myFoodArray = f1.ReadingFile1();
		myRestaurantArray=f2.ReadingFile2();
		Comparator<Food> FoodPriceComp =new priceComparator();
		Comparator<Food> FoodStockComp=new stockComparator ();
		Comparator<Restaurant> RestaurantRatingComp= new ratingComparator();
		Comparator<Restaurant> RestaurantDeliveryComp= new deliveryComparator();
		
	   
		BST<Food> FoodPriceTree=new BST<>(FoodPriceComp);
		BST<Food> FoodStockTree=new BST<>(FoodStockComp);
		BST<Restaurant> RestaurantRatingTree=new BST<>(RestaurantRatingComp);
		BST<Restaurant> RestaurantDeliveryTree=new BST<>(RestaurantDeliveryComp);
		
		for (int i=0;i<20;i++) {
			
			RestaurantItems[i]=new Restaurant(myRestaurantArray.getArray()[i].getName(),myRestaurantArray.getArray()[i].getRating(),myRestaurantArray.getArray()[i].getCuisine(),myRestaurantArray.getArray()[i].getdeliveryTime());
			FoodItems[i]=new Food(myFoodArray.getArray()[i].getName(),myFoodArray.getArray()[i].getPrice(),myFoodArray.getArray()[i].getStock());
			FoodPriceTree.add(FoodItems[i]);
			FoodStockTree.add(FoodItems[i]);
			
			
			
		}
		
		for (int i=0;i<19;i++) {
			if(i==18) {
				RestaurantRatingTree.add(RestaurantItems[18]);
				RestaurantDeliveryTree.add(RestaurantItems[18]);
			}
				
				if(RestaurantItems[i].getRating()!=RestaurantItems[i+1].getRating()) {
					RestaurantRatingTree.add(RestaurantItems[i]);
					RestaurantDeliveryTree.add(RestaurantItems[i]);
				}
		}
        
		Iterator<Food> FoodPriceIter=FoodPriceTree.getInorderIterator();
		Iterator<Food> FoodStockIter=FoodStockTree.getInorderIterator();
		Iterator<Restaurant> RestaurantRatingIter=RestaurantRatingTree.getInorderIterator();
		Iterator<Restaurant> RestaurantDeliveryIter=RestaurantDeliveryTree.getInorderIterator();
		
		
		
		
		System.out.println("----------------- 1 -----------------");
		RestaurantRatingTree.iterativeInorderTraverse();
		System.out.println("----------------- 2 -----------------");
        FoodPriceTree.iterativeInorderTraverse();
		System.out.println("----------------- 3 -----------------");
		
		BST<Restaurant> RestaurantDeliveryTree1=new BST<>(RestaurantDeliveryComp);

		while(RestaurantDeliveryIter.hasNext()) {
			Restaurant item = RestaurantDeliveryIter.next();
			String name= item.getCuisine();
			String p = " Pizza";
			if(name.equals(p)) {
			RestaurantDeliveryTree1.add(item);
			}
		}
		String itemMinName = RestaurantDeliveryTree1.findMin().getName();
		int itemMinDelivery = RestaurantDeliveryTree1.findMin().getdeliveryTime();
		//System.out.println("   "+itemMinName+"            "+itemMinDelivery);
		System.out.format("%1$-30s%2$-10d\n",itemMinName,itemMinDelivery);
		
		System.out.println("----------------- 4 -----------------");
		
		System.out.print(FoodStockTree.findMax()+"\n");
		
		
		
		
		System.out.println("----------------- 5 -----------------");
        
		while(FoodPriceIter.hasNext()) {
			
			Food item = FoodPriceIter.next();
			double itemPrice = item.getPrice();
			if(itemPrice>80) {
				System.out.format("%1$-20s%2$-10.2f%3$-30s\n",item.getName(),item.getPrice(),"Removed");
                FoodPriceTree.remove(item);
				
			}
		}
		System.out.println("----------------- 6 -----------------");
		while(RestaurantRatingIter.hasNext()) {
			Restaurant item = RestaurantRatingIter.next();
			double itemRate = item.getRating();
			if(itemRate<8.0) {
				System.out.format("%1$-20s%2$-10.1f%3$-30s\n",item.getName(),item.getRating(),"Removed");
	
				RestaurantRatingTree.remove(item);
			}
		}
		System.out.println("----------------- 7-----------------");
		Iterator<Food> FoodPriceIter1=FoodPriceTree.getInorderIterator();
		while(FoodPriceIter1.hasNext()) {
			Food item = FoodPriceIter1.next();
			item.updatePrice((item.getPrice()));
			
			
		}
		System.out.println("Prices in FoodBSTs are updated.");
		System.out.println("----------------- 8 -----------------");
		while(FoodStockIter.hasNext()) {
			Food item = FoodStockIter.next();
			item.updateStock(item.getStock());
			
		}
		System.out.println("Stocks in FoodBSTs are updated.");
		System.out.println("----------------- 9 -----------------");
		RestaurantRatingTree.iterativeInorderTraverse();
		
		System.out.println("----------------- 10 -----------------");
		
        FoodPriceTree.iterativeInorderTraverse();
		
	}
	
}










	
	

