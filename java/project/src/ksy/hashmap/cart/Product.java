package ksy.hashmap.cart;

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
		return Objects.hash(price,title);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Product) {
			Product tmp = (Product)obj;
			if(this.price == tmp.price && this.title.equals(tmp.title)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + "]";
	}
}
