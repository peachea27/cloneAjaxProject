package lee.inheritance.ex1;

public class Movie extends Product{
	public String director;
	public int rate;
	
	public void Movie(String name, int price, String director,int rate) {
		this.Product(name, price);
		System.out.println("이 영화의 제목 : " + name + ", 가격 : " +price + ", 감독 : "+director + ", 등급 : "+rate);
	}
	}

