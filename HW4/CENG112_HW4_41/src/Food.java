
public class Food  implements Orderable{
	
	private String name;
	private Double price;
	private int stock;
	private Restaurant restaurant;
	
	public Food(String name, double price,int stock ) {
		this.name=name;
		this.price=price;
		this.stock=stock;
	}
	


	public String toString() {
		return String.format("%1$-20s%2$-10.2f%3$-20d", name, price, stock);
	}                        
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	
	
	


	@Override
	public void updatePrice(double price) {
		this.price=price*1.2;
		
	}


	@Override
	public void updateStock(int stock) {
		this.stock=stock/2;
		
	}
	
}