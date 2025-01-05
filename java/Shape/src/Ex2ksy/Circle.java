package Ex2ksy;

public class Circle extends Shape {
	private int radius;
	
	//생성자
	Circle(String name, String color, Point p, int radius){
		super(name,color,p);
		this.radius=radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println(this.toString() +"원이 그려집니다");
		
	}

	@Override//오버라이딩
	public String toString() {
		return super.toString() +  "Circle [radius=" + radius + "]";
		//아래처럼도 할 수 있다 근데 굳이 이렇게 할 필요는 없지만..
//		return "Triangle [name=" +super.getName()+", color="+super.getColor()
//		+", point=("+super.getP().getX()+","+super.getP().getY()+")";
	}
	
	//오버로딩
	public String toString(String str) {
		//Duplicate method toString() in type Circle->다른매개 줘서 오버로딩
		return str; 
	}
	
	
	
	
}
