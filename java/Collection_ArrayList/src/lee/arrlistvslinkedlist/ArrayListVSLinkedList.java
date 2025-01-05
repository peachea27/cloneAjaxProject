package lee.arrlistvslinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVSLinkedList {

	public static void main(String[] args) {
		//배열의 중간에 추가나 삭제가 많이 일어나는 작업이라면 LinkedList가 낫다

		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		
		System.out.println("추가하기");
		System.out.println("arraylist: "+add1(al)); //20
		System.out.println("linkedlist: "+add1(ll)); //149
		
		System.out.println("중간에 추가하기");
		System.out.println("arraylist: "+addMid(al)); //990:다른건 arraylist가 더 빠른데 중간에 넣는건 arraylist가 더 느림
		System.out.println("linkedlist: "+addMid(ll)); //3
		
//		System.out.println("삭제하기 (끝에서부터 순서대로)");
//		System.out.println("arraylist: "+remove1(al)); //6
//		System.out.println("linkedlist: "+remove1(ll));//15
		//앞에서 미리 삭제하니까 주석
		System.out.println("삭제하기(앞에서부터 순서대로)");
		System.out.println("arraylist: "+remove0(al)); //949: 중간에서 삭제한다든지 할때 매우 느림
		System.out.println("linkedlist: "+remove0(ll));//116
		
		
//		System.out.println("접근 시간 테스트");
//		System.out.println("arraylist: "+access(al)); //2
//		System.out.println("linkedlist: "+access(ll)); //한참 걸려서 안나옴//12639
	}

	private static long remove0(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i ++) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}

	private static long remove1(List list) {
		long start = System.currentTimeMillis();
		for( int i = list.size() -1; i >=0; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end-start;
	}

	private static long addMid(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i ++) {
			list.add(100, "a");
		}
		
		long end = System.currentTimeMillis();
		return end-start;
	}

	private static long add1(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i ++) {
			list.add(i);
		} 
		long end = System.currentTimeMillis();
		return end-start;
	}

	private static long access(List list) {
		//list는 arraylist, linkedlist다 받을 수 있다
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			list.get(i);
		}
		
		long end = System.currentTimeMillis();
		return end-start;
	}

}
