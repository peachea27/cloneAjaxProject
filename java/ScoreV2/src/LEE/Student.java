package LEE;

import java.io.File;

public class Student {
	//멤버 변수
	private String stuNo;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private float avg;
	private char grade;
	
	private static int totalTot; //전체 학생의 총점
	
	
	// 생성자
	public Student(String stuNo, String stuName, int kor, int eng, int math) {
		this.stuNo=stuNo;
		this.stuName=stuName;
		this.kor=kor;
		this.eng=eng;
		this.math=math; 
		this.tot=this.kor+this.eng+this.math;
		this.avg = (float)this.tot / 3;
		switch ((int)(Math.floor(this.avg / 10))) {
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
	
		default:
			this.grade = 'F';
			break;
		}
//		setTot();
//		setAvg();
//		setGrade();
		//(~0~)//
		totalTot += this.tot;
	}
	
	//getter,setter
	
//	public int getTotalTot() {
//		return totalTot;
//	}
	public static int getTotalTot() {
		return totalTot;
//		return this.tot; //호출 순서상 불가능 
	}
	public String getStuNo() {
		return this.stuNo;
	}
	
	public String getStuName() {
		return this.stuName;
	}
	
	public int getKor() {
		return this.kor;
	}
	
	public int getEng() {
		return this.eng;
	}
	
	public int getMath() {
		return this.math;
	}
	public int getTot() {
		return this.tot;
	}
	
	public float getAvg() {
		return this.avg;
	}
	
	public char getGrade() {
		return this.grade;
	}
	
//	public void setStuName(String stuName, File Certificate,boolean isApproved) {
//		if(isApproved) {
//			this.stuName=stuName;
//		}
//	}개명할 수도 있으니까(Setter를 만들때 이런것들 고려해야 함)

	public void setKor(int kor) {
		totalTot = totalTot -this.kor +kor;
		this.kor = kor;
		setTot();
		setAvg();
		setGrade();//점수 다시 계산
	}
	public void setEng(int eng) {
		this.eng = eng;
		setTot();
		setAvg();
		setGrade();
	}
	public void setMath(int math) {
		this.math = math;
		setTot();
		setAvg();
		setGrade();
	}
	
//	public void setTot(int tot)
//		this.tot =tot;
//}생각없이 이렇게 만들면 안됨

	public void setTot() {
		this.tot = this.kor + this.eng + this.math;
	}
	
	public void setAvg() {
		this.avg = (float)this.tot / 3; //avg의 형식에 맞추기
	}
	
	public void setGrade() {
		switch ((int)(Math.floor(this.avg / 10))) {
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
	
		default:
			this.grade = 'F';
			break;
		}
	}
//메서드
	public void displayScore() {
		System.out.println("학번 : " +this.stuNo +" ,이름 : "+ this.stuName +" ,국어 : "+this.kor +" ,영어 : " + this.eng + " ,수학 : "+this.math + 
				" ,총점 : "+ this.tot +" ,평균 : "+this.avg+" ,학점 : " +this.grade );
	}
	
	
	
}
	