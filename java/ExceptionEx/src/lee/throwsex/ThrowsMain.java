package lee.throwsex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsMain {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요>>>");
		int num = 0;
		
		try {
			num = getPositiveNumber();
			
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("숫자가 아닙니다.");
		} catch(NumberFormatException e) {
			System.out.println("정수로 변환할 수 없습니다.");
		}
	}
	
	private static int getPositiveNumber() throws InputMismatchException, NumberFormatException {
		Scanner sc = new Scanner(System.in);
		int tmp = sc.nextInt(); //예외발생
		
		sc.nextLine();
		int tmp2 = Integer.parseInt("3.141592");//NumberFormatException 발생
		return tmp;
	}

}
