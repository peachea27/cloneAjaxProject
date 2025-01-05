package ksy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WaitMain {
	private static final int MAX_WAIT_NUM = 10;
	private static int issuedNum = 0;

	public static void main(String[] args) {
		Queue<Integer> waitList = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("1.대기번호 발급");
		System.out.println("2.대기번호 호출");
		System.out.println("9.종료");
		System.out.println("메뉴를 선택하세요>>>");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			issueWaitNumber(waitList);
			break;
		case 2:
			callWaitNumber(waitList);
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
			
		default:
			System.out.println("다시 선택해 주세요");
			break;
		}
	}
	}
	private static void callWaitNumber(Queue<Integer> waitList) {
		if(waitList.isEmpty()) {
			System.out.println("대기번호가 없습니다.");
		}else {
			
			System.out.println("대기번호" + waitList.poll()+ "호출!");
		}
		
	}

	private static void issueWaitNumber(Queue<Integer> waitList) {
		if(issuedNum >=MAX_WAIT_NUM) {
			System.out.println("오늘 대기번호 발급 초과......");
			return;
		}
		issuedNum++;
		waitList.offer(issuedNum);
		System.out.println("대기번호 " + issuedNum + "이 발급되었습니다.");
	}

}
