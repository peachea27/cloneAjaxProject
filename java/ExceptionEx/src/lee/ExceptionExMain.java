package lee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExMain {

		int a = 0; //멤버변수
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int result = 0;//main메서드에서 사용되는 지역변수
		System.out.println("정수를 입력하세요>>>");
		//우클릭->surround with>try catch
		try {
			int num = sc.nextInt();
			System.out.println("입력한 수는 : "+num);
			
			result = 3 /num;
			System.out.println("result : " + result);
			
		}
		catch (InputMismatchException e) {
////			System.out.println(e.getMessage());
////			e.printStackTrace();
			System.out.println("다음부터는 꼭 정수를 입력하세요");
//			
		}catch(ArithmeticException e) {
////			System.out.println(e.getMessage());
////			e.printStackTrace();
			System.out.println("다음부터는 0은 입력하면 안됩니다.");
//			
		}catch(Exception e) {//모든 예외의 최고 조상인 exception : 모든 예외 처리 가능
			//이 문구의 순서가 다른 예외들보다 앞에 가면 다른 예외들까지 기회가 오지 않는 오류 발생 :already handled by the catch block for exception
			//Exception catch 블럭은 가장 마지막에 써야 한다.
			System.out.println("예외가 발생했습니다!!");
		}finally {//try 블럭에서 예외가 발생하든 안하든 마지막에 수행될 블럭(생략 가능)
			System.out.println("Finally 끝");
		}
		
		System.out.println("완전 끝");
//		===================================
		
	}// end of main

}
