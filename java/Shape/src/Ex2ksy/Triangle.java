package Ex2ksy;

public class Triangle extends Shape{//이건 추상클래스로 바꿀게 아니라 구체적인걸 실현시켜주면 됨
	//shape.java를 abstract로 바꾸고 override한 drawmethod를 없애면 Triangle.java도 추상클래스로 만들거나 drawmethod를 구현하라고 선택지를 줌
//	단, triangle을 abstract로 바꾸면 ShapeMain에서도 new Triangle이라는 선언을 통한 붕어빵찍기를 못하게 된다.
	private int height;
	private int base;
	
////☆//	Triangle(){
//		super();
//		//아래서 super대신 this를 호출한다고 해도 부모생성자 호출은 해야한다
//	}
	Triangle(String name, String color, Point p, int height, int base){
		super(name, color, p);
		//반드시 첫줄에 생성자 호출
//☆//		this();
		this.base=base;
		this.height=height;
		
	}


	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
	
//	//추상메서드
//	public abstract void draw();
	
	@Override//오버라이딩하면 부모걸 그대로 받아쓰겠다는거고 오버라이딩하면 스스로 보수해서 고쳐쓰겠다는 뜻
	public void draw() {
		System.out.println(this.toString() + "인 삼각형이 그려집니다.");
	}
	@Override
	public String toString() {
		return super.toString() + "Triangle [height=" + height + ", base=" + base + "]";
	}
}
