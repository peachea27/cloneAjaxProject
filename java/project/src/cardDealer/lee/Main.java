package cardDealer.lee;

public class Main {

	public static void main(String[] args) {
	
//	Card aPackCard= new Card();
//	aPackCard.exists(); 
		
	Dealer 주윤발=new Dealer();
	//딜러가 카드를 섞습니다...
	주윤발.shuffle();
	
	Player p1 = new Player();
	Player p2 = new Player();
	
	//딜러가 카드를 나눠줍니다...
	주윤발.offerCards(p1,p2);
	
	//플레이어1과 플레이어2가 카드를 냅니다
//	p1 VS p2
	p1.versus(p2);
}
}