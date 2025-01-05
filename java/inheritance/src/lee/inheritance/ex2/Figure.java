package lee.inheritance.ex2;

public class Figure {
private String name;
private String color;
private int x;
private int y;

public Figure(String name, String color,int x,int y) {
	this.name=name;
	this.color=color;
	this.x=x;
	this.y=y;
}

public String display() {
	
	return "사각형 이름 : "+this.getName()+ ", 색상 : "+this.getColor()+", (x,y) : ("+this.getX()+","+this.getY()+") ";
}

public String getName() {
	return name;
}

public String getColor() {
	return color;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}
}
