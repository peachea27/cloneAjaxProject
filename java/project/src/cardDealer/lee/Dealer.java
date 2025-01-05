package cardDealer.lee;

import java.util.Arrays;

public class Dealer {
	private final int MAX_NUM= 52;
	private Card[] cardDeck=new Card[MAX_NUM];
	
	//카드와 함께 딜러 등장
	Dealer() {
		int index=0;
		for(int i = 1; i < Card.KIND+1; i++) {
			for(int j = 1; j <Card.MAX_KIND+1; j++) {
				cardDeck[index++]=new Card(i, j);
			}
		}
		System.out.println("딜러가 카드를 보여줍니다.");
		System.out.println(Arrays.toString(cardDeck));
	}

	//카드 셔플
	public void shuffle() {
		for(int i =0; i < 500; i++) {
			int ranNo=(int)(Math.random()*MAX_NUM);
			Card tmp= this.cardDeck[ranNo];
			this.cardDeck[ranNo]=this.cardDeck[0];
			this.cardDeck[0]=tmp;
			
		}
		System.out.println("딜러가 카드를 섞습니다...");
		System.out.println(Arrays.toString(cardDeck));
	}

	public void offerCards(Player p1, Player p2) {
		int ranNo=0;
		int cnt=0;
		//카드를 번갈아가며 분배
		for(int i = 0; i <(Player.cardsNum)*2; i++) {
			if(i%2 ==0) {
			do {
			ranNo=(int)(Math.random()*MAX_NUM);
		}while(cardDeck[ranNo]==null);
			p1.cards[cnt]=cardDeck[ranNo];
			}else {
					do {
						ranNo=(int)(Math.random()*MAX_NUM);
					}while(cardDeck[ranNo]==null);
					p2.cards[cnt++]=cardDeck[ranNo];
				}
			cardDeck[ranNo]=null;
			}
		
		//숫자순으로 정렬+모양순으로 정렬
		for(int i = 0; i <Player.cardsNum-1;i++) {
			for(int j = i+1; j<Player.cardsNum; j++) {
				
				if(p1.cards[i].getNum() > p1.cards[j].getNum()) {
					Card tmp1 = p1.cards[i];
					p1.cards[i]=p1.cards[j];
					p1.cards[j]=tmp1;}
					
				if(p2.cards[i].getNum() > p2.cards[j].getNum()) {
					Card tmp2 = p2.cards[i];
					p2.cards[i]=p2.cards[j];
					p2.cards[j]=tmp2;
			    	}
				if(p1.cards[i].getKind() == p1.cards[j].getKind()) {
					if(p1.cards[i].getKind() > p1.cards[j].getKind()) {
						Card tmp = p1.cards[i];
						p1.cards[i]=p1.cards[j];
						p1.cards[j]=tmp;
					 }
				}
				if(p2.cards[i].getKind() == p2.cards[j].getKind()) {
					if(p2.cards[i].getKind() > p2.cards[j].getKind()) {
						Card tmp = p2.cards[i];
						p2.cards[i]=p2.cards[j];
						p2.cards[j]=tmp;
					}
				}
		    	}
	    	}
		
		System.out.println("딜러가 카드를 나눠줍니다...");
		System.out.println("플레이어1의 카드: "+Arrays.toString(p1.cards));
		System.out.println("플레이어2의 카드: "+Arrays.toString(p2.cards));
		
	}
	}

