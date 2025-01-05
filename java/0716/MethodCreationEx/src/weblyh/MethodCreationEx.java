package weblyh;

public class MethodCreationEx {
	
	public static int add(int a, int b) {
		return a+b;
	}

	public float add(float a, float b) {
		float c = 0f;
		c = a + b;
		//return a + b;
		return c;
	}
	
	//오버로딩 : 같은 매서드 다른 매개변수
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	public long add (int a, long b) {
		return a+b;
	}
	
	
	
	public void outputNTimes(String str, int n) {//void:반환값은 필요없다
		for(int i = 0; i < n; i++) {
		System.out.println(str);
		}
	}
	
	
	public static void main(String[] args) {
		//메서드
		//[접근제한자][static] 반환값타입 | void 메서드 이름 ([매개변수 타입 매개변수이름])  { // 메서드 선언부
			//메서드 body
//			[return 반환값;]
		//}
		
		int result =MethodCreationEx.add(300, 500); //클래스이름. 메서드이름 : (정적)static한 메서드를 만들겠다는 것
		System.out.println("result: "+result);
		
		int result2 = add(6,9); //호출하는 곳과 호출되는 클래스가 같다면 메서드 호출시 클래스명 생략 가능
		System.out.println("result2: "+result2);
		
		MethodCreationEx mce = new MethodCreationEx(); 
		float result1 = mce.add(3.1f , 5.3f);// non-static 인스턴스 메서드
		System.out.println(result1);
		
		//이름이 outputNTimes이고, 매개변수는 String타입 변수 하나와 int타입 변수 (n)를 받아서
		//받은 문자열을 화면에 n번 반복해서 출력하는 메서드(인스턴스 메서드)를 만들고 호출하세요
		
		mce.outputNTimes("안녕하세요",3);
		
		//메서드 오버로딩
		System.out.println(add(1, 3, 5));
		System.out.println(mce.add(3,10L));
		System.out.println(mce.add(3.14f, 5.0f)); 
		
		
	}

}
