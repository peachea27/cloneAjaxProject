//한줄 주석
/*여러줄 주석
 * 
 *규칙) public class가 있는 경우, 소스파일의 이름은 public class의 이름과 일치해야 한다.
*
*/
public class HelloJava {//HelloJava 클래스의 시작
	
	public static void main (String[] args) {//main method(프로그램 실행 시작점)
		System.out.println("Hello, Java!");//줄바꿈 출력
		System.out.print("Hello, Java!");//한줄에 출력
		System.out.println("Hello, Java!");
	}
	
}//HelloJava 클래스의 끝

class HelloA {
	static void sayHello() {
		System.out.println("say Hello!");
	
	}
}
