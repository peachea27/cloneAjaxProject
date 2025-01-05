package lee.inheritance.basic2;

public class FireEngine extends Car {
	public void hoseWater() {
		System.out.println("물을 뿌립니다.");
	}
	
	@Override//이게 annotation:매서드 위에 붙이면 이건 오버라이드라고 알려줌//컴파일러가 인식 및 검사
	public void accelerate() {
		//왼쪽의 초록 삼각형: 오버라이딩//가속을 업그레이드로 수정
		System.out.println("아주 빠르게 가속합니다.");
	}
}
