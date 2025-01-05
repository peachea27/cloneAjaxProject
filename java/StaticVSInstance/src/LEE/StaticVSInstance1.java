package LEE;

public class StaticVSInstance1 {
	
	static int sInt; //클래스 변수
	int iInt;  //인스턴스 변수

	
//	초기화 블럭
	{
		//instance 멤버 초기화
		System.out.println("iInt의 초기값: " + iInt);
		iInt=5;
		System.out.println("Instance 초기화 블럭{ }");
	}
	

	
	static {
		//static 멤버를 초기화 //나중에 썼더라도 이게 먼저 실행됨(콘솔확인)
		System.out.println("sInt의 초기값: " + sInt);
		sInt = 100;
		System.out.println("static 초기화 블럭{ }");
	}
	//static의 초기화블럭은 처음에 한번만 실행되고 instance의 초기화 블럭은 계속 실행된다
	public void acc() {
		sInt++;
//		this.iInt++;
		
		System.out.println("no : " + this.hashCode()+ ", sInt : " + StaticVSInstance1.sInt 
				+  	", iInt : " + this.iInt);
	}

	public static void main(String[] args) {
		for (int i = 0; i  < 10; i++) {
			StaticVSInstance1 svi = new StaticVSInstance1(); 
			svi.acc();
		}

	}

}
