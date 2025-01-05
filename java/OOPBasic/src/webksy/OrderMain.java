package webksy;

public class OrderMain {

	public static void main(String[] args) {
		int total = 0;
		
		Order order1 = new Order();
		order1.prodName = "오라클";
		order1.price = 20000;
		order1.quantity = 1;
		
		Order order2 = new Order();
		order2.prodName = "자바";
		order2.price = 10000;
		order2.quantity = 2;
		
		Order order3 = new Order();
		order3.prodName = "스프링";
		order3.price = 25000;
		order3.quantity = 3;
		
		Order[] orders = new Order[3];
		orders[0] = order1;
		orders[1] = order2;
		orders[2] = order3;
		
		for (int i = 0; i < orders.length; i++) {
			System.out.println("상품명 : " + orders[i].prodName + ", 가격 : " + orders[i].price +
					 ", 수량 : " + orders[i].quantity);
		}
		
		// 확장for문 (foreach)
		for (Order od : orders) {
			System.out.println("상품명 : " + od.prodName + ", 가격 : " + od.price +
					 ", 수량 : " + od.quantity);
			total += od.price * od.quantity; 
		}
		
		System.out.println("총 금액 : " + total + "원");
		
		
		
		
		
		
		
		
		
		
		
	}

}

