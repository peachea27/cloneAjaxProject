package lee.loosecoupling.ex;

public class ParseMain {

	public static void main(String[] args) {
		ParseService service = new ParseService();
		
		service.processParse("data.json");
		service.processParse("data.xml");
		service.processParse("data.dat");
		
//		결과
//		파일의 확장자 : json
//		json 파일 파싱을 시작합니다..
//		파싱완료!
//		파일의 확장자 : xml
//		xml파일 파싱을 시작합니다...
//		파싱완료!
//		파일의 확장자 : dat
//		파서기가 없습니다.
//		파싱 실패!

		
	}

}
