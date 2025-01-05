package lee.inheritance.basic1;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		car.startEngine();
		car.accelerate();
		
		GasCar gasCar = new GasCar();
		gasCar.startEngine();
		gasCar.accelerate();
		
		ElectricCar electricCar = new ElectricCar();
		electricCar.startEngine();
		electricCar.accelerate();
	}

}
