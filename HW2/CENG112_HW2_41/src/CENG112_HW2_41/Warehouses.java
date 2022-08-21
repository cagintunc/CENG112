package CENG112_HW2_41;

import java.util.*;
/**The class Warehouses which implements the StackIterface*/
public class Warehouses<T> implements StackInterface<T> {
	
	private T[] warehouse;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAXIMUM_CAPACITY = 1000;
	
	/**Constructor*/
	public Warehouses() {
		this(DEFAULT_CAPACITY);
	}
	public Warehouses(int capacity) {
		assert checkCapacity(capacity);
		/*It is safe to cast since the array initialized with null entries.*/
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[capacity]; 
		warehouse = tempStack;
		topIndex = -1;
		initialized = true;
	}
	
	public void push(T newEntry) {
		checkInitialization();
		ensureCapacity();
		warehouse[topIndex+1] = newEntry;
		System.out.print(String.format(" SUCCESS, %s stored ", newEntry.toString()));
		topIndex++;
	}
	public T pop() {
		checkInitialization();
		T top = peek(); //Might throw EmptyStackException
		warehouse[topIndex] = null;
		topIndex--;
		return top;
	}
	public T peek() {
		checkInitialization();
		if(isEmpty()) 
			return null;
		else {
			T top = warehouse[topIndex];
			return top;
		}
	}
	public boolean isEmpty() {
		checkInitialization();
		return topIndex == -1;
	}
	public void clean() {
		checkInitialization();
		while(!isEmpty())
			pop();
	}
	/**We must sure certain things happened in a way that what we expect.*/
	private void ensureCapacity() {
		if(topIndex == warehouse.length - 1) {
			int newLength = 2 * warehouse.length;
			assert checkCapacity(newLength);
			warehouse = Arrays.copyOf(warehouse, newLength);
		}
	}
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException();
		}
	}
	private final boolean checkCapacity(int capacity) {
		return capacity <= MAXIMUM_CAPACITY;
	}
}
