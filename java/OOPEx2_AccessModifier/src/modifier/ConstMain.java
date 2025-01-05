package modifier;

public class ConstMain {

	public static void main(String[] args) {
		 int curReservUsers = 999;
		 reservation(curReservUsers++);
		 reservation(curReservUsers++);
		 reservation(curReservUsers++);
	}
	private static void reservation(int curReservUsers) { 
		System.out.println("예약자 수: " + curReservUsers);
		if(curReservUsers > FieldInit.MAX_RESERV_USER) {
			System.out.println("대기합니다...");
		}else {
			System.out.println("예약 가능합니다...");
		}
	}
 
}
 