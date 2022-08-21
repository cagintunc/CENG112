package CENG112_HW3_41;

public interface ListInterface<T> {
	
	/**Add a new entry at back of the list
	 @param generic type newEntry which will be added to the linked list back*/
	public void add(T newEntry);
	
	/**Add a new entry at the specific position of the queue
	 @param Integer which is the position of the newEntry
	 @param generic type newEntry which will be added to the linked list*/
	public void add(int givenIndex, T newEntry);
	
	/**Removes and  retrieves the entry from the back of the list
	 @return The removed entry*/
	public T remove();
	
	/**Removes and retrieves the entry from the given index of the list
	 @param Integer the index of the entry which will be removed
	 @return The removed entry*/
	public T remove(int givenIndex);
	
	/**Retrieves the entry at the given position in the list
	 @param Integer the index of the entry which will be gotten by the client
	 @return The entry at the given position*/
	public T getEntry(int givenIndex);
	
	/**Replace the entry which is at the given index by the given new entry and returns the the old entry
	 @param Integer the index that the replacement will be occurred
	 @param The new entry that will be settled in the given index
	 @return The old entry which is removed(replaced by new one) in the given index*/
	public T replace(int givenIndex, T newEntry);
	
	/**It is a converter that enables us to convert our implementation into the array
	 @return The array of type entries in that list*/
	public T[] toArray();
	
	/**It enables us to learn the size of the list
	 @return Integer which accounts for the size of the list*/
	public int getLentgh();
	
	/**It can say us whether a given entry is in the list or not
	 @return True if the entry is in the list, or false otherwise*/
	public boolean contains(T anEntry);
	
	/**It enables us to observe whether the list is empty or not
	 @return True if it is empty, false otherwise*/
	public boolean isEmpty();
	
	/**It removes whole entries in the queue*/
	public void clear();
	
}
