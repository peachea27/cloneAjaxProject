package LEE;

public class Account {
	private int balance; //이걸 해줘야 밸런스를 마음대로 조정 불가능// 같은 이유로 setter도 필요없다

	//public을 안쓰면 같은 패키지에서만 사용 가능
public void deposite(int money) { 
	if(isValid(money)) {
	this.balance += money; 
	}else {
		System.out.println("유효하지 않은 금액입니다.");
	}
}

public void withdraw(int money) {
	if(isValid(money) && (this.balance - money) >= 0) {
	this.balance -=money;
}else { 
	System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다");
}
	}

public int getBalance() {
	return balance;
}

private boolean isValid(int money) {
	return money > 0;
}


}