package lee.treeset.ex2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentTreesetMain {

	public static void main(String[] args) {
		
		//반 먼저 생성
		stuClass class1 = new stuClass(1);
		
		
		TreeSet<Student> stuSet = new TreeSet<Student>();
		
		Student s1= new Student("20240707", "홍길동", 20);
		Student s2= new Student("20240708", "홍길서", 100);
		Student s3= new Student("20240707", "홍", 20);
		Student s4= new Student("20240705", "홍길남", 40);
		Student s5= new Student("20240701", "홍길북", 10);
		Student s6= new Student("20240706", "홍남", 30);
		
		//반에 학생 추가
		class1.addStudent(s1);
		class1.addStudent(s2);
		class1.addStudent(s3);
		class1.addStudent(s4);
		class1.addStudent(s5);
		
		//반 학생들 목록 출력
		class1.outputEntrieStudent();
		
		while(true) {
			System.out.println("1.학번순 정렬(오름차순)");
			System.out.println("2.이름순 정렬(오름차순)");
			System.out.println("3.성적순 정렬(내림차순)");
			System.out.println("9.종료하기");
			
			System.out.println("정렬 기준을 선택하세요>>>");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			
			Set<Student> output = new TreeSet<Student>(SortManager.getSortMethod(num));
			output.addAll(class1.getStuSet());
			
			for(Student s : output) {
				System.out.println(s);
			}
		}
		
	}
}
