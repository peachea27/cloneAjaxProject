package lee.hashmap.cart;

import java.util.Map.Entry;
import java.util.Objects;

public class Product {
	private String title;
	private int price;
	
	Product(String title,int price){
		this.title =title;
		this.price =price;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return price == other.price && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + "]";
	}
}
