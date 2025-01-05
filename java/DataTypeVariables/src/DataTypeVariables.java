
public class DataTypeVariables {

	public static void main(String[] args) {
		//boolean : True | false (1byte)
		boolean bool = true; // 변수 bool을 선언과 할당
		System.out.println(bool);
		
		//char : 문자형, 2byte, 한 문자를 저장
		char character = 'a'; 
		System.out.println(character);
		char character2 = '1';//12는 저장못함 문자 하나만
		System.out.println(character2);
		char korChar = '가';
		System.out.println(korChar);
		char character3 ='\u0041';
		System.out.println(character3);
		
		//byte : 정수형 1byte
		byte b =127;//아무것도 안쓰면 정수는int타입 실수는 double타입으로 잡는다// 127정도면 바이트에 넣을 수 있다고 판단하고 
		//시스템에서 자동으로 컴파일 해주는것
		System.out.println(b);
		
		System.out.println("Byte타입의 최대값: "+ Byte.MAX_VALUE);
		System.out.println("Byte타입의 최소값: "+ Byte.MIN_VALUE);
		
		byte b1=(byte)128;//억지로 바이트로 해줌
		System.out.println(b1); //-128: 127을 하나 넘어 overflow되어서 다시 제일 작은 수로 돌아감
		//underflow가 발생하면 가장 큰 수로 간다
		// short : 정수형. 2byte
		short sInt = 128;
		System.out.println(sInt);
		System.out.println("Short타입의 최대값: "+ Short.MAX_VALUE);
		System.out.println("Short타입의 최대값: "+ Short.MIN_VALUE);
		
		//int : 정수형. 4byte
		int i = 35;
		System.out.println(i);
		System.out.println("int타입의 최대값: " + Integer.MAX_VALUE);
		System.out.println("int타입의 최소값: " + Integer.MIN_VALUE);
		
		//long : 정수형 8 byte
		long l =35L;// L,l을 붙이면 확실하게 타입을 정해줄 수 있다(리터럴 접미사) 안붙여도 됨
		System.out.println(l);
		System.out.println("long타입의 최대값: " + Long.MAX_VALUE);
		System.out.println("long타입의 최소값: " + Long.MIN_VALUE);
		
		//float : 실수형, 4byte
		//float f = 3.14;  //cannot convert from double to float 더블타입입니다//아무것도 안쓰면 기본적으로 double타입으로 보는데
		//더 큰 타입에서 작은타입에 집어넣으려고 하니 type mismatch에러가 난다
		float f =3.14f; 
		System.out.println(f);
		System.out.println("float 타입의 최대값: " + Long.MAX_VALUE);
		System.out.println("float 타입의 최소값: " + Long.MIN_VALUE);
		
		//double : 실수형, 8byte
		double d = 3.14;
		System.out.println(d);
		System.out.println("double 타입의 최소값: " + Double.MIN_VALUE);
		System.out.println("double 타입의 최대값: " + Double.MAX_VALUE);
		
		// 문자열 (String) :참조타입
		//char 리터럴 작은따옴표
		//두 문자 이상은 문자열로, 큰따옴표 감싼다. -문자열 리터럴
		String str="대한민국";
		System.out.println(str);
		System.out.println("string의 길이: "+ str.length());//괄호가 있으면 매소드
		System.out.println(str.getClass().getName());//java.lang에는 string이라는 클래스가 있다
		
		String str1="";
		// char ch=''; //에러(저런 문자열은 기존에 할당된 바가 없음) : Invalid character constant
		char ch=' ';//공백문자는 가능.. 그래서 초기화 할 때 이렇게 쓴다.
	}

}
