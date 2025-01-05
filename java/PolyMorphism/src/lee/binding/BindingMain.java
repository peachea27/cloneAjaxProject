package lee.binding;

public class BindingMain {

	public static void main(String[] args) {
		Child c = new Child();
//		c.method();
		
		Parent poly =(Parent) new Child(); //parent로 바꿔서 담아줘야 하지만 생략해도 자동으로 캐스팅해줌
		System.out.println("poly.x:" +poly.x);//parent.x
		poly.method();//childmethod호출, 오버라이딩된 자손의 메서드는 호출가능
		//child.childMethod(); //child가 오버라이딩한건 접근 가능하지만 child의 메소드에는 접근불가
	}

}
