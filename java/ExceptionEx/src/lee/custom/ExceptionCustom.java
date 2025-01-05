package lee.custom;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCustom {

	public static void main(String[] args) {
				int num = 0;
				
				while(true) {
					try {
						Scanner sc = new Scanner(System.in);
						System.out.println("양수 입력 >>>");
						num = sc.nextInt();
						
						if (num > 0) {
							break;
							
						}else {
							NotPositiveInteger np = new NotPositiveInteger("양수가 아닙니다");
			//				throw new NotPositiveInteger("양수가 아닙니다");
							throw np;
						}
						
					} catch (NotPositiveInteger e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.out.println(e.getMessage());
					}catch (InputMismatchException e) {
						System.out.println("숫자를 입력하세요");
					}
				}
				System.out.println("입력하신 숫자 : " + num);
			}

}
