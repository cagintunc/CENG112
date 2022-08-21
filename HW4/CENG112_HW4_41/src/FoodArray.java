
public class FoodArray<T>{
 private final T[] itemsArray;
	
	public FoodArray(T[] items) {
		itemsArray = items;
	}
	public T[] getArray() {
		return itemsArray;
	}
	public int getLength() {
    	return itemsArray.length;
    }

}
