package ksy;

public class StackHistoryMain {

	public static void main(String[] args) {
		// 브라우저의 뒤로/앞으로 기능
		//방문사이트 : 네이버 >다음 >쿠팡 >자바API
		
		WebHistory webBrowser=new WebHistory();
		
		webBrowser.visitWebPage("홈페이지");
		webBrowser.visitWebPage("네이버");
		webBrowser.visitWebPage("다음");
		webBrowser.visitWebPage("쿠팡");
		webBrowser.visitWebPage("자바API");
//
		webBrowser.goBack();
//		webBrowser.goBack();
//		webBrowser.goBack();
//		webBrowser.goBack();
//		webBrowser.goBack();
//		
		webBrowser.goForward();
		webBrowser.goForward();
	}

}
