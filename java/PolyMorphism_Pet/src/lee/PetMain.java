package lee;

import pet.Cat;
import pet.Dog;

public class PetMain {

	public static void main(String[] args) {

		Dog myDog = new Dog("뚜비", "포메라니안", 4);
		System.out.println(myDog.toString());
		myDog.doCry();
		myDog.doWag();
		
		Cat  myCat = new Cat("나비", "샴고양이", 2);
		System.out.println(myCat.toString());
		myCat.doCry();
		myCat.doJump();
		
		System.out.println("===================================");
		PetDoctor 두리틀 = new PetDoctor("두리틀", 30);
		두리틀.doClinic(myDog);
		두리틀.doClinic(myCat);
		
		Pet 우리집애완동물 = new Dog("자바","불독",1);//업캐스팅
		우리집애완동물.doCry();//오버라이딩해놨기 때문에
		우리집애완동물.doWalk();
//		우리집애완동물.doWag()//이런건 불가능
		((Dog)우리집애완동물).doWag();//다운캐스팅으로 dog만의 메서드 호출가능 
	}

}
