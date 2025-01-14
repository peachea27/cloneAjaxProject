package cardDealer.ksy;

import java.util.ArrayList;
import java.util.List;

public class Player {
	/*
	 * 문제에 따르면 플레이어가 가진 카드를 정렬해서 보여준다 카드 모양을 숫자와 붙여서 ex)113 213 131 132..를 비교하는
	 * 형식으로도 비교가능
	 */
	private String name;
	private List<Card>playersCards;
	
	public Player(String name) {
		this.name = name;
		this.playersCards = new ArrayList<Card>();
	}
	
	public void getCardFromDealer(Dealer dealer) {
		playersCards.add(dealer.pickCard());
	}
	
	public void showPlayersCards() {
		playersCards.sort(null);//null은 comparable에서 지시한대로 정렬
		System.out.println(name+"플레이어"+playersCards +"총합 : "+calCardSum());
	}
	
	public int calCardSum() {
		int sum =0;
		for (Card card : playersCards) {
			sum += card.getNum();
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public List<Card> getPlayersCards() {
		return playersCards;
	}
}
