
public class ScoreV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//성적표
		//국어, 영어, 수학, 총점, 평균, 학점을 계산해서 출력하세요
		String name = "홍길동";
		int kor = 100, eng = 50, math = 71, total = kor + eng + math;
		float avg = (float)total/3;
		//평균은 소숫점 둘째자리까지 출력
		float avg1 = (float)Math.round(avg * 100) / 100;
		char grade;
		switch ((int)Math.floor(avg/10)) {
		case 10 :
		case 9:
			grade = 'A';
			break;
		case 8: 
			grade = 'B';
			break;
		case 7 : 
			grade = 'C';
			break;
		case 6 :
			grade = 'D';
			break;
		default : 
			grade = 'F';
			break;
		}
		// 3항 연산자
		char grade1 = (avg >= 90) ? 'A' : (avg >= 80) ? 'B' : (avg >= 70) ? 'C' : (avg >= 60) ? 'D' : 'F';
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println(name + "\t" + kor + "\t" + eng +"\t" +math + "\t"+total +"\t" +avg1 +"\t"+grade);
		
		System.out.println("name : " + name);
		System.out.println("KOR : " + kor);
		System.out.println("ENG : " + eng);
		System.out.println("MATH : " + math);
		System.out.println("TOTAL : " + total);
		System.out.println("AVERAGE : " + avg1);
		System.out.println("GRADE : " + grade1);
		
		
		
	}

}
