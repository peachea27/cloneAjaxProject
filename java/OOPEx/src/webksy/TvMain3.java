package webksy;

public class TvMain3 {

	public static void main(String[] args) {
		TvData data = new TvData(); // 티비객체 생성
		on(data);
		volumeUp(data);
		volumeUp(data);
		volumeDown(data);
		checkStatus(data);
		off(data);
	}

	static void off(TvData data) {
		data.isOn = false; // 티비 끄기
		System.out.println("티비를 꺼집니다.");
	}

	static void on(TvData data) {
		data.isOn = true; // 티비 켜기
		System.out.println("티비가 켜집니다.");
	}
	
	static void volumeUp(TvData data) {
		data.volume++;
		System.out.println("TV 볼륨 : " + data.volume);
	}
	
	static void volumeDown(TvData data) {
		data.volume--; // 볼륨 감소
		System.out.println("TV 볼륨 : " + data.volume);
	}
	
	static void checkStatus(TvData data) {
		if (data.isOn) {
			System.out.println("티비가 켜져있습니다, 볼륨 : " + data.volume);
		} else {
			System.out.println("티비가 꺼져있습니다");
		}
	}
}
