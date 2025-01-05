package lee.sortlistex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortListEx {

	public static void main(String[] args) {
		String[] strArr = {"a","b","e","q","E","W","B"};
		Arrays.sort(strArr); //대문자 먼저, 소문자를 사전식으로 정렬(기본)
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr,String.CASE_INSENSITIVE_ORDER); //대소문자 구분 없이 사전식으로 정렬
		System.out.println(Arrays.toString(strArr));
		
		List<String> list = new ArrayList<String>();
		list.add("z도우너");
		list.add("a홍길동");
		list.add("e둘리");
		list.add("b마이콜");   
		
		System.out.println("----------------정렬 전------------------");
		System.out.println(list);
		System.out.println("----------------정렬 후------------------");
		list.sort(null);//null을 넣으면 기본
//		System.out.println(list);
		
		Comparator<String> comp = new Comparator<String>() {
			
			@Override//오버라이딩이기 때문에 이 형식 반드시 지켜줘야 함
			public int compare(String o1, String o2) {
				// String//o1 <o2:The operator < is undefined for the argument type(s) java.lang.String, java.lang.String
				//스트링타입에는 <,>,<=,>=연산자 적응 불가
//				if(o1 <o2) {
//					return -1;
//				}
//				return o1.compareTo(o2);//오름차순
				return o2.compareTo(o1);//내림차순
			}
		};	
		
		list.sort(comp);
		System.out.println(list);
		
		// 정수 arraylist
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(30);
		intList.add(120);
		intList.add(20);
		intList.add(0);
		intList.add(11);
		System.out.println("----------------정렬 전------------------");
		System.out.println(intList);
		System.out.println("----------------정렬 후------------------");
		intList.sort(null);
		System.out.println(intList);
		
		Comparator<Integer>compara = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				//오름차순
//				if(o1<o2) {
//				return -1;
//				}else if(o1 ==o2) {
//				return 0;
//				}else {
//				return 1;
//				}
				//내림차순
//				if(o1<o2) {
//					return 1;
//				}else if(o1 ==o2) {
//					return 0;
//				}else {
//					return -1;
//				}
				return (o1 < o2) ? 1 : ((o1==o2) ? 0 : -1);//내림차순
			}
		};
		
		intList.sort(compara);
		System.out.println(intList);
	}
}
