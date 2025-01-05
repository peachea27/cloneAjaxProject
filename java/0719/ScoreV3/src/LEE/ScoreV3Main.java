package LEE;

import java.util.Arrays;
import java.util.Scanner;

public class ScoreV3Main {

	private static int curSavedStudentCnt = 0;
	//private이니까 getter필요
	public int getcurSavedStudentCnt() {
		return curSavedStudentCnt;
	}
	
	private static void outputMenu() {
		System.out.println("***************************************");
		System.out.println("*           성적표V3                    *");
		System.out.println("***************************************");
		System.out.println("*  1.반 생성                            *");
		System.out.println("*  2.생성된 반에 학생 입력(1번부터 수행)      *");
		System.out.println("*  3.전체 학생 점수 출력                   *");
		System.out.println("*  4. 반, 학생 자동 생성                  *");
		System.out.println("*  5. 학번으로 검색                       *");
		System.out.println("*  9.종료                              *");
		System.out.println("***************************************");
		System.out.println("메뉴 번호 입력 >>>");
	
	}
	
	public static void main(String[] args) {
		boolean runBool =true ;
		ScoreV3Main scoreV3 = new ScoreV3Main();//createClass가 static이 아닐경우 이렇게 해서 호출해야함
		StuClass stuClass = null;
		while(runBool) {
			outputMenu();
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
		
			switch (menu) {
			case 1:
				System.out.println("반을 생성합니다.");
				stuClass=scoreV3.createClass();
				break;
			case 2 :
				System.out.println("학생을 입력합니다.....");
//				stuClass=scoreV3.inputStudent(stuClass); //리턴 필요 없음. 어차피 배열이 저장되어 있기 때문에
				scoreV3.inputStudent(stuClass);
				break;
			case 3 :
				System.out.println("전체 학생 점수 출력합니다.........");
				scoreV3.outputEntireStudent(stuClass);
				break;
			case 4:
				stuClass=scoreV3.autoInputStudent(); //반, 학생 자동 생성
				break;
			case 5:
				scoreV3.searchStudentByNo(stuClass); //학번으로 검색
			case 9:
				runBool = false;
//				System.exit(0);//프로그램 종료
				break;
			}
		}

		}
	private void searchStudentByNo(StuClass stuClass){
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을 학번 입력>>>");
		String stuNo=sc.nextLine();
		stuClass.searchStudentByNo(stuNo);//이렇게 같은 이름으로 만들어도  된다
		
		
	}
	
	
//	private void searchStudentByNo(StuClass stuClass){
//		Scanner sc = new Scanner(System.in);
//		System.out.println("찾을 학번 입력>>");
//		String stuNum=sc.nextLine();
//
//		int cnt =0;
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
//	}

	private StuClass autoInputStudent() {
		
		Student[] stuList = {new Student("24001", "홍길동", 55, 55, 44),
				new Student("24002", "홍길서", 78, 66, 34),
				new Student("24003","홍길남",99,98,100),
				new Student("24004","홍길북",99,56,35)};
		curSavedStudentCnt=stuList.length;
			StuClass stuClass = new StuClass(2 , "jsp" , stuList);
			return stuClass;		
	}

	private void outputEntireStudent(StuClass stuClass) {
		System.out.println("==================================");
		System.out.println("                        성 적 표                       ");
		System.out.println("==================================");
		System.out.println("반 번호: " +stuClass.getNo() + ", 과정명: " +stuClass.getClassName());
		System.out.println("-----------------------------------------------------");
		stuClass.outputAllStudents(curSavedStudentCnt);
		System.out.println("-------------------------------------------");
		System.out.println("전체 총점 : " + stuClass.calTotalTot() +" , 전체 평균" +stuClass.calTotalAvg());
//		+ ", 전체 평균 : " + stuClass.calTotalAvg());
	}

	private StuClass createClass() {//StuClass타입으로 반환하겠다
		curSavedStudentCnt=0;//반생성자, 이게 있어야 네명 넣어도 안터짐, 저장된 학생 수 초기화
		Scanner sc = new Scanner(System.in);
		System.out.println("반 번호 입력>>>");
		int classNo = sc.nextInt();
		sc.nextLine();
		System.out.println("과정명 입력>>>");
		String className = sc.nextLine();
		
		StuClass c1 = new StuClass(classNo, className);
		System.out.println(c1.toString());
		System.out.println(Arrays.toString(c1.getStuList()));
		
		return c1;
	}
	
	private void inputStudent(StuClass stuClass) {
		if(stuClass == null) {
			System.out.println("반 부터 생성하고 오세요......");
		}else {
			if(curSavedStudentCnt < stuClass.STUDENT_COUNT) {
		//학생 입력
		Scanner sc = new Scanner(System.in);	
		System.out.println("학생 번호>>>");
		String stuNo = sc.nextLine();
		System.out.println("학생 이름>>>");
		String stuName = sc.nextLine();
		System.out.println("국어 점수>>>");
		int kor =Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수>>>");
		int eng =Integer.parseInt(sc.nextLine());
		System.out.println("수학 점수>>>");
		int math =Integer.parseInt(sc.nextLine());
//		Student stu1 = new Student(stuNo, stuName, kor, eng, math)
//	    addStudent(stu1);
		stuClass.addStudent(new Student(stuNo, stuName, kor, eng, math),curSavedStudentCnt);
		curSavedStudentCnt++;
			}else {
				System.out.println("학생 수가 초과됩니다.");
			}
		}
	}
	
	}


