import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		// 메뉴 선택
				// 1. 도서정보입력 2. 총 비용 3. 종료
				// 1선택 -> 도서명, 가격, 수량 -> 정보를 출력
				// 2선택 -> 총 비용 출력
				// 3선택 -> 종료
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while(true) {
			System.out.println("====메뉴====");
			System.out.println("1.도서정보입력");
			System.out.println("2.총 비용");
			System.out.println("3.종료");
			System.out.print("원하시는 메뉴를 선택하세요 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 1) {
				System.out.print("도서명 : ");
				String bookName = sc.nextLine();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				System.out.print("수량 : ");
				int qty = sc.nextInt();
				sum = price * qty;
				System.out.println("도서명 : " + bookName + " 가격 : " + price + " 수량 : " + qty);
			}else if(menu == 2) {
				System.out.println("총 비용 : " + sum);
			}else if(menu == 3) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("올바른 메뉴를 선택하세요");
			}
		}

	}

}
