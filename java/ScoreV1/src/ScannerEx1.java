import java.util.Scanner;// Ctrl + Shift + O

public class ScannerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		System.out.print("이름을 입력하세요 >>>>");
//		String name = sc.nextLine();// 엔터(\n)를 입력할 때까지 문자열을 가져옴
//		System.out.println("이름은 " + name + "입니다");
//		
//		System.out.print("나이를 입력하세요 >>>>");
//		int age = sc.nextInt();
//		System.out.println("나이는 " + age + "입니다" );
//		System.out.println("키를 입력하세요 >>>>");
//		double height = sc.nextDouble();
//		System.out.println("키는 " + height + "cm입니다" );
//		
		// 유저에게 숫자를 입력받아서, 짝수인지 홀수인지 출력하는 프로그램을 만드세요
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		switch(num%2) {
		case 1 :
			System.out.println(num + "는 홀수 입니다.");
			break;
		case 0 :
			System.out.println(num + "는 짝수 입니다.");
			break;
		default :
			System.out.println("유효하지 않은 숫자입니다");
			break;
			
		}
	}

}

