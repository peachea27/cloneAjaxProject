package LEEex;

public class Book {
//멤버변수 -> 생성자 -> 메소드 순으로 영역 할당
	private String title;
	private int price;
	private int quantity;
	
	public Book(String title, int price, int quantity) {
		this.title=title;
		this.price=price;
		this.quantity=quantity;
		
	}
	
	//메서드
	//getter
	
	public String getTitle() {
		return this.title;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public int getTotalPrice() {
		return this.price*this.quantity;
	}
	
	public void displayBooks() {
		System.out.println("Book title : " + this.title + ", price: " + this.price
				+" , quantity : "+this.quantity);
	}
}
