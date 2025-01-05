package lee.compare.ex;

import java.util.ArrayList;
import java.util.List;

public class SortMain {

	public static void main(String[] args) {
		User user1 = new User("dooly", 10);
		User user2 = new User("ddochi",8);
		User user3 = new User("kildong",40);
		
		List<User> ulist = new ArrayList<User>();
		ulist.add(user1);
		ulist.add(user2);
		ulist.add(user3);
		
		System.out.println("==========정렬 전===========");
		System.out.println(ulist);
		System.out.println("==========정렬 후===========");
		ulist.sort(null);
		System.out.println(ulist);//Comparable 구현(기본정렬) :user에 주석했을 경우
		
		System.out.println("==========정렬 후===========");
		ulist.sort(new MyIdComparator());//Comparator를 구현한 new 
		System.out.println(ulist);
	}

}
