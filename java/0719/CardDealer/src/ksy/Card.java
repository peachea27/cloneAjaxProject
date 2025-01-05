package ksy;

public class Card {
	//멤버변수 : 숫자로 접근하면 후에 승패를 가릴 때 등 코드를 많이 줄일 수 있음
	private int kind; //카드 모양 (4가지)
	private int number; //카드 숫자 (1 번~ 13번)
	
//	private static int width = 100;
//	private static int height = 200;
	
	private static final int HEART = 1;
	private static final int SPADE = 2;
	private static final int CLUB = 3;
	private static final int DIAMOND = 4;
	
	static final int KIND_MAX=4;
	static final int NUMBER_MAX=13;
	
	//생성자
	public Card(int kind, int number) {
		this.kind =kind;
		this.number=number;
	}

	public String toString() {
		String kind = "";
		String number ="";
		
		//카드 숫자를 문자열 반환
		switch (this.number) {
		case 1:
			number = "A";
			break;
		case 11:
			number = "J";
			break;
		case 12:
			number = "Q";
			break;
		case 13:
			number = "K";
			break;

		default:
			number = this.number + ""; // int-> String으로 바꿔주는 가장 간단한 방법
			break;
		}
		
		//카드 무늬숫자를 특수문자
//		♥♠♣◆
		switch (this.kind) {
		case HEART:
			kind ="♥";
			break;
		case SPADE:
			kind ="♠";
			break;
		case CLUB:
			kind ="♣";
			break;
		case DIAMOND:
			kind ="◆";
			break;

		}
		
		return kind + number;//공백을 넣어줘도 되지만 이렇게 문자열 붙여서
	}
	
}
