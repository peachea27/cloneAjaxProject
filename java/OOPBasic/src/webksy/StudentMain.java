package webksy;

import java.util.Arrays;

public class StudentMain {

	public static void main(String[] args) {
		// Student 객체 생성
		Student stu1 = new Student();
		stu1.name = "둘리";
		stu1.kor = 80;
		stu1.grade = 'B';
		System.out.println("stu1 : name = " + stu1.name + ", kor = " + stu1.kor + 
				", grade = " + stu1.grade);
		
		Student stu2 = new Student();
		
		stu2.name = "홍길동";
		stu2.kor = 50;
		stu2.grade = 'D'; 
		 
		System.out.println("stu2 : name = " + stu2.name + ", kor = " + stu2.kor + 
				", grade = " + stu2.grade);
		
		Student[] students = new Student[2];
		students[0] = stu1;
		students[1] = stu2;
		
		System.out.println("name = " + students[0].name + ", kor = " + students[0].kor + 
				", grade = " + students[0].grade);
		System.out.println(Arrays.toString(students));
//		System.out.println(Arrays.toString(students[0]));
		
		// Student객체의 메서드 displayStudent() 호출
		stu1.displayStudent();
		stu2.displayStudent();
		
	}

}
