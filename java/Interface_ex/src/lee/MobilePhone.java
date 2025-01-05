package lee;

public class MobilePhone implements Phone, Camera, Computer{
	//스마폰은 전화기이다//상속(인터페이스 해도 됨)
	//스마폰은 카메라이다.(는 어색, 카메라 기능이 있다 -> 인터페이스)
	//스마트폰은 컴퓨터기능이 있다

	@Override
	public void phoneCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void answerPhone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ComputerEquation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playApp() {
		// TODO Auto-generated method stub 
		
	}
}
