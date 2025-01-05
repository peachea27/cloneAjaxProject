package lee.inheritance.ex1;

public class Album extends Product {
	public String artist;
	
	public void Album(String name, int price, String artist) {
		this.Product(name, price);
		System.out.println("이 앨범의 제목 : " + name + ", 가격 : " +price + ", 아티스트 : "+artist);
	}
}
