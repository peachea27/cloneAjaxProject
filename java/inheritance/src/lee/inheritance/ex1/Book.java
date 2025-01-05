package lee.inheritance.ex1;

public class Book extends Product {
	public String author;
	public String isbn;

	public void Book(String name, int price, String author,String isbn) {
		this.Product(name, price);
		System.out.println("이 책의 제목 : " + name + ", 가격 : " +price + ", 작가 : "+author + ", isbn : "+isbn);
	}
	
	
}
