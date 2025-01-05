package lee.hashsetex;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {

	public static void main(String[] args) {
		HashSet setA = new HashSet();
		
		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
//		setA.add("3");//배열기반이면 3이 한번 더 들어갔겠지만.. 중복을 허용하지 않는다.
		
		
		System.out.println("setA : " + setA);//setA : [1, 2, 3, 4, 5] 중복을 허용하지 않음
		
		HashSet setB = new HashSet();
		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		System.out.println("setB : "+setB);
		
		//출력
		Iterator iter = setB.iterator();
		System.out.println(iter.hasNext());//true
		while(iter.hasNext()) {
			//hasnext가 true면 next를 출력, hasnext가 없을때까지 반복
			System.out.print(iter.next());
		}
		System.out.println();
		
		// setA와 setB에 공통으로 있는 요소(교집합)
		HashSet setInter = new HashSet();
		
		Iterator iterB = setB.iterator();
		while(iterB.hasNext()) {
			Object tmp = iterB.next();
			if(setA.contains(tmp)) {
				setInter.add(tmp);
			}
		}
		
		System.out.println("setA와 setB의 교집합 : " + setInter);
		//차집합
		HashSet setDiff = new HashSet();
		
		Iterator iterA = setA.iterator();
		while(iterA.hasNext()) {
			Object tmp = iterA.next();
			if(!setB.contains(tmp)) {// setB가 tmp(setA의 요소중 하나)를 포함하고 않으면 
				setDiff.add(tmp);
			}
		}
		
		System.out.println("차집합(A-B): "+setDiff);
		////
		
		HashSet setAA = new HashSet(setA);
		setAA.removeAll(setInter);
		System.out.println("차집합: "+setAA);
		//합집합
		HashSet setUni = new HashSet();
		
		iter = setA.iterator(); 
		while(iter.hasNext()) {
			setUni.add(iter.next()); 
		}
		iter =setB.iterator();
		while(iter.hasNext()) {
			setUni.add(iter.next());
		}
		System.out.println("합집합(A+B): "+setUni);
		
		HashSet setBB = new HashSet(setB);
		HashSet setAAA=new HashSet(setA);
		setBB.removeAll(setInter);
		setAAA.addAll(setBB);
		System.out.println("합집합: "+setAAA);
		
//		Iterator itB = setB.iterator();
//		while(itB.hasNext()) {
//			System.out.println(itB.next());
//			setA.addAll(setInter)
//			System.out.println(setA);
//		}
		
		
//		setA.retainAll(setB);
//		setInter=setA;
//		System.out.println(setInter);
		
//		for(int i = 0; i <setA.size(); i++) {
//			if(setA.contains(setB.get(i))
//		}
	}

}
