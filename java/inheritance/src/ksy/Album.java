package ksy;

public class Album extends Product {
	private String artist;
	public Album(String name, int price, String artist) {
		super(name, price);
		this.artist = artist;
	}
	
	public String display() {
		return super.display()+"아티스트 : "+artist;
	}

}
