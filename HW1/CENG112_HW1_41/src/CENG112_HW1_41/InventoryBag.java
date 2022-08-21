package CENG112_HW1_41;


/**This class is for inventory bag, we used the generic T here, 
   it will be placed with Item object in advance of the program**/
public class InventoryBag<T>
{	
	private final T[] itemsArray;
	
	public InventoryBag(T[] items) {
		itemsArray = items;
	}
	public T[] getArray() {
		return itemsArray;
	}
}