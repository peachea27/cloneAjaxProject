package lee.inheritance.basic2;

public class CarMain {

	public static void main(String[] args) {
		ElectricCar electricCar = new ElectricCar();
		electricCar.startEngine();
		electricCar.accelerate();
		electricCar.charge();

		GasCar gasCar = new GasCar();
		gasCar.startEngine();
		gasCar.accelerate();
		gasCar.fillUpGas();
		
		//감속, 시동끄는 기능 Car클래스에 추가
		electricCar.decelerate();
		electricCar.turnOffEngine();
		
		gasCar.decelerate();
		gasCar.turnOffEngine();
		
		//상속을 하면 중복을 줄일 수 있고, 오류가 있을 시 Car만 수정, 추가 등 하면 됨
	
		// 부모는 자식의 멤버 사용 불가
		Car car = new Car();
//		car.charge();
		
		//소방차 추가
		FireEngine fireEngine = new FireEngine();
		fireEngine.startEngine();
		fireEngine.hoseWater();
		fireEngine.accelerate();//아주 빠르게 가속합니다.(오버라이딩)//override:무시하다,우선하다
		
		//하이브리드차//가스차를 상속받았더니 할아버지인 Car도 다 상속
		HybirdCar hybrid = new HybirdCar();
		hybrid.startEngine();
		hybrid.fillUpGas();
		hybrid.chargeOnBreak();
		
	}

}
