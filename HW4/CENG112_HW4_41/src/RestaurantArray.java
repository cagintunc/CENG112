
public class RestaurantArray<T> {

 private final T[] itemsArray;
	
	public RestaurantArray(T[] items) {
		itemsArray = items;
	}
	public T[] getArray() {
		return itemsArray;
	}
    public int getLength() {
    	return itemsArray.length;
    }
}

