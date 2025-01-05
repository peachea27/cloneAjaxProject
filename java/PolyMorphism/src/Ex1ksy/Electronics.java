package Ex1ksy;

public class Electronics {
	private int price;
	private int point;
	
	Electronics(int price){
		this.price = price;
		this.point =(int)(price/10);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Electronics [price=" + price + ", point=" + point + "]";
	}
	
	

}
