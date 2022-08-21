package CENG112_HW2_41;

/**This interface enables us to use the common methods*/
public interface IProduct {
	
	/**Observer
	@return True if it was manufactured or false otherwise.*/
	public boolean isManufactured();
	
	/**Observer
	@return True if it was stored or false otherwise*/
	public boolean isStored();
	
	/**Observer
	 @return True if it was sold by customer or false otherwise*/
	public boolean isSold();
	
	/**It allows us to store furniture, it changes the state of the object
	 @return True if it manage to store furniture or false otherwise.*/
	public boolean storeIt();
	
	/**It allows us to sell furniture to customer, it changes the state
	 @return True if it manage to sell the furniture, or false otherwise.*/
	public boolean sellIt();
	
}