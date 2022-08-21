
public class Restaurant {
	private String name;
	private Double rating;
	private String cuisine;
	private int deliveryTime; // in minutes
	
	public Restaurant(String name, double rating, String cuisine,int deliveryTime) {
		this.name=name;
		this.rating=rating;
		this.cuisine=cuisine;
		this.deliveryTime=deliveryTime;
	}
	public String toString() {
		return String.format("%1$-30s%2$-10.1f", name, rating);
	}
	public String getName() {
		return name;
	}
	public double getRating() {
		return rating;
	}
	public String getCuisine() {
		return cuisine;
	}
	public int getdeliveryTime() {
		return deliveryTime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRating(double rating){
		this.rating=rating;
	}
	public void setCuisine(String cuisine) {
		this.cuisine=cuisine;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime=deliveryTime;
	}
	
	public void updateCuisine(String category) {
		this.cuisine=category;
	}
	public void updateRating(double score) {
		this.rating=score;
	}
	public void updateDeliveryTime(int deliveryTime) { 
        this.deliveryTime=deliveryTime;
	}
	

	
	
	
	
	

}
