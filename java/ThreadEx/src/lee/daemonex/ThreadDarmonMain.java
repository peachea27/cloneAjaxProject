package lee.daemonex;

public class ThreadDarmonMain {

	public static void main(String[] args) {
		/* 데몬스레드 :메인스레드가 종료되면 보조작업도 같이 종료*/
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true); /* 데몬스레드로 설정 */
		autoSaveThread.start(); /* runnable상태 */
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인 스레드 종료");

	}

}


class AutoSaveThread extends Thread {
	
	public void save() {
		System.out.println("작업내용을 저장함.");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
	
	
	
}