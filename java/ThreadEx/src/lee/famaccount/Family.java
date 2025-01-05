package lee.famaccount;

public class Family implements Runnable{
	private String name;
	private Account acc = new Account();
	/* 가족이 가족통장을 가지고 있다 */
	
	Family (String name){
		this.name = name;
	}

	@Override
	public void run() { /* 가족이 acc에서 돈을 인출 */
		while (this.acc.getBalance() > 0) {
			int money = (int)((Math.random() * 4000 )/ 100)*100+100;
			
			if(this.acc.withdraw(money)) { /*인출*/
				System.out.println(this.name + "님이 " + money +"원을 인출. 잔액 : "+ this.acc.getBalance());
			}
		}
		
	}
}
