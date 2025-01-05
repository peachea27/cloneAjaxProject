package lee.iterable;

import java.awt.DisplayMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IterableMain {

	public static void main(String[] args) {
		System.out.println(3/0);
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		Iterator listIter = list.iterator();
		display(listIter);
		
	
//		
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);	
		set.add(2);
		set.add(3);
		Iterator intIter = set.iterator();
		display(intIter);
		
	}

	private static void display(Iterator intIter) {
		while(intIter.hasNext()) {
			System.out.println(intIter.next());
		}
		
	}

}
