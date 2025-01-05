package lee;

public class Main {

	public static void main(String[] args) {
		Employee worker1= new Regular("John",3000000); 
		worker1.work(); 
		Employee worker2=new Parttime("Jane",10000,8);
		worker2.work();
		
		((Parttime)worker2).idle();
		
		HR hr1= new HR();
		hr1.pay(new Parttime("Mick",9000,4));
		hr1.pay(worker1);
	}

}
