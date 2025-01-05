package lee;

public class JoinTestMain {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join(); /* 지정된 시간동안 특정 스레드가 작업하는 것을 기다림 */
			/* main스레드가 일시정지 상태에 있으면서 sumThread가 작업을 마칠 떄까지 기다린다. */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1~100까지의 합: " + sumThread.getSum());
	}

}

class SumThread extends Thread{
	private long sum;
	
	public long getSum() {
		return sum;
	}
	
	public void setSum(long sum) {
		
	}

	@Override
	public void run() {
		for(int i = 1; i < 101; i++) {
			sum+=i;
		}
	}
}