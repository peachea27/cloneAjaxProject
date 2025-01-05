import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		// 유저에게 숫자를 입력받아서 1부터 ~ 입력된 숫자까지의 총합을 출력ㅎ세요
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i = 1 ; i <= num ;i++) {
			sum += i;
		}
		
		System.out.println("1부터 입력하신 숫자까지의 총 합은 : " + sum + "입니다");

	}

}
