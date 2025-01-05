import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {

//		char[] charArr; // 선언
//		charArr = new char[3]; //정의 (생성)
		
		char[] charArr = new char[3];
		
		int a; //지역변수는 초기화를 하지 않으면 사용하지 못함.
//		System.out.println(a);//The local variable a may not have been initialized

		int[] scores = new int[3]; //객체는 자동 초기화된다 [0,0,0]
		System.out.println(scores);//[I@2a139a55 <= 어떤 타입의 배열인지 @주소로 구분 가능한 값 (16진수)
		///toggle break point -> debug //F6는 다음
		
		String[] names = new String[5];
		System.out.println(names);//[Ljava.lang.String;@15db9742
		//string타입은 null로 자동 초기화되어있다(디버그창 확인)
		
		boolean isOk[]= new boolean[2];
		System.out.println(isOk);//불리안은 false가 기본값(초기화되어있다)

		//배열에 요소에 값 할당
		scores[0] = 45;
		scores[1] = 23;
		scores[2] =100;
		
		System.out.println(scores[2]);
		
//		scores[3] = 50;
//		System.out.println(scores[3]); //배열의 인덱스 범위 벗어남
	// 런타임 에러 runtime exception
		
		//배열의 크기를 변경
		//1. 더 큰 배열을 새로 생성
		//2. 기존 배열의 내용을 새로운 배열에 복사
		scores = new int[4]; //배열은 참조타입이다
		System.out.print("scores[4] : " + scores);//scores[4] : [I@7852e922 다른 메모리 영역이라서 다른 이름
		
		System.out.println(scores.hashCode());
		
//		scores = new char[4]; // cannot convert from char[] to int[]
		//초기 배열의 타입(int[])과 다른 타입(char[])으로 할당이 불가능하다
		
		int[] scores2 = {100, 20, 30, 55, 23};
		System.out.println(scores2.hashCode());
		
		int[] scores3 = new int[] {10, 20, 30, 40, 50};
		System.out.println(Arrays.toString(scores3));
		
		int[] scores4; // 선언
		scores4 =new int[] {60,70,80,90,100};
//		scores4 = {100, 200, 300, 400, 500};//Array constants can only be used in initializers
		System.out.println(Arrays.toString(scores4));
		
		String[] heroes = {"아이언맨", "스파이더맨","헐크"};
		//출력방법
		for (int i = 0; i < heroes.length ; i++ ) {
		System.out.println(heroes[i]);
		}
		
		//확장 for문 (forEach문)
		for (String hero : heroes) {
			System.out.println(hero);
		}

		
		//2차원 배열의 선언과 생성
		int[][] arr = new int[3][4];
		
		int[][] arr1 = {{1,2,3},{4,5,6}};
		
		for (int r = 0; r < arr1.length; r++) {
			for(int c = 0; c < arr1[r].length; c++) {
				System.out.print(arr1[r][c]+" ");
			}
			System.out.println();
		}
		
		int num = 1;
		//array 배열에 1부터 1씩 증가된 값을 요소에 할당
		for (int i =0; i < arr.length ; i++) {
			for ( int j = 0 ; j < arr[i].length ; j++) {
				arr[i][j] = num;
				System.out.print(arr[i][j]+" ");
				num++;  
			}
			System.out.println();
		}
		//난수
        System.out.println(Math.random());
	}

}
