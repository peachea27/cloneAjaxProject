package ksy;

import java.util.Stack;

public class WebHistory {

	private Stack<String>history = new Stack<String>();
	private String currentPage = null;
	private Stack<String>forward = new Stack<String>();
	
	public void visitWebPage(String webAddr) {
		if(currentPage != null) {
		history.push(currentPage);
		}
		currentPage=webAddr;
		System.out.println("방문한 페이지:"+webAddr);
		
	}
	public void goBack() {
		// 뒤로가기 버튼 클릭
		forward.push(currentPage);
		System.out.println("forward"+forward);
		if (!history.isEmpty()) {
		currentPage = history.pop();
		System.out.println("뒤로가기 클릭!");
		System.out.println("현재 페이지: " + currentPage);
		}else {
			System.out.println("첫페이지입니다.");
		}		
	}
	
	public void goForward() {
		if(!forward.isEmpty()) {
		System.out.println("앞으로가기 클릭!");
		System.out.println("현재페이지: "+forward.pop());
		}else {
			System.out.println("마지막페이지 입니다.");
		}
	}

	}


