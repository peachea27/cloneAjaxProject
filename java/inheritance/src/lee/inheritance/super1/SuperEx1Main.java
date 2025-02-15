package lee.inheritance.super1;

class Parent{//public class 하나 더 할 수 없어서 public뺴줌//public class있다면 그것과 파일 이름을 일치시켜줘야 함//public class하나도 없을 때도 있긴 하다
	int a = 10;
	int b =100;
	
	Parent(){
		System.out.println("부모 기본 생성자");
	}
	void sing() {
		System.out.println("부모가 노래합니다.");
	}
}

class Child extends Parent{
	int a = 20;
	int c = 200;
	
	Child() {
		System.out.println("자식 기본 생성자");
	}
	
	void display() {
		System.out.println("a : "+a);//더 가까운 쪽을 찍음, 내거
		System.out.println("this.a :" + this.a);//내거
		System.out.println("super.a : "+ super.a);//super는 상위: 부모를 가리킴
		System.out.println("b : "+ b);//내거에서 없으면 부모거에서 찾아서 찍어줌
		System.out.println("c : "+ c);
		
//		sing();//void lee.inheritance.super1.Parent.sing ()//자기 개체에서 찾다가 없으면 부모에게 가서 찾음
		super.sing();
		this.sing();
	}
	
	@Override
	void sing() {
		System.out.println("자식이 노래합니다.");
		//옆에 초록 삼각형: 오버라이딩 중 //어노테이션 안붙이면..그냥 똑같이 나옴, 그러나 복잡해진 나중을 대비해서,, 컴파일러가 찾아줄것
	}
}

public class SuperEx1Main {

	public static void main(String[] args) {
		Child child = new Child();//child기본 생성자 호출//그랬더니 부모가 먼저 호출됨//그다음 자식생성자
		child.display();
		child.sing();
		
		Parent parent = new Parent();
		parent.sing();//부모가 노래합니다.//부모는 물려주기만 하지 자식걸 가져오지는 못함
//		parent.display();
	}

}
