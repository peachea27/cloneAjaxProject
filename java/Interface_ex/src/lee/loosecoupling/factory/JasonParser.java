package lee.loosecoupling.factory;

public class JasonParser implements Parseable{
	

	@Override
	public boolean parse() {
		System.out.println("json 파일 파싱을 시작합니다..");
		return true;
	}
}
