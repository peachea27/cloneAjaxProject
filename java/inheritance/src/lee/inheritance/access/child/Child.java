package lee.inheritance.access.child;

import lee.inheritance.access.parent.Parent;

public class Child extends Parent{
	public void displayChild() {
	publicVal = 1;
	protectedVal=1;
//	defaultVal=1; //다른 패키지이므로 접근 불가
//	privateVal =1;//다른 클래스이므로 접근 불가
	
	publicMethod();
	protectedMethod();
//	defaultMethod(); //다른 패키지이므로 접근 불가
//	privateMethod();//다른 클래스이므로 접근 불가
	
	displayParent();
	}		
			
}
