package lee.regnoex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Korean k1 = new Korean("240730-1234567", "홍길동");
		Korean k2 = new Korean("240730-1234567", "홍길동");
		Korean k3 = new Korean("240730-1234567", "홍길동");
		
		Set set = new HashSet();
		set.add(k1);
		set.add(k2);
		set.add(k3);
		
		
		Student s1 = new Student();
		set.add(s1); 
//		k1.equals(s1);//korean이 아니라서 터짐//Student cannot be cast to lee.regnoex.Korean =>예외처리
		
		System.out.println("k1의 해시코드: "+k1.hashCode()+", k2의 해시코드: "+k2.hashCode());//k1의 해시코드: 705927765, k2의 해시코드: 366712642
		System.out.println(k1==k2);//false
		System.out.println(k1.getRegNo() == k2.getRegNo());//true
		System.out.println((k1.getRegNo()).equals(k2.getRegNo()));//true
		System.out.println("k1.getRegNo().hashCode(): "+k1.getRegNo().hashCode()+", k2.getRegNo().hashCode(): "+k2.getRegNo().hashCode());
		//k1.getRegNo().hashCode(): 817241933, k2.getRegNo().hashCode(): 817241933 // 동일
		
//		System.out.println(k1.equals(k2));//true
		
		
		System.out.println(set);//[Korean [regNo=240730-1234567, name=홍길동], Korean [regNo=240730-1234567, name=홍길동]]
		//toString이 있으면 자동으로 toString으로 찍힘//[lee.regnoex.Student@2a139a55, Korean [regNo=240730-1234567, name=홍길동]]
		//그래서 student는 object가 자기 방식으로 보여주고 korean은 toString방식으로 보여주는 것
		

	}


}
