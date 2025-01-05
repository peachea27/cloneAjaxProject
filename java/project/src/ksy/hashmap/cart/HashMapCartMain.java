package ksy.hashmap.cart;

public class HashMapCartMain {

	public static void main(String[] args) {

		Cart cart = new Cart();
		cart.addProduct(new Product("자바",20000),1);
		cart.addProduct(new Product("자바",20000),1);
		cart.addProduct(new Product("오라클",22000),1);
		cart.addProduct(new Product("자바",20000),1);//이름과 가격이 같으면 같은 상품: 1이 2로 올라가야함
		
		cart.displayCart(); //카트에 담긴 상품 목록
		System.out.println("오라클 책 1권 삭제");
		cart.deleteProd(new Product("오라클",22000),1);
		cart.displayCart();
		System.out.println("자바 책 2권 삭제");
		cart.deleteProd(new Product("자바",20000),2);
		cart.displayCart();
		
		//======================
//		책: "자바",가격: 20000, 수량:2
//		책:"오라클", 가격: 22000, 수량:1

	}

}
