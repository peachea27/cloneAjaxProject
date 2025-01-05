package lee.inheritance.ex2;

public class Square extends Figure {
	private int base;
	private int height;
	
	public Square(String name, String color,int x,int y, int base, int height) {
		super(name,color,x,y);
		this.base=base;
		this.height=height;
	}
	public String display() {
		return super.display()+", 밑변 : "+this.getBase()+", 높이 : "+this.getHeight();
	}
	public int getBase() {
		return base;
	}
	public int getHeight() {
		return height;
	}
}
