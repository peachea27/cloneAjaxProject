package LEE;

public class Book {
	//멤버 변수 : 제목(title), 저자(author), 가격(price)
	String title;
	String author;
	int price;
	
	// 생성자 
	public Book() {
		//제목: , 저자 : , 가격: 0
		this("",""); //바로 밑의 생성자를 호출한 것
	}
	
	public Book(String title, String author) {
//		this.title=title;
//		this.author=author;
//		this.price =0;
		this(title,author,0);
	}
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author =author;
		this.price =price;
		
	}


	//메서드
	public void displayBook() {
		System.out.println("제목 : " +title +",저자"+author+",가격"+price);
	}
	
}
	
	

	
