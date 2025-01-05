package ksy;

public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
//		super();//생략가능
		this.name = name;
		this.price =price;
	}

	public int getPrice() {
		return price;
	}
	
	public String display() {
		return "Product [이름=" + name + ", 가격=" + price + "]";
	}

//	@Override //generate toString
//	public String toString() {
//		return "Product [name=" + name + ", price=" + price + "]";
//	}

}
