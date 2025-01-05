package Ex1;

public class BuyerMain {
	//고객(Buyer)이 전자제품 Tv, Monitor, Computer를 구매하려고 한다.
	//100만원 돈으로 가격이 20만원인 Tv, 10만원인 Monitor, Computer를 구입했다.
	//구입 가격의 10%를 포인트로 적립받을 수 있다. (포인트 바로 사용 불가)
	//고객이 구입한 상품 목록과 총가격, 적립포인트를 출력하세요.

	public static void main(String[] args) {
		
//		Appliance tv1=new Tv("티비",200000);
//		Appliance m1 = new Monitor("모니터",100000);
//		Appliance c1 = new Computer("컴퓨터",300000);
//		
//		Tv tv=(Tv) tv1;
//		Monitor monitor=(Monitor) m1;
//		Computer computer=(Computer)c1;
//		
//	
//		String product=tv.getProduct()+","+monitor.getProduct()+","+computer.getProduct();
//		int total =tv.getPrice()+monitor.getPrice()+computer.getPrice();
//		int point= (int) (total*0.1);
//		
//		System.out.println("구매목록:"+product);
//		System.out.println("총합:" +total+", 포인트:"+point);

	
		Buyer buyer1 = new Buyer("Lee",100000);
		
		buyer1.addAppliance(new Computer("컴퓨터이름",200000));
		
	}

}
