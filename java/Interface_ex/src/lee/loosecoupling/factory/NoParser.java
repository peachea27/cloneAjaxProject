package lee.loosecoupling.factory;

public class NoParser implements Parseable {

	@Override
	public boolean parse() {
		System.out.println("파서기가 없습니다.");
		return false;
	}

}
