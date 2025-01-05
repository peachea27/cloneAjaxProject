package cardDealer.lee;

public class Card {
	private int kind;
	private int num;
	
	static final int KIND=4;
	 static final int MAX_KIND=13;
	
	private static final int SPADE= 1;
	private static final int HEART = 2;
	private static final int DIAMOND = 3;
	private static final int CLUB = 4;
	

	Card(int kind,int num){
		this.kind=kind;
		this.num=num;
	}
	public int getKind() {
		return kind;
	}
	public int getNum() {
		return num;
	}
	@Override
	public String toString() {
		String shape = null;
		if(this.kind==1) {
			shape="♠";
		}else if(this.kind==2) {
			shape="♥";
		}else if(this.kind==3) {
			shape="◆";
		}else if(this.kind==4){
			shape="♣";
		}
		return "[" + shape + num+ "]";
	}
	
	
	
}
