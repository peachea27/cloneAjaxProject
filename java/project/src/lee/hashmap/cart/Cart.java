package lee.hashmap.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Objects;

public class Cart {
static int cnt=22;
	Map<Product, Integer>shoppingCart =new HashMap<Product, Integer>();
	
	 void addProduct(Product product, int i) {
		 if(this.equals1(product)) {
		shoppingCart.replace(product, shoppingCart.get(product)+1);
		 }else {
		shoppingCart.put(product, i);
		 }
	}

	 void displayCart() {
		for(Entry<Product,Integer> s : shoppingCart.entrySet()) {
			System.out.println(s.getKey()+":"+s.getValue());
		}
		
	}
	 
	 

//
//	 @Override
//	 public int hashCode() {
//		 int hashcode = 0;
//		 for(Entry<Product,Integer> s : shoppingCart.entrySet()) {
//				hashcode = (s.getKey().getTitle() +s.getKey().getPrice()).hashCode();
//			}
//		return hashcode;
//	 }
//
//	 @Override
//	 public boolean equals(Object obj) {
//		boolean result = false;
//		for(Product prokey : shoppingCart.keySet()) {
//			String proTitle=prokey.getTitle();
//			int proPrice = prokey.getPrice();
//			Product tmp = (Product)obj;
//			if(tmp.getTitle().equals(proTitle) && tmp.getPrice()==proPrice) {
//				result=true;
//			}
//		}
//		return result;
//		
//	 }
	 public boolean equals1(Object obj) {
		 boolean result = false;
		 for(Product prokey : shoppingCart.keySet()) {
			 String proTitle=prokey.getTitle();
			 int proPrice = prokey.getPrice();
			 Product tmp = (Product)obj;
			 if(tmp.getTitle().equals(proTitle) && tmp.getPrice()==proPrice) {
				 result=true;
			 }
		 }
		 return result;
		 
	 }
//	 
//	 public void hashCode1() {
//		 int hashcode = 0;
//		 for(Entry<Product,Integer> s : shoppingCart.entrySet()) {
//			System.out.println(hashcode = (s.getKey().getTitle() +s.getKey().getPrice()).hashCode());
//			}
//	
//	 }
//	 
}
		

