package pet;

import lee.Pet;

public class Cat extends Pet{

	public Cat() {
		super();
	}
	public Cat(String name, String type, int age) {
		super(name, type, age);
//		this();
//		super.setName(name);
	}
	
	@Override
	public void doCry() {
		System.out.println("야옹야옹");
	}
	
	public void doJump() {
		System.out.println(getName()+"가 점프한다.");
	}
	public String toString() {
		return "[Cat]" + super.toString();
	}
}
