package lee;

import pet.Cat;
import pet.Dog;

public class PetDoctor {
	
	private String name;
	private int age;
	
	public PetDoctor(String name, int age) {
		super();
		this.name = name;
		this.age =age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	//메서드
//	public void doClinic(Dog d) {
//		System.out.println(d.toString() + "을 치료합니다.");
//	}
//	public void doClinic(Cat c) {
//		System.out.println(c.toString() + "을 치료합니다.");
//	}
//	
	public void doClinic(Pet pet) {//다형성
		System.out.println(pet.toString() + "을 치료합니다.(다형성)");
	}

	@Override
	public String toString() {
		return "PetDoctor [name=" + name + ", age=" + age + "]";
	}
}
