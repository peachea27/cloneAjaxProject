package Ex1;

public class Appliance {

	private int price;
	private String product;
	
	Appliance(String product,int price) {
		this.product=product;
		this.price=price;
	}
	

	public String getProduct() {
		return product;
	}

	public int getPrice() {
		return price;
	}
	
}
