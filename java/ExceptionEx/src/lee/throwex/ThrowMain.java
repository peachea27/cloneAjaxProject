package lee.throwex;

public class ThrowMain {

	public static void main(String[] args) {
		Student stu1 = null;
		
		try {
			stu1 = new Student("24001", "홍길동", -80, 90, 70); //생성자 호출시 -80의 국어점수로 인해 예외발생
			stu1.displayScore();
			
		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
			System.out.println("국어 점수를 잘못 입력했습니다.");
		} catch(NullPointerException e) {
			System.out.println("점수를 출력할 수 없습니다.");
		}
		
	}

}
