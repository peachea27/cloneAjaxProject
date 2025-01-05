package lee.stackex;

import java.util.Stack;
import java.util.Vector;

public class stackex1 {

	private static Stack<String>forward= new Stack<String>();
	private static Stack<String> website = new Stack<String>();
	private static String currentPage="";
	public static void main(String[] args) {
		

		방문("네이버");
		방문("다음");
		방문("쿠팡");
		방문("자바API");
		
		뒤로가기();
		뒤로가기();
		앞으로가기();
		
		
	}

	private static void 방문(String site) {
		website.push(currentPage);
		System.out.println("현재 방문한 사이트: "+ site);
		currentPage=site;
	}
	
	private static void 앞으로가기() {
		System.out.println("앞으로가기 클릭!");
		System.out.println(forward.peek());
		website.push(forward.pop());
		
	}

	private static void 뒤로가기() {
		forward.push(currentPage);
		System.out.println("뒤로가기 클릭!");
		System.out.println(website.peek());
		currentPage = website.pop();
		
	}
}
