package ksy;

public class ProductMain {

	public static void main(String[] args) {
		//
		Book book = new Book("자바",20000, "신용권 외","1020302");
		Movie movie = new Movie("인사이드아웃", 9000, "감독이름", "전체관람가");
		Album album = new Album("스무살",30000,"아이유");
		
		System.out.println(book.display()); 
		System.out.println(movie.display());  
		System.out.println(album.display());  
		
		int total = book.getPrice() + movie.getPrice()+ album.getPrice(); 
		System.out.println("총 상품 가격 : " + total);

	}

}
