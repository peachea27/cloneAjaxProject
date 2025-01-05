package singletonex;

public class ConnectMain {

	public static void main(String[] args) {
		// main메서드를 포함하는 클래스
		ConnectService cs1 = ConnectService.getInstance();
		ConnectService cs2 = ConnectService.getInstance();
		ConnectService cs3 = ConnectService.getInstance();

//		ConnectService test = new ConnectService();//다른 객체, 이런식으로 생성할 수 있어선 안됨
		//The constructor ConnectService() is not visible: 기본생성자에 private 접근제어자를 적용해서
//		위와 같은 인스턴스 생성하지 못하도록 만든다.
		
		if(cs1==cs2) {//같은 주소값
			System.out.println("같은 ConnecService 객체 입니다");
		}else {
			System.out.println("다른 ConnectServide 객체 입니다.");
		}
	}

}
