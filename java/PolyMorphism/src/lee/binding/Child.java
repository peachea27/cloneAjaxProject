package lee.binding;

public class Child extends Parent {
	int x =20;
	
	@Override
	void method() {
		System.out.println("Child.method()호출");
		System.out.println("x="+x);
		System.out.println("this.x="+this.x);
		System.out.println("super x ="+super.x);
		
	}
	
	void childMethod() {
		System.out.println("Child.method()");
	}
}
