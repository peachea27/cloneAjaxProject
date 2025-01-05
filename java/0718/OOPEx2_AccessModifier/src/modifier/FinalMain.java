package modifier;

public class FinalMain {

	public static void main(String[] args) {
		ConstructInit ci1 = new ConstructInit(10);//기본생성자 없음//왜냐면 다른 생성자를 만들어놨기 때문//
		System.out.println(ci1.value);
		//final을 필드에 사용할 경우, 생성자를 통해서 한번만 초기화될 수 있다.
//		ci1.value = 20;//The final field ConstructInit.value cannot be assigned: final이라서 재할당 안됨
		ConstructInit ci2 = new ConstructInit(20);
		System.out.println(ci2.value);//이런식으로는 얼마든지 초기화값을 다르게해서 생성 가능
		
		
		//
		System.out.println("Field초기화..........................");
		FieldInit fi1 = new FieldInit();
		System.out.println(fi1.value);

		FieldInit fi2= new FieldInit();
		System.out.println(fi2.value);
	}

}
