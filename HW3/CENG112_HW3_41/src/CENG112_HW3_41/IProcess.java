package CENG112_HW3_41;

public interface IProcess {
	
	/**It says the type of the process
	 @return String which is the type of the process*/
	public String getType();
	
	/**It says the priority of the process in terms of number
	 0 = high
	 1 = normal
	 2 = low
	 @return Integer that indicates priority*/
	public int getPriority();
	
	/**It enables us to see process name number etc in string form which we can understand
	 @return String which describes the process*/
	public String toString();
	
}
