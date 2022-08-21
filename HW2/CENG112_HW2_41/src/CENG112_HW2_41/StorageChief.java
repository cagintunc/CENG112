package CENG112_HW2_41;

public class StorageChief {
	
	private Warehouses<IProduct> warehouses;
	
	public StorageChief() {
		warehouses = new Warehouses<>();
	}
	public void setProduct(IProduct product) {
		System.out.print(String.format("Storage Chief storing %s,", product));
		warehouses.push(product);
		product.storeIt();
		System.out.println(String.format("in %s warehouse", product));
	}
	public IProduct getProduct() {
		return warehouses.peek();
	}
	public void displayWarehouses() {
		System.out.println("Amount of Sofa in Sofa Warehouse: "+(new Sofa().getStoredNumber()));
		System.out.println("Amount of Bed in Bed Warehouse: "+(new Bed().getStoredNumber()));
		System.out.println("Amount of Chair in Chair Warehouse: "+(new Chair().getStoredNumber()));
		System.out.println("Amount of Dresser in Dresser Warehouse: "+(new Dresser().getStoredNumber()));
		System.out.println("Amount of Table in Table Warehouse: "+(new Table().getStoredNumber()));
		System.out.println("Amount of Bookcase in Bookcase Warehouse: "+(new Bookcase().getStoredNumber()));
	}
	public void displaySold() {
		System.out.println("Amount of Sofa sold: "+(new Sofa().getSoldNumber()));
		System.out.println("Amount of Bed sold: "+(new Bed().getSoldNumber()));
		System.out.println("Amount of Chair sold: "+(new Chair().getSoldNumber()));
		System.out.println("Amount of Dresser sold: "+(new Dresser().getSoldNumber()));
		System.out.println("Amount of Table sold: "+(new Table().getSoldNumber()));
		System.out.println("Amount of Bookcase sold: "+(new Bookcase().getSoldNumber()));
	}
}
