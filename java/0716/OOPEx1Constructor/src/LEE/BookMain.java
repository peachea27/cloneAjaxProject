package LEE;

public class BookMain {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.displayBook(); //책 속성값 출력(제목,저자, 가격)
		
		Book book2 = new Book("자바","신용권 외");
		book2.displayBook(); //책 속성값 출력
		
		Book book3 = new Book("오라클","이지훈",23000);
		book3.displayBook();

//		Book book4 = new Book("자바","",0);
	}

}
