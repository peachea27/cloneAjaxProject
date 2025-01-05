package lee.basic;

public class PolyMain {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.parentMethod();
		
		Child child = new Child();
		child.childMethod();
		
		//다형성
		//조상 클래스타입의 참조변수로 자손클래스의 인스턴스를 참조
		Parent poly = new Child();
		poly.parentMethod();
//		poly.childMethod();//이런건 없다 undefined
		
//		Child poly2 = new Parent();//자식타입으로는 부모의 인스턴스를 담을 수 없다
		
	}

}
