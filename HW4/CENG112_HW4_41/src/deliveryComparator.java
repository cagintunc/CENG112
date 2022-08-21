
public class deliveryComparator implements Comparator<Restaurant>{

	@Override
	public int compare(Restaurant first, Restaurant second) {
		return (int) (first.getdeliveryTime()-second.getdeliveryTime());
	}

}
