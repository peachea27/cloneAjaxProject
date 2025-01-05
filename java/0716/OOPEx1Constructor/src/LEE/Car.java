package LEE;

public class Car {
	//멤버변수 2-1^^주석처리
//	 String brandName = "현대";
//	 String modelName="그랜져";
//	 int price =45000000;
//	 String color = "검정색";
	
	//3^^
	String brandName;
	String modelName;
	int price;
	String color;
	
	
	 //2^^멤버 메서드
	 void createCar(String brandName, String modelName, int price, String color) {
		 this.brandName = brandName; //4^^brandName을 클릭해보면 무엇을 참조하는지 색깔로 알수있음
		 //이름이 같은 두 brandName들을 구분해주기 위해서 this를 붙임//붙여야 잘 찾아준다
		 this.modelName=modelName;
		 this.price=price;
		 this.color=color;
	 }
	
	 public void displayCar() {
		 System.out.println("브랜드명: " + brandName + ",모델명 :" + modelName + ",가격 :" + price + 
				 ", 색상 : " + color );
	 }
}
