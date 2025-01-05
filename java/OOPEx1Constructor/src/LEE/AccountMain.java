package LEE;

public class AccountMain {

	public static void main(String[] args) {
		Account account= new Account();
		account.deposite(0);
		account.deposite(1000);
		 System.out.println("balance : " + account.getBalance());

		 account.withdraw(0);
		 account.withdraw(500);
		 account.withdraw(500);
		 account.withdraw(500);
	
		 System.out.println("balance : " + account.getBalance());
	}

}
