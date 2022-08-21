package CENG112_HW2_41;

public class MarketingAnalyst {
	private IProduct[] products = {new Sofa(), new Bed(), new Chair(), new Dresser(), new Table(), new Bookcase()}; 
	private int requestNumber;
	
	public void setNumber() {
		requestNumber = (int)(Math.random()*6);
	}
	
	public <T extends IProduct> T getProduct() {
		//The cast is safe since the array entries are null.
		@SuppressWarnings("unchecked")
		T furniture = (T) products[requestNumber];
		String name = furniture.toString();
		System.out.println(String.format("Marketing Analyst requesting %s, SUCCESS, %s manufactured", name, name));
		return furniture;
	}
}
