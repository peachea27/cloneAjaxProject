package pet;

import lee.Pet;

public class Dog extends Pet {

	public Dog(String name, String type, int age) {
		super(name, type, age);
	}

	@Override
	public void doCry() {
		System.out.println("멍멍");
	}
	
	public void doWag() {
		System.out.println(getName() + "가 꼬리를 흔듭니다");
	}

	@Override
	public String toString() {
		return "[Dog]"
				+ super.toString();
	}

}
