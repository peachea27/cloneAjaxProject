package Ex1ksy;

public class Tv extends Electronics {

//	Tv(int price) {
//		super(price);
//	}
	
	Tv(){
		super(200000);
	}

	@Override
	public String toString() {
		return "Tv ["+getPrice() +"원,포인트:"+ getPoint()+"원]";
	}

//	@Override
//	public String toString() {
//		return "Tv [getPrice()=" + getPrice() + ", getPoint()=" + getPoint() + ", toString()=" + super.toString()
//				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
//	}
	//tv인데 아무것도 가진게 없으니 부모가 가진 요소가 다 나옴

}
