package CENG112_HW2_41;

public class Bed implements IProduct{
	private static int storedNumber;
	private static int soldNumber;
	private static boolean isManufactured = false;
	
	public boolean isManufactured() {
		return isManufactured;
	}

	public boolean isStored() {
		return storedNumber > 0;
	}

	public boolean isSold() {
		return soldNumber > 0;
	}
	public String toString() {
		return "Bed";
	}
	public int getSoldNumber() {
		return soldNumber;
	}
	public int getStoredNumber() {
		return storedNumber;
	}
	public boolean storeIt() {
		storedNumber++;
		setManufactured();
		return true;
	}
	public boolean sellIt() {
		if(isStored()) {
			soldNumber++;
			storedNumber--;
			setManufactured();
			return true;
		}else {
			return false;
		}
	}
	private void setManufactured() {
		if(isStored()) {
			isManufactured = true;
		}else {
			isManufactured = false;
		}
	}
	 
}
