package LEEex;

public class CartMain {

	public static void main(String[] args) {
		Cart cart = new Cart();

		Book book1 = new Book("자바", 20000, 2);
		Book book2 = new Book("JSP", 22000, 3);
		
		book1.displayBooks();
		book2.displayBooks();

		cart.addBook(book1);
		cart.addBook(book2);
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		cart.addBook(new Book("오라클", 30000, 1));
		//java.lang.ArrayIndexOutOfBoundsException: 10 :배열 크기를 넘어섬


		cart.displayBooks();  // 장바구니 상품을 출력하고, 전체 가격의 총합을 출력한다.

	}

}
