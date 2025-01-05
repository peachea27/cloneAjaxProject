package lee;

public class HR {

	HR(){
		
	}
	
	public void pay(Employee employee) {
		if(employee instanceof Regular ) {
		System.out.println(employee.getName()+ "에게 기본급을 지급합니다.");
		System.out.println(employee.toString()); 
		}else if (employee instanceof Parttime) {
			System.out.println(employee.getName()+"에게 시급을 지급합니다.");
			System.out.println(employee.toString());
		}
	}
}
