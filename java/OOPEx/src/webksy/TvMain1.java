package webksy;

public class TvMain1 {

	public static void main(String[] args) {
		// 절차지향적 
		boolean isOn = false;
		int volume = 0;
		
		isOn = true; // 티비 켜기
		System.out.println("티비가 켜집니다.");
		
		volume++; // 볼륨 증가
		System.out.println("TV 볼륨 : " + volume);
		
		volume++;
		System.out.println("TV 볼륨 : " + volume);
		
		volume--; // 볼륨 감소
		System.out.println("TV 볼륨 : " + volume);
		
		// 상태확인
		if (isOn) {
			System.out.println("티비가 켜져있습니다, 볼륨 : " + volume);
		} else {
			System.out.println("티비가 꺼져있습니다");
		}
		
		isOn = false; // 티비 끄기
		System.out.println("티비를 꺼집니다.");
		
		
	}

}
