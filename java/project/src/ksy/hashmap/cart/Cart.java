package ksy.hashmap.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Objects;

public class Cart {
	private Map<Product,Integer > cartMap = new HashMap<>();//후의 <>안쪽은 생략 가능
	
	public void addProduct(Product product, int qty) {
		//상품 추가
		int cartQty = cartMap.getOrDefault(product, 0);
		cartMap.put(product, cartQty+qty);
	}

	public void displayCart() {
		// 상품목록 출력
		for(Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
			System.out.println("책 : " + entry.getKey() + ", 수량 : " + entry.getValue());
		}
		
	}

	public void deleteProd(Product product, int qty) {
		
		int cartQty = cartMap.getOrDefault(product, 0);
		int updateQty = cartQty -qty;
		if(updateQty <=0) {
			cartMap.remove(product);
		}else {
			cartMap.put(product, updateQty);
		}
	}
	
}

