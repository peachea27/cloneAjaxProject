package LEE;

public class StuClass {
	//멤버변수
	private int no; //반번호
	private String className; //과정명
	private Student[] stuList;
	private int totalTot; // 학생전체의 총점
	private float totalAvg; //학생 전체의 평균
	
	public static final int STUDENT_COUNT = 3; //학생수(상수)
	
	//생성자:메인 스캐너 1번에서 입력받은 값
	public StuClass(int no, String className) {
		this.no=no;
		this.className = className;
		this.stuList = new Student[STUDENT_COUNT]; //[null,null,null]
	}
	

	//생성자 :좌측 상단 source-generate constructor로 만들 수 있음, 이건 직접 만든 것
	public StuClass(int no, String className, Student[] stuList) {
		this.no = no;
		this.className=className;
		this.stuList=stuList;
	}
	
//	좌측 상단 source-generate getters and setters로 getter,setter 만들 수 있음
	 //source-generate toString도 가능
	//getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Student[] getStuList() {
		return stuList;
	}

	public void setStuList(Student[] stuList) {
		this.stuList = stuList;
	}

	public void addStudent(Student student, int no) {
		//학생 한명을 받아 stuList배열의 no번째 요소에 추가
		this.stuList[no] = student;
		
	}
	
	public void outputAllStudents(int curSavedStudentCnt) {
		for (int i = 0; i < curSavedStudentCnt; i++) {
		System.out.println(stuList[i].toString());
		}
		
	}

	@Override
	public String toString() {
		return "StuClass [반번호=" + no + ", 과정명=" + className + "]";
	}


	public int calTotalTot() {
		ScoreV3Main scoreV3 = new ScoreV3Main();
		for ( int i = 0; i <scoreV3.getcurSavedStudentCnt() ; i++) {
			totalTot += stuList[i].getTot();
		}
		return totalTot;
	}



	
	
}
