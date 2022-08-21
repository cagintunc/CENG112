package CENG112_HW1_41;

/** An interface that describes the operations of a bag of objects.
 	@author Nil Su Demir, Çağın Tunç.
 **/

public interface IBag<T> 
{
	
	/** Adds a new item (entry) to the bag.
	 	@param newItem  The object to be added as a new item.
	 	@return True if the addition is successful, or false if not.**/
	public boolean add(T newItem);
		//pre-condition ::= !this.isFull()
	
	/** This method sees whether this bag is empty or not.
	 	@return True if this bag is empty, or false otherwise.**/
	public boolean isEmpty();
	
	/** This method sees whether this bag is full or not.
	 	@return True if this bag is full, or false otherwise.**/
	public boolean isFull();
	
	/** This method removes the item from the bag from its index.
	  	@param index  The integer that shows the index of the item to be removed.
	  	@return Either the removed item, if the removal was successful, or null.**/
	public T removeByIndex(int index);
		//pre-condition ::= !this.isEmpty()
	
	/** This method removes one unspecified item from this bag, if it is possible.
	 * 	@return Either the removed item, if the removal was successful, or null.**/
	public T remove();
		//pre-condition ::= !this.isEmpty()
	
	/** This method gets the current count of items in this bag.
	  	@return The integer number of items currently in this bag.**/
	public int getItemCount();
	
	/** This method gets the index of the given item in this bag.
	  	@param item  The item to be searched for its index in the bag.
	  	@return The index of the item, if it is in this bag, -1 otherwise.**/
	public int getIndexOf(T item);
		//pre-condition ::= !this.isEmpty()
	
	/** This method test whether this bag contains a given item.
	  	@param item  The item to be searched for occurrence.
	  	@return True if it contains an item, or false otherwise.**/
	public boolean contains(T item);
	
	/** This method displays the items in this bag.**/
	public void displayItems();
	
	/** This method removes all the items from the bag.**/
	public void dump();
		//pre-condition ::= !this.isEmpty()
			
	/** This method transfers the item of this bag to the another bag.
	 	@param targetBag, item  
	 	@return True if the transfer is accomplished, or false otherwise.**/
	public boolean transferTo(IBag<T>targetBag, T item);
	
}
