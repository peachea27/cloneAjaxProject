package lee.arrlist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		// 데이터 추가
		list.add(10); 
		list.add(30);
		list.add(1, 20);
		list.add(new Integer(40)); //사실 이렇게 넣는게 정석적 
		list.add(new Integer(50));
		//추가
		list.add(new Integer(1));
		//
//		System.out.println(list.toString());
		System.out.println(list);//[10, 20, 30, 40, 50]

		
		//데이터 얻어오기
		int a = (int) list.get(2);//arraylist의 integer없애고 나니 오류:Type mismatch: cannot convert from Object to int//형변환으로 int만들어주기
		System.out.println(a);//30
		
		//리스트의 길이
		System.out.println("리스트의 길이: " + list.size());//처음 10인건 capacity, size는 실질적으로 들어있는 개수 //리스트의 길이: 5
		
		ArrayList list2 = new ArrayList(list.subList(1, 3));//1,3은 1~2까지임
		display(list, list2);//The method display(ArrayList, ArrayList) in the type ArrayListEx is not applicable for the arguments //맨위의 List를 ArrayList 로 바꿔주기
		
		//contains()
		ArrayList list3 = new ArrayList();
		list3.add("A");
		list3.add("B");
		list3.add("C");
		System.out.println(list3.contains("B"));//true
		System.out.println(list3.contains("D"));//false
		System.out.println(list3);//[A, B, C]
		
		list3.set(0, "AA");//0번째 인덱스 요소를 AA로 수정
		System.out.println(list3);//[AA, B, C]
		
		System.out.println(list);//[10, 20, 30, 40, 50]
		list.add(0,"1");
		System.out.println(list);//[1, 10, 20, 30, 40, 50]//[1, 10, 20, 30, 40, 50, 1]앞의 1은 string, 뒤는 int
		
		System.out.println("list.indexOf(\"1\" ) : "+ list.indexOf("1"));//list.indexOf("1" ) : 0
		System.out.println("list.indexOf(new Integer(1)) : "+ list.indexOf(new Integer(1)));//list.indexOf(new Integer(1)) : 6
		
		//삭제
		list.remove(1); //1번째 인덱스를 삭제
		System.out.println(list);//[1, 20, 30, 40, 50, 1]
		
		list.remove("1");//string 1을 삭제
		System.out.println(list);//[20, 30, 40, 50, 1]
		
		list.remove(new Integer(1));
		System.out.println(list);//[20, 30, 40, 50]
		
		//----retainAll()
		ArrayList list4 = new ArrayList();
		list4.add(0);
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(4);
		
		ArrayList list5 = new ArrayList();
		list5.add(1);
		list5.add(2);
		list5.add("A");
		list5.add("B");
		list5.add("C");
		
		display(list4, list5);//[0, 1, 2, 3, 4] //[1, 2, A, B, C]
		
		System.out.println("retainAll()----");
		//list4에서 list5와 겹치는 부분만 남기고 나머지는 삭제
		list4.retainAll(list5);
		display(list4, list5);//[1, 2] // [1, 2, A, B, C]
		
		//list5에서 list4에 포함된 요소들을 삭제
//		System.out.println("removeAll()----------");
//		list5.removeAll(list4);
//		display(list4, list5);
		
		//다른 방법
		System.out.println("list5에서 list4에 포함된 요소들을 삭제");
//		for( int i = 0 ; i < list5.size() ; i++) {//5의 사이즈가 줄어드니까 인덱스가 자꾸 줄어듦
		for (int i = list5.size() -1; i >= 0; i--) {
			if(list4.contains(list5.get(i))) {
				list5.remove(i);
//				i--;
			}
		}
		
		display(list4, list5);//[1, 2] //[2, A, B, C]: 2가 남는 이유는 list5의 size가 줄어서 1이 삭제되는 순간 2가 이미 지나간 순서인 0번째가 됨.. list4의 size로 돌려야 함
		
		//clear() -- 모든 요소 삭제
		list5.clear();
		System.out.println(list5);//[]
	}

	public static void display(ArrayList list1, ArrayList list2) {
		System.out.println("list4 : "+ list1);
		System.out.println("list5 : "+list2);
	}
}
