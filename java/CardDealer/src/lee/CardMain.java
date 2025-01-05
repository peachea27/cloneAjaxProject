package lee;

import java.util.Arrays;

public class CardMain {

	public static void main(String[] args) {

		Card card=new Card(); 
		Card[] packOfCards=card.duplicateCards();
		card.shuffle(packOfCards);
//		packOfCards.shuffle();
//System.out.println(Arrays.toString(card.duplicateCards()));
//System.out.println(cardsArray[0].getKind());
	}

}
