package lee;

public class ThreadStopMain {

	public static void main(String[] args) {
		TestThread th1 = new TestThread("*");
		TestThread th2 = new TestThread("**");
		TestThread th3 = new TestThread("***");

		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend(); /* th1 일시정지 */
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {
		}
	}

}

class TestThread implements Runnable{

//	boolean suspended = false;
//	boolean stopped = false;
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread th;
	
	TestThread (String name){
		th = new Thread(this, name); /* Thread(Runnable r, String name) */
	}
	
	void start() {
		th.start();
	}
	
	void suspend() {
		suspended = true;
	}
	
	void resume() {
		suspended =false;
	}
	
	void stop() {
		stopped = true;
	}
	
	@Override
	public void run() {
		while (!stopped) { /* stopped = false일 때 실행 */
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
			}
		}
		
		System.out.println(Thread.currentThread().getName()+"-stopped");
	}
	
}