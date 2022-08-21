
public class ratingComparator implements Comparator<Restaurant>{

	@Override
	public int compare(Restaurant first, Restaurant second) {
	    
		if(first.getRating()<second.getRating()) return 1;
		if(first.getRating()>second.getRating()) return -1;
		return 0;
		   }
		
	

}
