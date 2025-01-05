package webksy;

public class Tv {
	// 속성
	boolean isOn = false;
	int volume = 0;
	
	// 메서드 
	void on() {
		isOn = true;
		System.out.println("티비가 켜집니다.");
	}
	
	void off() {
		isOn = false;
		System.out.println("티비가 꺼집니다.");
	}
	
	void volumeUp() {
		volume++;
		System.out.println("TV 볼륨 증가 : " + volume);
	}
	
	void volumeDown() {
		volume--;
		System.out.println("TV 볼륨 감소 : " + volume);
	}
	
	void checkStatus() {
		if (isOn) {
			System.out.println("티비가 켜져있습니다, 볼륨 : " + volume);
		} else {
			System.out.println("티비가 꺼져있습니다");
		}
	}
	
}
