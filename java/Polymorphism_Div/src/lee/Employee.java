package lee;

public class Employee {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Employee(String name){
		this.name=name;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public void work() {
		System.out.println("일하는 중");
	}
}
