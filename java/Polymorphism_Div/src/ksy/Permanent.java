package ksy;

public class Permanent  extends Employee{

	public Permanent(String empNo, String eName, int deptNo, int salary) {
		super(empNo,eName,deptNo,salary);
	}
	
	@Override
	public int calSalary() {
		return super.salary;//this.salary와 super.salary모두 안됨//왜냐면 employee가 private라서: protected로 바꿔주기
	}

	@Override
	public String toString() {
		return "Permanent []" + super.toString();
	}

}
