import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		// 반복적으로 입력 받는 경우
		Scanner sc = new Scanner(System.in);
		
//		while(true) {
			System.out.print("숫자를 입력하세요 (-1을 입력하면 종료)>>>");
			int userNum = sc.nextInt(); //3\n
			System.out.println("숫자 :  " + userNum);
			sc.nextLine(); // 남아있는 \n을 지워줌
			System.out.print("이름을 입력하세요 ");
			String name = sc.nextLine(); // \n전까지 문자열 입력
			System.out.println("이름 : "  + name);
			
			
			
			
//			if(userNum == -1) {
//				System.out.println("종료합니다....");
//				break;
//			}
//		}
		
		
		
	}

}
