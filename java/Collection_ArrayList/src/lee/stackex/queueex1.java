package lee.stackex;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queueex1 {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList();
		int cnt=1;
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1: 대기번호 발급 2:대기번호 호출 3:종료 >>>");
		int num = sc.nextInt();
		
		if (num==1) {
			System.out.println("대기번호를 발급합니다: "+cnt );
			que.offer(cnt++);
		}else if (num ==2) {
			if(que.size()==0) {
				System.out.println("대기 인원이 없습니다.");
			}else {
			System.out.println("대기번호를 호출합니다 :"+ que.poll()+"번");
			System.out.println("대기인원:" + que.size()+"명");
			}
		}else if (num==3) {
			System.out.println("종료되었습니다");
			break;
		}
		
	}
	}
}
