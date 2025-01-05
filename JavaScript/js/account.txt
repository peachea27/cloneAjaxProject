function Account(owner, accNum, balance) {
  //객체를 생성할 땐 카멜이 아니라 파스칼 표기법 (대문자), 구분을 위해//이게 클래스?
  this.owner = owner;
  this.accNum = accNum;
  this.balance = balance;
  this.name = "직장인 비과세 예금";
  this.bankName = "우리은행";

  console.log(this);

  //객체의 기능 부여 (메서드)
  this.checkBalance = function () {
    return this.balance;
  };
  this.deposit = function (money) {
    this.balance += money;
  };
  this.withdraw = function (money) {
    if (this.balance >= money) {
      this.balance -= money;
    } else {
      window.alert("잔액이 부족합니다.");
    }
  };
}
