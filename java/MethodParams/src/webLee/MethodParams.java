package webLee;

public class MethodParams {

	public static void main(String[] args) {
		int a = 10;
		System.out.println("메서드 호출 전 a = :"+a);//10
		callPrimitiveParam(a);
		System.out.println("메서드 호출 전 a = :"+a); //10
		
		
	}

	
	static void callPrimitiveParam(int x) {
		 x = 20; //a따로 x따로, x라는 영역을 새로 생성해놓은 것
	}
	
}
