package lee.inheritance.ex1;

public class ProductMain {

	public static void main(String[] args) {
		Book book1= new Book();
		book1.Book("This is JAVA", 30000, "Shakespeare", "E3943924343554");
		
		Movie movie1= new Movie();
		movie1.Movie("Pride and Prejudice", 10000, "Austin", 12);
		
		Album album1 = new Album();
		album1.Album("Album", 20000, "Artist");
		
		
	}

}
