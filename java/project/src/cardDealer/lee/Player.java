package cardDealer.lee;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	static int cardsNum =5;
	 Card[] cards;

	Player(){
		cards=new Card[cardsNum];
	}

	public void versus(Player p2) {
		int p1Sum = 0;
		int p2Sum = 0;
		for(int i = 0; i <cardsNum;i++) {
		p1Sum+=this.cards[i].getNum();
		p2Sum+=p2.cards[i].getNum();
	}
		System.out.println("p1의 합: "+p1Sum+" VS "+p2Sum+" :p2의 합");
		if(p1Sum > p2Sum) {
			System.out.println("플레이어1의 승리!");
		}else if(p1Sum < p2Sum) {
			System.out.println("플레이어2의 승리!");
		}else {
			System.out.println("무승부ㅠ.ㅠ");
		}
	}
}

	
