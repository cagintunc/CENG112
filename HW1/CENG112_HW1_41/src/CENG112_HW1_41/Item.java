package CENG112_HW1_41;

public class Item {
	//For every item they're needed.
	private static int number = 1;
	private int itemsNum;
	private String name;
	private String category;
	private int mass;
	
	public Item(String name, String category, int mass) {
		this.name = name;
		this.category = category;
		this.mass = mass;
		this.itemsNum = number;
		setNumber();
	}
	/**The special toString method for see the Item object as a string when we call Item object**/
	public String toString() {
		return String.format("%s|||Category: %s|||Mass: %d\n", name, category, mass);
	}
	/*Getters*/
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public int getMass() {
		return mass;
	}
	public int getNumber() {
		return itemsNum;
	}
	/*Setters*/
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setMass(int mass) {
		this.mass = mass;
	}
	private void setNumber() {
		number++;
	}
}
