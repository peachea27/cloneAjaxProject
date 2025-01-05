package ksy;

public class PartTimer extends Employee{

	private int workTime; //근무시간
	private int payPerHour;//시급
	
	public PartTimer() {
		
	}
	public PartTimer(String empNo, String eName, int deptNo, int workTime, int payPerHour) {
		super(empNo, eName, deptNo, workTime*payPerHour);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
//		calSalary();
	}
	
	
	@Override
	public int calSalary() {
		super.salary = this.workTime * this.payPerHour;
		return super.salary;
	}
	
	@Override
	public String toString() {
		return "PartTimer [workTime=" + workTime + ", payPerHour=" + payPerHour + "]" + super.toString();
	}
	
	

}
