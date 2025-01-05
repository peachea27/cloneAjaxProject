package lee.compare.ex;

import java.util.Comparator;

public class MyIdComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
//		return o1.getUserId().compareTo(o2.getUserId());//오름차순
		return o2.getUserId().compareTo(o1.getUserId());//내림차순
	
	}

	
}
