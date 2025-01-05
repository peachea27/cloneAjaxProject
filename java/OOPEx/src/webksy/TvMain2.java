package webksy;

public class TvMain2 {

	public static void main(String[] args) {
		TvData data = new TvData(); // 티비객체 생성
		
		data.isOn = true; // 티비 켜기
		System.out.println("티비가 켜집니다.");
		
		data.volume++; // 볼륨 증가
		System.out.println("TV 볼륨 : " + data.volume);
		
		data.volume++;
		System.out.println("TV 볼륨 : " + data.volume);
		
		data.volume--; // 볼륨 감소
		System.out.println("TV 볼륨 : " + data.volume);
		
		// 상태확인
		if (data.isOn) {
			System.out.println("티비가 켜져있습니다, 볼륨 : " + data.volume);
		} else {
			System.out.println("티비가 꺼져있습니다");
		}
		
		data.isOn = false; // 티비 끄기
		System.out.println("티비를 꺼집니다.");
		
	}

}
