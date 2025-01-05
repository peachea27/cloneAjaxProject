package lee.instanceOf;

class ParentA {
	
}

class Child extends ParentA{
	
}

public class InstanceOfMain {

	public static void main(String[] args) {
		ParentA parentA = new ParentA();
		Child child = new Child();
		
		//parentA ref = new ParentA();
		System.out.println("parentA instanceof ParentA : "+(parentA instanceof ParentA)); //true
		
		//parentA ref = new Child(); //다형성
		System.out.println("child instanceof parentA : "+(child instanceof ParentA)); //true
		
		//child ref = new ParentA();
		System.out.println("parentA instanceof Child : "+(parentA instanceof Child)); //false
		
		System.out.println("child instanceof Child : " + (child instanceof Child)); //true

	}

}
