package Ex2ksy;

public class Painter {
	private String name;
	
	Painter(String name){
		this.name = name;
			}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//부모(Shape)이름으로 모든 자식 객체를 매개변수로 다 받을 수 있다!!
	//그림 그리는 메서드
	//부모타입으로 하면 자식 타입을 다 넘겨줄 수 있다
	public void drawShape(Shape shape) {//shape 으로 업캐스팅 되어있는상태
		
		//다형성 1번째 법칙 : 부모 이름으로 자식이 구현한 (오버라이딩) 메서드를 사용가능
		System.out.println(name + "가" + shape.toString()+" 그립니다.");
//		shape.getRadius(); //오버라이딩되지 않은 자손의 메서드에는 부모타입의 참조변수가 접근 불가
		
		if (shape instanceof Circle) {	
		//다운캐스팅을 하면 자손의 메서드를 부를 수 있다
//		((Circle) shape).getRadius() //이렇게 할수잇음//다른도형이 들어오면 //triangle cannot be cast
		Circle c = ((Circle) shape);
		int r =c.getRadius();
		System.out.println("원의 반지름 r은 : "+r);
		}else if (shape instanceof Triangle) {
			Triangle t = (Triangle) shape;
			System.out.println("삼각형의 밑변 : " + t.getBase());
		}
		shape.draw();
	}
	
	@Override
	public String toString() {
		return "Painter [name=" + name + "]";
	}
	
}
