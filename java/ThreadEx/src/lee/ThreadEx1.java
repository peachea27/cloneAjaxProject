package lee;

class ThreadEx extends Thread{

	public ThreadEx() {
		
	}

	public ThreadEx(String name) {
		super.setName(name);
	}

	/** 스레드가 생성되어 실행될 떄 자동으로 호출되는 일종의 콜백함수 */
	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			System.out.println(this.getName()+ ", j : "+ i );
			for (int j = 0; j < 1000000; j++);/* 그냥 지연되라고 */
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class  ThreadRunnable implements Runnable{

	@Override
	public void run() {
		for( int i = 0; i < 10; i++) {
			/* 메인함수의 스레드 */
			System.out.println(Thread.currentThread().getName() + ", i" + i );
			for (int j = 0; j < 1000000; j++);
		} 
		
	}
	
}


public class ThreadEx1 {

	public static void main(String[] args) {
		
		/* 스레드 객체 생성 
		 * 1) Thread 클래스를 상속받아 구현한 클래스 */
		ThreadEx t1= new ThreadEx();
//		ThreadEx t1 = new ThreadEx("t1");
		
		t1.setName("스레드1"); /* 스레드 이름 수정 */
		/* 우선순위를 높여보자 */
		t1.setPriority(Thread.MAX_PRIORITY); /* start()실행 전에 해야 한다 */
		t1.start(); /* 스레드가 시작되며 스레드가 실행 가능한(Runnable) 상태로 놓이게 된다 */
		
		/* 2)Runnable 인터페이스를 구현한 클래스 */
		Runnable r = new ThreadRunnable();/* 다형성 */
		Thread t2 = new Thread(r);
		t2.setName("스레드2");
		t2.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		
		try {
			Thread.sleep(2000);/* 스테틱은 이런식으로 재울 수가 없음. 그래서 main이 2초간 일시정지 상태가 됨 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for( int i = 0; i < 10; i++) {
			/* 메인함수의 스레드 */
			System.out.println(Thread.currentThread().getName() + ", m" + i );
			for (int j = 0; j < 1000000; j++);
		}
		
	}

}
