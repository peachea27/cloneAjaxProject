package LEE;

public class MobilePhone2 {
	 String brandName;
	 String modelName;
	 int mainMemory;
	 String color;
	 
	 //14^^이거 주석 후>폰메인에 오류가 생김. 오류가 생긴 폰메인의 15^^에서 추가설명
	 //다른 생성자가 있을 때는 자동생성해주지 않기 때문에 아무 역할이 없더라도 필요하다면 직접 만들어주어야한다
	 public MobilePhone2() {// 7^^ 기본 생성자 >> 객체가 만들어질 때 딱 어떤 일을 해주어야 한다
		 System.out.println("고갱님~ 폰이 개통되었습니다!");
	 }
//	 
	 //----------------------13^^ 아래의 두 매서드는 겹치는 부분이 많음--------------------------------
	 
	 //9^^여긴 파라미터가 4개>> 생성자 오버로딩: 다른 매개변수로 매서드 같게
	 public MobilePhone2(String barndName, String modelName, int mainMemory, String color) {
		 this.brandName = brandName;
		 this.modelName = modelName;
		 this.mainMemory = mainMemory;
		 this.color = color;
		 //14^^ 생성자 소환: this는 첫번째 문장에서만 써야 한다
//		 this(); Constructor call must be the first statement in a constructor//
	 }
	 
	 //11^^
	 public MobilePhone2(String brandName, String modelName) {//또다른 생성자 오버로딩
//		 this.brandName = brandName;
//		 this.modelName= modelName;
//		 this.mainMemory=256;
//		 this.color="흰색";	 
		 //13-1: 13^^의 해결책: 기존코드 주석 및 아래로 재창조
		 this(brandName,modelName,256,"흰색");
		 //생성자도 오버로딩 할 수 있는데 중복을 줄이기 위해 기존의 것을 호출하면서 값을 넘겨받아 속성값 초기화시킴
		 //위의 this와는 다른 this이다. 이건 생성자 호출하는 것
	 }
	 
//---------------------------------------------------------------------------------------------------------
//	 13-2^^
//	 public MobilePhone(String brandName, int mainMemory) {
//		 this(brandName, null, mainMemory, null);//수를 맞추기 위해 null받아도 됨
//	 }
	 
	 //13-3^^이렇게 해도 같다
	 public MobilePhone2(String color, int mainMemory) {
		 //14^^제일 첫문장에 써줘야 한다. 다음 코드들의 순서를 바꾸면 오류
		 this("삼성", "플립", mainMemory, color);
		 this.brandName="삼성";
		 this.modelName="플립";
	 }
	 
	 //16^^ 어쩄든 중복을 줄여야...
	 public MobilePhone2(int mainMemory, String brandName) {
		 this("흰색", mainMemory);
		 this.brandName = brandName;
	 }
	 //9-1^^메서드
	 public String toString() {
		 return "[" + this.getClass().getName() + ": " + this.hashCode() +
				 "]=brandName : " + this.brandName +", modelName : " + this.modelName
				 + ", mainMemory : " + this.mainMemory + ",color : "+color;//여기서는 this안붙여줘도 되긴함
	 }
	 
	
	 
	 
}
