package modifier;

public class ConstructInit {
	final int value;
	//아래의 생성자가 없을 땐 이런 오류가 생겼음:The blank final field value may not have been initialized
	//초기화를 시켜줘야 한다는 뜻, 생성자로 초기화를 시켜준 것
	
	public ConstructInit(int value) {
		this.value = value;
	}

}
