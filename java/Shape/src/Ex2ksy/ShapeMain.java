package Ex2ksy;

public class ShapeMain {

	public static void main(String[] args) {
		//근데 추상적 개념인 도형이라는 붕어빵을 찍어봤자 의미없음, 어쩄든 찍어낼 수는 있다.
		//추상메서드를 overriding한다는 의미는 객체가 분명해졌다는 의미
//		->이 객체는 더 이상 Shape(추상적이지 않다)
		//논리적 모순이 생기므로 아래와 같이 쓰지 않는다
//		Shape s= new Shape() {
//		
//			
//			@Override
//			public void draw() {
//				System.out.println("draw()메서드 구현....");
//			}
//		};
//		s.draw();
		
		Triangle t1 = new Triangle("삼각형", "red", new Point(100,100),10, 5);
		t1.draw();
		
		Circle c1 = new Circle("원1", "black", new Point(0, 0), 20);
		c1.draw();
		System.out.println(c1.toString("원 그렸습니다!"));
		
//		Rectangle r1=new Rectangle("사각형","yellow",new Point(50,50),100,120)
		//Painter클래스를 생성
		Painter 고흐 = new Painter("고흐");
		고흐.drawShape(c1);
		고흐.drawShape( new Circle("원2", "green", new Point(0, 0), 20));
		고흐.drawShape(t1);
//		고흐.drawShape(r1);
		
		

	}

}
