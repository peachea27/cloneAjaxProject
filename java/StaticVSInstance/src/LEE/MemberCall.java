package LEE;

public class MemberCall {
//멤버변수
	int iv = 10; // 인스턴스 변수
	static int cv = 20; //클래스( 정적, static) 변수
	
	int iv2 = cv;
//	static int cv2 = iv;//Cannot make a static reference to the non-static field iv
	//클래스 변수는 인스턴스 변수를 사용할 수 없다
	
	
	//정적 메서드
	static void staticMethod1() {
		System.out.println("cv = " + cv); //20
//		System.out.println(iv); //Cannot make a static reference to the non-static field iv
		//정적(static) 메서드 안에서 인스턴스 변수를 사용할 수 없다.
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv); // 10 -객체 생성 후에야 인스턴스 변수의 참조 가능
	}
	
	//인스턴스 메서드 //인스턴스에서는 다 불러올 수 있음
	void instanceMethod1() {
		System.out.println("instance method1 : cv = " + cv);
		System.out.println("instance method1 : iv = " + iv);
	}
	
	public static void main(String[] args) {
//여기서 선언하면 main 메소드 안의 지역변수	
		staticMethod1(); //스테틱 메서드
//		instanceMethod1();//인스턴스 메서드를 호출하려하지만 static main에서 불가능
		MemberCall mc = new MemberCall();
		mc.instanceMethod1(); //인스턴스 메서드
	}

}
