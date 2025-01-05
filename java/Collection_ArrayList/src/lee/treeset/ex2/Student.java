package lee.treeset.ex2;

public class Student implements Comparable<Student> {
	String stuNo;
	String name;
	int score;
	
	
	Student(String stuNo, String name, int score) {
		this.stuNo=stuNo;
		this.name = name;
		this.score = score;
	}
	
	
	@Override
	public int compareTo(Student o) {
		return stuNo.compareTo(o.stuNo);
	}
	
	public String getStuNo() {
		return stuNo;
	}


	public String getName() {
		return name;
	}


	public int getScore() {
		return score;
	}


	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + ", score=" + score + "]";
	}


}
