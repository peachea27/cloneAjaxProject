package cardDealer.ksy;

public class Card implements Comparable<Card> {

	private int num;
	private Kind kind;
	
	public Card(int num, Kind kind) {
		this.num =num;
		this.kind =kind;
	}

	public int getNum() {
		return num;
	}

	public Kind getKind() {
		return kind;
	}

	@Override
	public int compareTo(Card o) {
		if(this.num != o.num) {
			return Integer.compare(this.num, o.num);
		}else {
			return this.kind.compareTo(kind);
		}
	}
	@Override
	public String toString() {
		return num+ kind.toString();
	}
	
	
}
