package lee;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RawTypeMain {

	public static void main(String[] args) {
		ArrayList ar = new ArrayList<>();//ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
		
		ar.add(10);//Type safety: The method add(Object) belongs to the raw type ArrayList. References to generic type ArrayList<E> should be parameterized
		ar.add(3.14f);
		ar.add(3.141592d);
		ar.add("대한민국");
		ar.add(new Computer());
		
		System.out.println(ar.toString());
		
		//Generic 타입으로 사용할 것을 권고
		ArrayList<String> ar2 = new ArrayList<String>();
		ar2.add("스트링만");
		ar2.add("저장됨");
//		ar2.add(new Computer());//The method add(String) in the type ArrayList<String> is not applicable for the arguments (Computer)
//		ar2.add(20);//int
		System.out.println(ar2.toString());
		
		// Generic 타입은 참조 타입만 사용가능
//		ArrayList<int> ar3 = new ArrayList<E>();
		//이건 안맞음, 이럴때 wrapper class를 써줘야한다.
		ArrayList<Integer> ar3 = new ArrayList<>();
//		ar3.add("스트링")//The method add(Integer) in the type ArrayList<Integer> is not applicable for the arguments (String)
		ar3.add(10);
		
		//위의 형식보다 아래처럼 인터페이스로 다형성을 구현하여 사용하는 것이 이점이 있다.
//		List<String> ar4 = new ArrayList<>(); //다형성
		List<String> ar4 = new Stack<String>(); //다형성
		//ArrayList에서 Stack으로 변경해서 쓰더라도 하위코드에 영향을 미치지 않는다.
		
		
	}

}
