package lee;

public class Card {
	private static final int CONST_NUM=56;
	private Card[] cards = new Card[CONST_NUM];
 	private String kinds[]= {"spade","heart","diamond","clover"};
 	private String kind;
 	int num ;
 	private int ranNum=0;

 	public Card() {

 	}

public Card[] duplicateCards() {
	for(int j = 0; j <kinds.length; j++) {
		this.setKind(kinds[j]);
	for ( int i = 0 ; i <CONST_NUM/4; i ++) {
		if (i ==0) {
		this.num=-1;
		cards[i]=this;
		System.out.print(" "+cards[i].kind + cards[i].num+" ");
		}else {
			this.num=i;
			cards[i]=this;
			System.out.print(" "+cards[i].kind + cards[i].num+" ");
		}
	}
	}
	return cards;
	
}


public void shuffle(Card[] packOfCards) {
	Card tmp = new Card();
	for( int i =0; i <CONST_NUM; i++) {
		System.out.print(" "+packOfCards[i].kind + packOfCards[i].num+" ");
//		ranNum =(int)Math.floor(Math.random()*CONST_NUM);
//		System.out.println(ranNum+ " "+packOfCards[ranNum]);
//		tmp.kind=packOfCards[i].kind;
//		tmp.num=packOfCards[i].num;
//		packOfCards[i].kind=packOfCards[ranNum].kind;
//		packOfCards[i].num=packOfCards[ranNum].num;
//		packOfCards[ranNum].kind=tmp.kind;
//		packOfCards[ranNum].num=tmp.num;
	}
}

public String getKind() {
	return kind;
}

public void setKind(String kind) {
	this.kind = kind;
}



}