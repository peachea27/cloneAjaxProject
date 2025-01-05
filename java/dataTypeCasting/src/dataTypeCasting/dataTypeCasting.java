package dataTypeCasting;

public class dataTypeCasting {

	public static void main(String[] args) {
		//데이터 타입의 형 변환(Cast)
		byte b =125;
		System.out.println(b);
		
		//묵시적 (자동) 형변환(casting) 프로그래머가 형 변환 연산자를 쓰지 않더라도 자동으로 형변환.
		//보통, 작은 타입에서 큰 타입으로 변환할 때 묵시적 형변환이 일어남.
		
		int i = b; //작은 타입을 큰타입으로 넣어줌
		System.out.println("i: " + i); //125
		
		//int -> float
		float f = 1234; //float가 (byte가 같기도 하지만 /실수형이 정수형 보다는 )수의 범위가 더 크다
		float f1 = (float)1234; //integer 1234가 float로 형변환/ 이와 같이 형변환이 잇어야 하지만 자동으로 해줌

		//float -> int
		//int j = 3.14f;//cannot convert from double to int// 지금 double이니까 뒤에 f를 붙여 float로 바꿔주기
		//->cannot convert from float to int
		int k = (int)3.14f; //강제로 int타입으로 바꿔줌
		System.out.println("k : " + k);// 3
		
		//int -> byte
		int i2 = 12;
		//byte b2 = i2;// 127은 잘 넣더니 12는 왜 안될까? Type mismatch: cannot convert from int to byte
		//아까는 리터럴에서 바로 넣어서 괜찮았는데 이번엔 변수에 담아서 넣으려고 하니 자동으로 변환해주지 않음
		byte b2 = (byte)i2;//강제변환
		System.out.println(b2);
		
//		참고***
//		//byte : 정수형 1byte
//		byte b =127;//아무것도 안쓰면 정수는int타입 실수는 double타입으로 잡는다// 127정도면 바이트에 넣을 수 있다고 판단하고 
//		//시스템에서 자동으로 컴파일 해주는것***
		
		byte b3= 100; //int지만 자동변환해서 byte에 담김
		byte b4= b3;
		
		// 명시적 형변환 : 프로그래머가 형변환을 하라고 명시해 놓는 것 ( 큰 타입 -> 작은 타입 변화)
		//(형변환할 테이터 타입) 캐스팅 할 변수
		//double -> float
		double pl =3.141592;// 기본적으로 double타입
		System.out.println("pl : " + pl);
//		float fpi = pl; //cannot convert from double to float
		float fpi = (float)pl;
		System.out.println("fpi : " + fpi);
		
		//int -> short
		int i3 = 32767; //short에 담을 수 없는 큰 수 32768을 적으면 overflow 가 일어나서 -32768이 출력
//		short s = i3;//cannot convert from int to short(int가 short(2byte)보다 크다)
		short s = (short)i3;
		System.out.println("s : " + s);
		
		//문자
		char c ='a';
		System.out.println("c : " + c);
		System.out.println("c : " + (int)c); // 97 출력 , 소문자 a의 코드값
		System.out.println((char)98);// b
		
		//다음은 Type Mismatch에러가 남
		byte b6 = 97;
//		char char2 = b6;// cannot convert from byte to char //크기상은 문제없으나 byte나 short타입은 음수값을 가질 수 있는
		//반면 char는 양수값만 담을 수 있으므로 불가
		short s4=97;
//		char char3 = s4;
		
		//boolean
		boolean bool = true;
//		float f2= (float)bool; //Cannot cast from boolean to float
		
		//연산식에서 자동형변환
		//리터럴이 피연산자인 경우
		byte bSum = 10 + 20;//int타입끼리 덧셈//리터럴방식으로 값을 바로 줌
		
		//변수가 피연산자인 경우
		byte b7 = 10;
		byte b8 = 20;
//		byte bResult = b7 + b8; //cannot convert from int to byte // 둘 다 int, int가 byte보다 크다
		byte bResult = (byte) (b7 + b8); 
		System.out.println(bResult); // 30
		int cResult = b7+b8;
		
		// int타입과 long타입 연산
		long l3 = 50l;
		int i6 = 60;
//		int result = l3 + i6;//cannot convert from long to int
		long result = l3 + i6; //더 큰 쪽으로 따라가야 함
		int result1 = (int) (l3 + i6);
		int result2 = (int) l3 + i6;
		System.out.println(result);
		System.out.println(result1);
		System.out.println(result2);
		
		//실수 연산
		float f3 = 3.14f + 4.31f;// cannot convert from double to float
		System.out.println(f3);
		
//		float f4 = 3.1f + 4.3;// cannot convert from double to float
		float f4 = (float) (3.1f + 4.3);
		double f5 = 3.1f + 4.3;
		 
		// int, double
		int intNum = 10;
		double db1Num = 3.14;
		double sum1 = intNum + db1Num;
		System.out.println(sum1);
		
		// 정수, 실수를 나누기
		int intNum1 =1;
		int intNum2 =2;
		float divNum1 = intNum1 / intNum2;
		System.out.println(divNum1);//0.0 / 0.5가 나오길 기대했는데! 결과가 int로 나옴
		
		
		float divNum2 = (float)intNum1 / intNum2;// 둘 중 하나를 float으로 바꿔줌/ 둘 다 붙여도 됨
		System.out.println(divNum2);//0.5
		
		
		//문자열 변환
		int result3 = 1 +2 +3;
		System.out.println("result3 =" + result3);//6
		
		String result4 = 1 + 2 +"3";
		System.out.println("result4="+result4);//33
		
		String result5 = 1 + "2" +3;
		System.out.println("result5="+result5);//123
		
		String result6 = "1" + 2 +3;
		System.out.println("result6="+result6);//123 :"1""2"
		
		String result7 = "1" + (2 +3);
		System.out.println("result7="+result7);//15
		
		String result8 = 4 + "";
		System.out.println("result8="+result8);//4
		
		String result9 = 4 + "" +3;
		System.out.println("result9="+result9);//43
		
		//문자열 -> 숫자 (정수형, 실수형)
		int a = Integer.parseInt("1");//int타입으로 바꿔줌
		double dblNum = Double.parseDouble("3.14");
		System.out.println("a="+(a+1));//2
		System.out.println("dblNum ="+ dblNum);//3.14
		
//		int b = Integer.parseInt("1.12");
		//exception in thread "main" java.lang.NumberFormatException: For input string: "1.12"
//		at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//		at java.lang.Integer.parseInt(Integer.java:580)
//		at java.lang.Integer.parseInt(Integer.java:615)
//		at dataTypeCasting.dataTypeCasting.main(dataTypeCasting.java:144)
		
		//숫자 -> 문자열
		String str1 =3 +"";
		System.out.println(str1);
		
		String str2 = String.valueOf(10);
		System.out.println(str2);
		
		String str3=String.valueOf(true);
		System.out.println(str3);
//		
//	}

}
}
