import org.omg.CORBA.TypeCodePackage.BadKind;

import cardDealer.ksy.Dealer;
import cardDealer.ksy.Kind;
import cardDealer.ksy.Player;

public class PlayCardMain {

	public static void main(String[] args) {
	
		Dealer dealer = new Dealer();
		Player player1 = new Player("임요한");
		Player player2= new Player("나");
		
		for( int i = 0; i < 5; i++) {
			player1.getCardFromDealer(dealer);
			player2.getCardFromDealer(dealer);
		}
		
		player1.showPlayersCards();
		player2.showPlayersCards();

		Player winner = getWinner(player1,player2);
		
		if(winner !=null) {
			System.out.println(winner.getName()+"승리!");
		}else {
			System.out.println("무승부!");
		}
		
	}

	private static Player getWinner(Player player1, Player player2) {
		int p1 = player1.calCardSum();
		int p2 = player1.calCardSum();
		
		if(p1 >p2) {
			return player1;
		}else if(p1 == p2) {
			return null;
		}else {
			return player2;
		}
	}

}
