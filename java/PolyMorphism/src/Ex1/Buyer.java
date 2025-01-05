package Ex1;

public class Buyer {
	private String name;
	private int balance;
	
	Appliance[] appliance = new Appliance[5];
	private int count = 0;
	private int total;
	private float credit;
//	int total =tv.getPrice()+monitor.getPrice()+computer.getPrice();
	int point= (int) (total*0.1);

	Buyer(String name, int balance){
		this.name = name;
		this.balance = balance;
	}
	public void addAppliance(Appliance ap) {
		appliance[count++] = ap;
		total += ap.getPrice();
		credit += ap.getPrice() * 0.1;
	}
}
 