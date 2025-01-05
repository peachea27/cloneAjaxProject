package LEE;

public class CarMain {
	static void initCar(Car car, String brandName, String modelName, int price, String color) {
		car.brandName = brandName;
		car.modelName = modelName;
		car.price = price;
		car.color = color;
	}

	public static void main(String[] args) {
		// Car 객체 생성
		Car car1 = new Car();
		car1.displayCar();
		
		Car car2 = new Car();
		car2.brandName="기아";
		car2.modelName="k5";
		car2.price = 25000000;
		car2.color ="회색";
		car2.displayCar();
		
		Car car3 = new Car();
		initCar(car3, "제네시스","GV70", 70000000, "흰색");
		car3.displayCar();
		// 1^^이런 방법보다 속성값들을 바꿔주는건 car클래스에서 바꿔주는게 더 좋다>>Car의 멤버 메서드로
		
		Car car4 = new Car();
		car4.displayCar();//5^^브랜드명: null,모델명 :null,가격 :0, 색상 : null
		car4.createCar("기아", "모닝", 20000000, "흰색");
		car4.displayCar();//브랜드명: 기아,모델명 :모닝,가격 :20000000, 색상 : 흰색
		//6^^항상 이렇게 반복적으로 메서드를 호출해줘야 할까? 그래서 자바에서는 생성자란걸 만들 수 있게 해놓음,
//		매서드가 아니라 생성자 이용, 생성자 매우 중요★constructor: 객체를 생성하자마자 실행해야하는 기능들을 생성자로
//		>>노션 참조
		
		
		
	}

}
