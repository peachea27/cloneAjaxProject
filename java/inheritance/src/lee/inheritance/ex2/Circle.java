package lee.inheritance.ex2;

public class Circle extends Figure{
	private int radius;
	
	public Circle(String name, String color,int x,int y, int radius) {
		super(name,color,x,y);
		this.radius=radius;
	}
	
	public String display() {
		return super.display()	+", 반지름:"+this.getRadius();
	}

	public int getRadius() {
		return radius;
	}


}
