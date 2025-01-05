package ksy;

import java.util.Arrays;

public class Dealer {
	public final static int CARD_NUM = 52;
	private Card[] cardDeck = new Card[CARD_NUM];
	private static int curCardCount =0;
	
	//생성자
	public Dealer() {
		//딜러 등장시 개봉하지 않은 카드 들고 옴.
		curCardCount =CARD_NUM;
		int cardIndex = 0;
		for ( int cardKind = 1; cardKind <= Card.KIND_MAX; cardKind++) {
			for ( int cardNum = 1; cardNum <= Card.NUMBER_MAX; cardNum++) {
				this.cardDeck[cardIndex++] = new Card(cardKind, cardNum);
			}
				
		}
	}

	public String displayCard() {
		return "전체 카드 갯수 : " + this.cardDeck.length + 
				", [Cards] : " + Arrays.toString(this.cardDeck);
	}

	public void shuffle() {
		// 딜러가 카드 섞는다
		for ( int i = 0; i < 1000; i++) {
			int index = (int)(Math.random()*CARD_NUM); //0~51사이의 랜덤 정수
			
			Card temp = this.cardDeck[index];
			this.cardDeck[index] = this.cardDeck[0];
			this.cardDeck[0]=temp;
		}
		 
	}

	public Card pickCard() {
		//뽑힌 카드의 자리는 null로 채워준다
		int index = 0; // 랜덤한 인덱스 (랜덤하게 카드 뽑아서 지급)
		Card returnCard = null;//뽑힌 카드
		//선언만 하는것보다 초기값을 잡아주는 것이 좋다
		do {
			index = (int)(Math.random()*CARD_NUM);
			returnCard = this.cardDeck[index];
		}while(returnCard==null);
		
		this.cardDeck[index] = null; //뽑힌 카드 요소에 null 할당
		return returnCard;
	}  

	public Card pickCardWithRemoveArray() {
		//다른 방법)랜덤으로 카드를 뽑은 후, 배열의 크기를 줄여서 새로 생성해서 남은 카드를 넣는다.
		int index = 0; // 랜덤한 인덱스 (랜덤하게 카드 뽑아서 지급)
		Card returnCard = null;//뽑힌 카드
		
		index = (int)(Math.random()*curCardCount);
		returnCard = this.cardDeck[index];
		
		Card[] newCardDeck = new Card[curCardCount - 1]; //새로운 빈 배열 생성
		
		for ( int i = 0; i < index ; i++) {
			newCardDeck[i] = this.cardDeck[i];
		}
		for ( int i = index + 1; i < curCardCount; i++ ) {
			newCardDeck[i - 1] = this.cardDeck[i];
//			newCardDeck[index] = this.cardDeck[index + 1]
			//이런 원리로 대입해줘야 함
		}
		
		curCardCount--;
		this.cardDeck = newCardDeck;
		
		return returnCard;
	}

}
