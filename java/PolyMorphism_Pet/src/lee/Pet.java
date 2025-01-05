package lee;

public abstract class Pet {
	private String name;
	private String type;
	private int age;
	
	protected Pet() {
		
	}
	
	//생성자
	protected Pet(String name, String type, int age){//protected해야 패키지달라도 상속관계끼리 호출가능
		this.name=name;
		this.type=type;
		this.age=age;
	}

	//메서드
	public void doWalk() {
		System.out.println("걸어 다닙니다.");
	}
	//무슨 소리를 내는지 모름, 추상메서드로
//	public void doCry() {
//		System.out.println("애완동물이 소리를 낸다.");
//	}
	public abstract void doCry(); //바디(구체화된 구현부) 없이 선언부만 만들어줌
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + "]";
	}
}
