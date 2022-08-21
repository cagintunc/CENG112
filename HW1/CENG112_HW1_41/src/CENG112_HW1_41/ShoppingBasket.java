package CENG112_HW1_41;


public class ShoppingBasket<T> implements IBag<T> {
	private boolean secure = false;
	private int capacity = 2000;
	private final T[] basket;
	private int numberOfItems;
	private static final int DEFAULT_NUM_ITEM = 4;
	
	/**Constructor**/
	public ShoppingBasket(int numberOfCapacity) {
		/*It is safe to cast
		   since the new array contains null entries*/
		@SuppressWarnings("unchecked")
		T[] tempBasket = (T[]) new Object[numberOfCapacity];
		basket = tempBasket;//We do that because basket is already declared.
		numberOfItems = 0;
		secure = true;
	}
	/**For any case we must write an empty constructor.**/
	public ShoppingBasket() {
		this(DEFAULT_NUM_ITEM);	
	}

	/** Adds a new item (entry) to the bag.
	 	@param newItem  The object to be added as a new item.
	 	@return True if the addition is successful, or false if not.**/
	public boolean add(T newItem) {
		//precondition: newItem != null && !this.isFull()
		//post-condition: Number of items are increased by1.
		checkSecurity();
		if(!isFull()) {
			basket[numberOfItems] = newItem;
			numberOfItems++;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return numberOfItems == 0;
	}
	
	/**This method sees whether this bag is full or not.
 	@return True if this bag is full, or false otherwise.**/
	public boolean isFull() {
		checkSecurity();
		return capacity == 0;
	}

	public T removeByIndex(int index) {
		checkSecurity();
		if(!isEmpty()) {
			T temp = basket[index];
			basket[index] = basket[numberOfItems-1];
			basket[numberOfItems-1] = null;
			numberOfItems--;
			return temp;
		}
		return null;
	}
	public T remove() {
		checkSecurity();
		if(!isEmpty()) {
			T temp = basket[numberOfItems-1];
			basket[numberOfItems-1] = null;
			return temp;
		}
		return null;
	}
	
	/*Getters*/
	public T[] getArray() {
		checkSecurity();
		if(!isEmpty()) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[numberOfItems];
			for(int i = 0; i < numberOfItems; i++) {
				newArray[i] = removeByIndex(i);
			}
			return newArray;
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
				if(basket[i].equals(item))
					return i;
			}
		}
		return -1;
	}
	/**To get the ıtem associated with the item's**/
	public T getItem(int index) {
		if((0 <= index) && (index < numberOfItems)) {
			return basket[index];
		}
		return null;
	}

	public int getCapacity() {
		return capacity;
	}
	
	/*Setter*/
	/**For the item addition**/
	public void setCapacityS(int itemMass) {
		capacity -= itemMass;
	}
	
	/**For the item remove**/
	public void setCapacityA(int itemMass) {
		capacity += itemMass;
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
				System.out.print("["+(i+1)+"]");
				System.out.print(basket[i]);
			}
			System.out.println("");
		}
	}
	
	public void dump() {
		checkSecurity();
		while(!isEmpty()) {
			remove();
		}
		
	}
	
	public boolean transferTo(IBag<T> targetBag, T item) {
		checkSecurity();
		if(!isEmpty()) {
			targetBag.add(item);
		}
		return true;
	}

	/**For Security**/
	private void checkSecurity() {
		if(!secure) {
			throw new SecurityException("ShoppingBasket object is not initialized appropriately.");
		}
	}
}
