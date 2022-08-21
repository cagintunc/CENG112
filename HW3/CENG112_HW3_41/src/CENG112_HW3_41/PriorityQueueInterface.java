package CENG112_HW3_41;

public interface PriorityQueueInterface<T extends Comparable<? super T>> {
	
	/**Add a new entry at back of the queue
	 @param generic type newEntry which will be added to the queue*/
	public void add(T newEntry);
	
	/**Remove and retrieve the entry from the front of this priority queue
	 @return the entry which was deleted*/
	public T remove();
	
	/**Retrieve the entry from the front of this queue
	 @return the entry at the front of the queue*/
	public T peek();
	
	/**It enables us to observe whether the queue is empty or not
	 @return True if it is empty, false otherwise*/
	public boolean isEmpty();
	
	/**It enables us to learn the size of the queue
	@return Integer  which indicates the number of entries in the queue*/
	public int getSize();
	
	/**It removes whole entries in the queue*/
	public void clear();
	
}
