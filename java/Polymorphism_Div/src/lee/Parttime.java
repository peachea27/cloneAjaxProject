package lee;

public class Parttime extends Employee {
	int wage;
	int hours;
	
	Parttime(String name,int wage, int hours){
		super(name);
		this.wage=wage;
		this.hours=hours;
		
	}

	public void work() {
		
		System.out.println(this.getName()+"은 알바중입니다.");
	}
	
	public void idle() {
		System.out.println(getName()+"은 딴짓하는 중입니다.");
	}
public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}



@Override
public String toString() {
	return "Parttime [paycheck=" +wage*hours + "]";
}
}