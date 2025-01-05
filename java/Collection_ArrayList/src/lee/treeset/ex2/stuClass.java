package lee.treeset.ex2;

import java.util.Set;
import java.util.TreeSet;

public class stuClass {
	private int classNo;
	private Set<Student> stuSet;
	/**
	 * 생성자
	 */
	public stuClass(int classNo) {
		super();
		this.classNo = classNo;
//		this.stuSet = new TreeSet<Student>();
		this.stuSet = new TreeSet<Student>(new DescendingByStuScore());
	}
	
	//getter,setter
	public Set<Student> getStuSet() {
		return stuSet;
	}
	public void setStuSet(Set<Student> stuSet) {
		this.stuSet = stuSet;
	}
	public int getClassNo() {
		return classNo;
	}
	//학생을 TreeSet에 추가
	public void addStudent(Student s) {
		boolean existStudent = false;
		for(Student stu : this.stuSet) {
			if(stu.getStuNo().equals(s.getStuNo())) {
				existStudent = true;
				break;
			}
		}
		if(!existStudent) {
		this.stuSet.add(s);
		}else {
			System.out.println("학번 : "+s.getStuNo()+"가 이미 존재합니다.");
		}
	}
	public void outputEntrieStudent() {
		for(Student s : this.stuSet) {
			System.out.println(s);
		}
	}
	
}
