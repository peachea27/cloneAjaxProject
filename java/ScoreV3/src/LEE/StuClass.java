package LEE;

public class StuClass {
	//멤버변수
	private int no; //반번호
	private String className; //과정명
	private Student[] stuList;
	private int totalTot; // 학생전체의 총점
	private float totalAvg; //학생 전체의 평균
	
	//일단은 public이라고 해놓음, static final이라서 상수가 아니라 final이라서 상수임
	public static final int STUDENT_COUNT = 3; //학생수(상수)
	
	//생성자:메인 스캐너 1번에서 입력받은 값
	public StuClass(int no, String className) {
		this.no=no;
		this.className = className;
		this.stuList = new Student[STUDENT_COUNT]; // [ null , null , null ]
	}
	

	//생성자 :좌측 상단 source-generate constructor로 만들 수 있음, 이건 직접 만든 것
	//자동 반, 학생 생성시 사용하는 생성자
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
			//(this.totalTot)와 동일
		}
		return totalTot;
	}


	public float calTotalAvg() {//avg는 float
		ScoreV3Main scoreV3 = new ScoreV3Main();
		//반의 각 학생 평균
		this.totalAvg = this.totalTot/ 3f / scoreV3.getcurSavedStudentCnt(); //두 int사이의 3을 float로 만들어줘야함
		this.totalAvg= Math.round(this.totalAvg*100)/100f;
		return this.totalAvg;
	}


	public void searchStudentByNo(String stuNo) {
		boolean isFind = false;
		for ( Student s : this.stuList) {
			if(stuNo.equals(s.getStuNo())) {
				//string타입은 equals로 비교해줘야 한다
				System.out.println("********** 검색된 학생 정보**********");
				System.out.println(s.toString());
				isFind=true;
			}
		}
		if (!isFind) {
			System.out.println("검색된 학생 정보가 없습니다");
		}
	//	int cnt =0;
//		for (Student student : stuClass.getStuList()) {
//			if(stuNum.equals(student.getStuNo())) {
//				System.out.println(stuClass.getStuList()[cnt]);
//			break;
//			}else {
//			cnt++;
//			if (cnt==4) {
//				System.out.println("찾으시는 학생이 없습니다.");
//			}
//			}
//		}
		
	}




	
	
}
