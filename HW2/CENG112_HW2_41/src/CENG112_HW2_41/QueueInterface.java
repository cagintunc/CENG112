package CENG112_HW2_41;
/**This interface is about Queue interface (Which is the FIFO structure)**/

public interface QueueInterface<T> {
	
	/**It adds the given item to the back of the queue.
	 @param newItem  The item to be added to the queue.*/
	public void enqueue(T newItem);
	
	/**It removes the item from the front of the queue, and returns the item which was removed
	 @return The item which was removed from the front of the queue.*/
	public T dequeue();
	
	/**It retrieves the item at the front of the queue
	 @return The item at the front of the queue.*/
	public T getFront();
	
	/**Observer; it enables us to know whether the queue is empty or not.
	 @return True if the queue is empty, or not otherwise.*/
	public boolean isEmpty();
	
	/**It removes the whole entries from the queue.*/
	public void clean();
	
	
}
