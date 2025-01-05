import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx3 {

	public static void main(String[] args) {
		//arr 배열에 1부터 1씩 증가된 값을 요소에 할당
	
		
		//학생 4명의 국어, 영어, 수학 점수를 입력받아서 2차원 배열에 저장하고, 출력하세요
//		각 학생의 총점, 평균을 출력하세요
		
		// 학생 2차원 String타입의 배열 생성
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("학생 수>>>");
//		int cntStudent = sc.nextInt(); //4\n(엔터)이 남아있음
//		String[][] students = new String[cntStudent][6];
//		sc.nextLine(); // \n제거
//	
//		for (int i = 0; i < cntStudent; i ++) {
//			System.out.print(i+1 +"번 학생의 이름 >>>");
//			students[i][0] = sc.nextLine();
//			System.out.print(i+1 +"번 학생의 국어 >>>");
//			students[i][1] = sc.nextLine();
//			System.out.print(i+1 +"번 학생의 영어 >>>");
//			students[i][2] = sc.nextLine();
//			System.out.print(i+1 +"번 학생의 수학 >>>");
//			students[i][3] = sc.nextLine();
//			
//			int total = Integer.parseInt(students[i][1])+Integer.parseInt(students[i][2])+
//			Integer.parseInt(students[i][3]);
//			students[i][4] = String.valueOf(total); // 총점
//			students[i][5] = String.valueOf(total / 3.0); //평균 3.0으로 적으면 float으로 인식
//			
//			
//						}
//		
//		//students 배열 출력
//		System.out.println("이 름 \t 국어 \t 영어\t수학\t총점\t 평균\t");
//		System.out.println("--------------------------------------------------------------------------------------");
//		for ( int r = 0; r < cntStudent; r++) {
//			for ( int c = 0; c < students[r].length; c++) {
//				System.out.print(students[r][c] + " ");
//							}
//			System.out.println();//string 타입의 배열이라 null로 나온다
//		}
		
		
//		int배열에 1~100 사이의 난수 20개를 넣어놓고 유저에게 찾을 숫자를 입력받아 
//		출력 예) 찾는 값은 n번째에 있습니다.
		 
		//난수
		System.out.println( Math.round(Math.random()*100)+1);
		int[] numbers = new int[20];
		System.out.println(": "+Arrays.toString(numbers)); //0으로 초기화된 배열
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i]= (int)(Math.round(Math.random()*100)+1) ;
		}
		System.out.println(Arrays.toString(numbers));
		
		//유저에게 입력받아
		System.out.print("찾는 값을 입력하세요>>>");
		int userNum = sc.nextInt();
		
		int i = 0;
		boolean isFind = false;
		
		for( int num : numbers) {
		if(userNum==num) {
			isFind=true;
			System.out.println("찾는 값 "+userNum + "은 "+ i + "번째에 있습니다.");
		}
		i++;
		}
		
		if (!isFind) {
			
		System.out.println("찾는 값이 없습니다.");
		
		}
		
		sc.close();//sc를 다 쓰고 나면 닫아주는게 좋다/Resource leak: 'sc' is never closed	

		}
	}


