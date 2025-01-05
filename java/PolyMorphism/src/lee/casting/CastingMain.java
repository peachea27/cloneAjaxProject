package lee.casting;

public class CastingMain {

	public static void main(String[] args) {
		Car car = new Car();
		car.drive();
		
		//다운캐스팅(부모타입 => 자손타입)
		FireEngine fireEngine =(FireEngine) car;
		//Type mismatch: cannot convert from Car to FireEngine
		//부모타입에서 자식타입으로의 캐스팅은 자동으로 안됨
//		fireEngine.hoseWater();
		//타입은 맞아서 컴파일상 에러는 없는데 실행을 하니 런타임 오류 생김
		//:lee.casting.Car cannot be cast to lee.casting.FireEngine
		//그러면 도대체 물은 어떻게 뿌릴 수 있을까
		
		
		
		Car poly = (Car) new FireEngine(); //업캐스팅(자손타입 -> 부모타입)
		poly.drive();
//		poly.hoseWater();//불가능
		
		//업캐스팅한 후, 다운캐스팅
		//다운캐스팅
		FireEngine fireEngine2 = (FireEngine) poly;
		fireEngine2.hoseWater();
		fireEngine2.drive();
	}

}
