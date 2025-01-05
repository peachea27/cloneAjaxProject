package Ex2ksy;

public abstract class Shape {//추상메서드를 위해서, 추상메서드가 하나라도 있으면 그 클래스는 추상클래스가 되어야 함
	private String name;
	private String color;
	private Point p;
	
	//생성자
//	public Shape() {
//	}
	
	 Shape(String name, String color, Point p) {
		this.name =name;
		this.color=color;
		this.p=p;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	//그리는 메서드
//	public void draw() {
//		System.out.println("도형을 그립니다..");
//	}
	
	//이거 대신
//  추상메서드
	public abstract void draw();
	
	//toString은 가장 밑에
	@Override
	public String toString() {
		return "Shape [name=" + name + ", color=" + color + ", p=" + p + "]";
	}
}
