package lee.synchronize;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncCollectionMain {

	public static void main(String[] args) {

//		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 2; i++) {
			es.execute(new Runnable() {

				@Override
				public void run() {
					while(true) {
						synchronized (list) {
							list.clear();
							list.add(100);
							list.remove(0);
						}
					}
				}		
				
			});	
			}
		

	}

}
