package LEE;
//scoreV2의 Student 복붙, ★★★만 확인
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
	
	
	// 생성자
	public Student(String stuNo, String stuName, int kor, int eng, int math) {
		this.stuNo=stuNo;
		this.stuName=stuName;
		this.kor=kor;
		this.eng=eng;
		this.math=math; 
		
		//필요한 만큼의 영역을 드래그 해 준 후 우클릭> refactor > extract method를 해서 calScore만듦★★★★★★★★★★★★★★★★★★★★★★★
		CalScore();

	}

	private void CalScore() {
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
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	@Override
	public String toString() {
		return "Student [학번=" + stuNo + ", 이름=" + stuName + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math
				+ ", tot=" + tot + ", 평균=" + avg + ", 학점=" + grade + "]";
	}
	
	//getter,setter
	
	
//메서드
	
	
}
	