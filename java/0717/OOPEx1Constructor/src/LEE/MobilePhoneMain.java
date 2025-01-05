package LEE;

public class MobilePhoneMain {

	public static void main(String[] args) {
		MobilePhone phone = new MobilePhone(); // 8^^기본생성자를 실행시켜 인스턴스 생성
		//15^^이렇게 다른 생성자를 만들어 놓으면 기본 생성자가 자동으로 생성해주지 않는다. 이렇게 객체를 만드는게 불가능해짐
		//8^^ 6번째줄에 breakpoint잡고 f6로 넘어가기, sysout에 찍혔으니 생성되었다는 뜻??
		System.out.println(phone.hashCode());
		//10^^ 下
		System.out.println(phone.toString());
		
		MobilePhone galaxy = new MobilePhone("삼성","갤럭시s24", 256, "흰색");
		//ctrl+tab으로 오버로딩한 생성자를 호출해서 인스턴스를 호출하는 방법
		System.out.println(galaxy.toString());//질문: toString없이 galaxy만 찍어도 되나요?
//		System.out.println(galaxy);//같은 결과값이 나옴, toString은 최상위를 대상으로 하는데.. 
//		나중에 상속할때 설명하겠다는..일단은 toString을 붙입시다
		
		//12^^
		MobilePhone iphone = new MobilePhone("애플","아이폰15ProMax");//tab으로 파라미터 2개짜리 선택
		System.out.println(iphone.toString());
		
		MobilePhone xphone = new MobilePhone("샤오미","샤오미폰");
		System.out.println(xphone.toString());
		
		//14^^
		MobilePhone galaxy1 = new MobilePhone("흰색", 512);
		
		
		//15^^
		MobilePhone xphone2 = new MobilePhone("샤오미","홍미폰");
		
//17^^
//		galaxy.mainMemory=1500; //지금 맘대로 접근해서 메모리값을 아무렇게 입력할 수 있는 상황, 제한 필요
		//MobilePhone 클래스에서 멤버변수에 private 제어자를 적용
		
		System.out.println("getter :" +galaxy.getBrandName());
		galaxy.setBrandName("Samsung");
		System.out.println(galaxy.toString());
//		galaxy.brandName//이렇게 접근이 안됨
		
		if (galaxy.setMainMemory(512)==false) {
			System.out.println("메모리 업그레이드 실패!"); 
			//2048GB를 넣으면 실패
		}else {
			System.out.println("메모리 업그레이드 성공!");
		}
		System.out.println(galaxy.toString());
	}

}
