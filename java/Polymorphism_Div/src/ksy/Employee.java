package ksy;

public abstract class Employee {
	private String empNo;
	private String eName;
	private int deptNo;
	protected int salary;
	
	public Employee() {
		
	}

	public Employee(String empNo, String eName, int deptNo, int salary) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.deptNo = deptNo;
		this.salary = salary;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getEmpNo() {
		return empNo;
	}
//	정규직과 알바직 사원의 급여 계산 방법이 다르므로 abstract메서드로 만든다
	public abstract int calSalary();
	//추상메서드로 만들어놓으면 자식들이 메서드를 만들어야 한다는걸 까먹을 수 없음,구현에 강제성을 주는 것
	

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", eName=" + eName + ", deptNo=" + deptNo + ", salary=" + salary + "]";
	}
	
}
