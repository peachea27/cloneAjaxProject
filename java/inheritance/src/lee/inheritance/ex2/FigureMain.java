package lee.inheritance.ex2;

public class FigureMain {

	public static void main(String[] args) {
		Triangle triange1=new Triangle("삼각형", "노란색", 0, 0, 10,30);
		Circle circle1=new Circle("원", "파란색", 0, 0, 5);
		Square square1= new Square("사각형", "빨간색", 0, 0, 40, 40);
		
	System.out.println(	triange1.display());
	System.out.println(	circle1.display());
	System.out.println(square1.display());

	}

}
