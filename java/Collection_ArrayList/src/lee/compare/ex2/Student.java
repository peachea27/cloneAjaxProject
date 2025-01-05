package lee.compare.ex2;

public class Student implements Comparable<Student> {
	String stuNum;
	String name;
	int score;
	

	Student(String stuNum, String name, int score) {
		this.stuNum=stuNum;
		this.name = name;
		this.score = score;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Student tmp = (Student)obj; 
		if(this.stuNum.equals(tmp.stuNum)) {
			return result = true;
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		return this.stuNum.hashCode();
	}

	public String getStuNum() {
		return stuNum;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}


	@Override
	public int compareTo(Student o) {
		//학번정렬을 넣어놓으면 학번이 중복으로 안들어감
		return (this.stuNum.compareTo(o.stuNum));//학번 오름차순 정렬
//	    return (this.stuNum.compareTo(o.stuNum))*-1;//학번 내림차순 정렬
//		return this.name.compareTo(o.name); //이름 오름차순 정렬
//		return (this.name.compareTo(o.name))*-1; //이름 내림차순 정렬
//		return this.score<o.score ? -1 :(this.score==o.score ? 0: 1); //점수 오름차순 정렬
//		return this.score<o.score ? 1 :(this.score==o.score ? 0: -1); //점수 내림차순 정렬
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", name=" + name + ", score=" + score + "]";
	}
}


//@Override
//public int compareTo(Student stu) {
//   if (this.stuNum.equals(stu.stuNum)) {
//      return 0;
//   }
//
//   if (this.score == stu.score) {
//      if (this.stuNum.equals(stu.stuNum)) {
//         return this.name.compareTo(stu.name);
//      } else {
//         return this.stuNum.compareTo(stu.stuNum);
//      }
//   } else {
//      return stu.score - this.score;
//   }
//}