package lee.tightcoupling;

public class Remote {

	private Tv tv;
	
	public Remote() {
		tv = new Tv("Samsoong");
	}
	public void turnOnTv() {
		this.tv.powerOn();
	}
}
