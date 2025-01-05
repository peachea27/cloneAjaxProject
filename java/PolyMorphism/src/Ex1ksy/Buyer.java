package Ex1ksy;

public class Buyer {
	int money = 1000000;
	int point;
	static final int MAX_ITEM =5;
	Electronics[] items =new Electronics[MAX_ITEM];
	int prodCounter = 0;
	
	//기본생성자
	public Buyer() {
		super();
	}
	
	//메서드
	public void buy(Electronics elec) {
		
		if (prodCounter >= MAX_ITEM) {
			System.out.println(MAX_ITEM +"개 까지만 구매하실 수 있습니다.");
			return;
		}
		
		if(this.money < elec.getPrice()) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		this.money -= elec.getPrice();
		this.point += elec.getPoint();
		this.items[prodCounter++] =elec;
	}

	public void printItems() {
		int sum = 0;
		
		System.out.println("구입 목록 리스트");
		
		for ( int i = 0 ; i < prodCounter; i++) {
			sum += items[i].getPrice();
			System.out.println(items[i].toString());
		}
		System.out.println("총가격:"+sum +"원");
		System.out.println("총적립포인트:"+this.point +"점");
	}
	
	
	
}
