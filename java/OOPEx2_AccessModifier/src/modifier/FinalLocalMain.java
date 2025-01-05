package modifier;

public class FinalLocalMain {
	int num1; // 멤버변수
	
	public static void main(String[] args) {
		// 지역변수
		final int num; //지역변수는 초기화해야 한다.
		num=10;
		System.out.println(num);
//		num=20;//The final local variable num may already have been assigned 
		//final제어자가 붙은 지역변수는 재할당 불가
		System.out.println(num);
		
		final int num2 = 20;
//		num2 = 200; //역시나 재할당 불가

		method(10);//Cannot make a static reference to the non-static method method() from the type FinalLocalMain
		//static으로 바꾸시오
	}
	

	//메서드의 매개변수에 final이 붙으면 메서드 내부에서 매개변수 값을 변경불가
	static void method(final int param) {
//		param = 20;//The final local variable param cannot be assigned.
	
	}

}
