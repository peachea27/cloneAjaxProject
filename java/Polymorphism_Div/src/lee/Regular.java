package lee;

public class Regular extends Employee{
	private int salary;
	
	Regular[] regWorkers = new Regular[5];
	
	
	Regular(String name, int salary){
		super(name);
		this.salary=salary;
	
	}
	

	public int getSalary() {
		return salary;
	}

	
	public void work() {
		System.out.println(this.getName()+"은 풀타임으로 일을 합니다.");
	}
	@Override
	public String toString() {
		return "Regular [salary=" + salary + "]";
	}
}
