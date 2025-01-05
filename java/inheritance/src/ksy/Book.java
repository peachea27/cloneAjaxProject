package ksy;

public class Book extends Product {
	private String author;
	private String isbn;
	
	public Book(String name, int price, String author, String isbn) {
		super(name,price);  //Constructor call must be the first statement in a constructor
		this.author=author;
		this.isbn=isbn;
	}
	
	@Override//부모의 것을 수정해서 내가 쓰겠다
	public String display() {
		return super.display()+ "저자 : " + author + " , isbn : " +isbn;
	}
}
