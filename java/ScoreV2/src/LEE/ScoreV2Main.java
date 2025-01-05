package LEE;

public class ScoreV2Main {

	public static void main(String[] args) {
		Student s1 = new Student("24001","홍길동", 98,75,34);
		s1.displayScore();//학번 : 24001 ,이름 : 홍길동 ,국어 : 98 ,영어 : 75 ,수학 : 34 ,총점 : 0 ,평균 : 0.0 ,학점 : 
		//생성자에서 setter를 호출해줘야 한다
		System.out.println(s1.getKor());
//		s1.setKor(100); //국어점수 수정
//		s1.displayScore();

		Student s2 = new Student("24002","이둘리",45,33,76);
		s2.displayScore();
//		s2.setEng(66);
//		s2.displayScore();
		
		//인스턴스에서 전체총점(static)찍는법
//		System.out.println(Student.totalTot);//private이라 못가져옴, 가져올수 있는 getter메소드를 만들자
		
//		System.out.println(s1.getTotalTot());//static안붙인 매서드.이런식으로 하는 것도 가능하지만..
		System.out.println("S1의 총점 : "+s1.getTot());
		System.out.println("S2의 총점 : "+s2.getTot());
		System.out.println("전체총점 : "+Student.getTotalTot());//클래스이름. static
//	결과가 왜 다르게 나올까?
//		S1의 총점 : 209
//		S2의 총점 : 187
//		전체총점 : 361
//	초기성적끼리 비교하면 맞음	//생성자 안에서 tot를 누적했기 때문에 호출될 때 계산// 즉 처음에 초기값으로 계산 //(~0~)//
		//setter에 해줘야...
//		S1의 총점 : 207
//		S2의 총점 : 154
//		전체총점 : 361
		
		//s2의 국어점수 수정
		System.out.println("s2의 국어성적 수정");
		s2.setKor(66);
		s2.displayScore();
		System.out.println("S1의 총점 : "+s1.getTot()); 
		System.out.println("S2의 총점 : "+s2.getTot());
		System.out.println("전체총점 : "+Student.getTotalTot());
		
		System.out.println("s1의 전체총점: " + s1.getTotalTot());//s1의 전체총점: 382
		System.out.println("s2의 전체총점: " + s2.getTotalTot());//s2의 전체총점: 382
		// 학생들이 총점 공유중>하나의 클래스로 해결하려다보니 논리적으로 맞지 않는 상황 발생
		
		

	}

}
