
public class stockComparator implements Comparator<Food>{
	
			@Override
			public int compare(Food first, Food second) {
				return (int) (first.getStock()-second.getStock());
			}
			

}
