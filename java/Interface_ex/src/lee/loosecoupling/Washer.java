package lee.loosecoupling;

public class Washer implements ElectronicDevice{

	private String brandName;
	
	Washer(String brandName){
		this.brandName = brandName;
	}
	
	@Override
	public void powerOn() {
		System.out.println( this.toString() + "켜집니다.");
	}

	@Override
	public String toString() {
		return "Washer [brandName=" + brandName + "]";
	}

}
