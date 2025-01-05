package singletonex;

public class ConnectService {
	//싱글톤 (singleton)
	private static ConnectService instance = new ConnectService();
	//static추가 왜냐면 static에서는 instance를 못쓰기 때문

	private ConnectService() { }
	
	static ConnectService getInstance() {
   //main에서 빨간줄 클릭하면 자동으로 static만들어줌
	//디폴트 제어자	
		return instance;
	}

}
