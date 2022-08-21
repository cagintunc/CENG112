package CENG112_HW1_41;

public class SnacksCompartment<T> implements IBag<T> {
	private int capacity;
	private T[] items;
	private int numberOfItems;
	private boolean secure = false;
	
	public SnacksCompartment(int maxNumber) {
		/**It is safe to cast
		   since the new array contains null entries**/
		@SuppressWarnings("unchecked")
		T[] tempItems = (T[]) new Object[maxNumber];
		items = tempItems;//We do that because item is already declared.
		numberOfItems = 0;
		capacity = 2000;
		secure = true;
	}
	
	
	/* Adds a new item (entry) to the bag.
	 	@param newItem  The object to be added as a new item.
	 	@return True if the addition is successful, or false if not.*/
	public boolean add(T newItem) {
		//precondition: newItem != null && !this.isFull()
		//post-condition: Number of items are increased by1.
		checkSecurity();
		if(!isFull()) {
			items[numberOfItems] = newItem;
			numberOfItems++;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return numberOfItems == 0;
	}
	
	/*This method sees whether this bag is full or not.
 	@return True if this bag is full, or false otherwise.*/
	public boolean isFull() {
		checkSecurity();
		return numberOfItems >= items.length;
	}

	public T removeByIndex(int index) {
		checkSecurity();
		if(!isEmpty()) {
			T temp = items[index];
			items[index] = null;
			numberOfItems--;
			return temp;
		}
		return null;
	}
	public T remove() {
		checkSecurity();
		if(!isEmpty()) {
			T temp = items[numberOfItems-1];
			items[numberOfItems-1] = null;
			numberOfItems--;
			return temp;
		}
		return null;
	}
	
	public int getItemCount() {
		checkSecurity();
		return numberOfItems;
	}
	
	public int getIndexOf(T item) {
		checkSecurity();
		if(!isEmpty()) {
			for(int i = 0; i < numberOfItems; i++) {
				if(items[i].equals(item))
					return i;
			}
		}
		return -1;
	}
	
	public void setCapacity(int itemMass) {
		capacity -= itemMass;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean contains(T item) {
		checkSecurity();
		boolean result = false;
		if(!isEmpty()) {
			if(getIndexOf(item) >= 0)
				result = true;
		}
		return result;
	}
	
	public void displayItems() {
		checkSecurity();
		if(!isEmpty()) {
			for(int i = 0; i < numberOfItems; i++) {
				System.out.println(items[i]);
			}
			System.out.println("------------------------------------");
		}else {
			System.out.println("- This compartment is Empty\n");
			System.out.println("------------------------------------");
		}
	}
	
	public void dump() {
		checkSecurity();
		while(!isEmpty()) {
			remove();
		}
		numberOfItems = 0;
	}
	
	public boolean transferTo(IBag<T> targetBag, T item) {
		checkSecurity();
		if(!isEmpty()) {
			targetBag.add(item);
			return true;
		}
		return false;
	}

	/*For Security*/
	private void checkSecurity() {
		if(!secure) {
			throw new SecurityException("MeatsCompartement object is not initialized appropriately.");
		}
	}
}
