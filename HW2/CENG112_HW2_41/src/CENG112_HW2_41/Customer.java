package CENG112_HW2_41;
public class Customer {
	private IProduct[] products = {new Sofa(), new Bed(), new Chair(), new Dresser(), new Table(), new Bookcase()};
	private int customerChoice;
	
	public void setNumber() {
		customerChoice = (int)(Math.random()*6);
	}
	public <T extends IProduct> void searchInWarehouse() {
		// compiler warnings should be suppressed, since T is a subclass of IProduct
		@SuppressWarnings("unchecked")
		T furniture = (T) products[customerChoice];
		String name = furniture.toString();
		System.out.print(String.format("Customer buying %s, ",name));
		if(furniture.sellIt()) {
			System.out.println(String.format("SUCCESS, Customer bought %s", name));
		}
		else
			System.out.println(String.format("FAIL, %s warehouse empty", name));
	}
}
