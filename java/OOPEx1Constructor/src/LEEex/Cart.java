package LEEex;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Cart {
	//멤버변수
	private Book[] books=new Book[10];//null이 들어가있다
	private int cnt=0;
	
	//생성자(기본 생성자는 필요하다)
	public Cart() {
		
	}
	
	//메서드
	public void addBook(Book book) {
		if(cnt >=books.length) {
			System.out.println("장바구니에는 10개까지만 담을 수 있습니다.");
			return;//특정 조건이 만족될 때 매서드의 실행을 중단
			}
//		else {	굳이 else를 넣지 않아도 됨. else에 넣으면 주된 내용같지 않고 쩌리같아지니까...
		books[cnt++]=book;
		System.out.println(cnt+"권");
	}
	
	public void displayBooks() {
	
		System.out.println("------------------장바구니 ---------------------------");
		for (int i =0; i < cnt; i++) {//다 돌리면 null이 들어가므로 null.~를 소환하면 안나옴
			Book book = books[i];
			System.out.println("상품명: "+book.getTitle()+",가격 : "+book.getPrice()+", 수량 : "+book.getQuantity());
		}
		System.out.println("--------------------------------------------------- ");
		System.out.println("총상품수: " + cnt + ", 총 가격 : "+ calculateTotalPrice() +"원");
	}
	
	//calculateTotalPrice는 book이 아닌, 카트에서 만드는게 적절// 또한 private이 적절
	private int calculateTotalPrice() {
		int totalPrice = 0;
		for (int i = 0; i < cnt ; i++) {
			totalPrice += books[i].getTotalPrice();
		}
		return totalPrice;
	}
	
}
