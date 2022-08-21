package CENG112_HW2_41;
/**This interface represents the ADT stack*/
public interface StackInterface<T> {
	
	/**Adds a new entry to the top of this stack
	 @param newEntry  An object to be added to the stack.*/
	public void push(T newEntry);
	
	/**Removes and returns the top entry of this stack
	 @return  The object at the top of the stack
	 @throws EmptyStackException if the stack is empty*/
	public T pop();
	
	/**Retrieve the top entry of this stack
	 @return  The object at the top of the stack
	 @throws EmptyStackException if the stack is empty*/
	public T peek();
	
	/**Detects whether this stack is empty
	 @return True if the stack is empty*/
	public boolean isEmpty();
	
	/**Removes all entries from this stack*/
	public void clean();
	
}
