package lee.tightcoupling;

public class Tv {
	
	private String brandName;
	
	Tv(String brandName){
		this.brandName = brandName;
	}
	
	public void powerOn() {
		System.out.println(brandName+"TV가 켜집니다.");
	}

}
