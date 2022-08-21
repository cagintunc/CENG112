
public class priceComparator implements Comparator<Food>{
	
		
		@Override
		public int compare(Food first, Food second) {
			if(first.getPrice()<second.getPrice()) return -1;
			if(first.getPrice()>second.getPrice()) return 1;
			return 0;		}
		
	}


