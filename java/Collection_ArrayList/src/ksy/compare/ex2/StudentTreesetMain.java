package ksy.compare.ex2;

import java.util.TreeSet;



public class StudentTreesetMain {

	public static void main(String[] args) {
		TreeSet<Student> stuSet = new TreeSet<Student>();
//		
		Student s7= new Student("20240708", "홍길서", 100);
		Student s2= new Student("20240708", "홍길서", 100);
		Student s1= new Student("20240707", "홍길동", 20);
		Student s3= new Student("20240707", "홍", 20);
		Student s4= new Student("20240705", "홍길남", 40);
		Student s5= new Student("20240701", "홍길북", 10);
		Student s6= new Student("20240706", "홍남", 30);
//		
		System.out.println(stuSet.add(s1)); 
		//java.lang.ClassCastException
		//Student cannot be cast to java.lang.comparable =>implements comparable
		stuSet.add(s2);
		stuSet.add(s3);
		System.out.println(stuSet.add(s4)); 
//		
		System.out.println(stuSet); 
		
		for(Student s : stuSet) {
			System.out.println(s);
		}
		
		//----성적비교기----
		System.out.println("----성적비교----");
		ScoreComparator scoreCompara = new ScoreComparator();
		TreeSet<Student> scoreSet = new TreeSet<Student>(new ScoreComparator());
		scoreSet.add(s1);
		scoreSet.add(s2);
		scoreSet.add(s3);
		scoreSet.add(s4);
		//성적이 같으면 안들어감, 어떻게 들어가게 만들까?
		
		for(Student s : stuSet) {
			scoreSet.add(s);
		}
	
		for(Student s : scoreSet) {
			System.out.println(s);
		}
	}

}
