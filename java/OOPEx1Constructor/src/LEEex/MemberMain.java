package LEEex;

public class MemberMain {

	public static void main(String[] args) {
		//MemberService의 login(유저가 입력한 아이디, 유저가 입력한 비밀번호) 메서드가 true를 반환하면
				//"로그인되었습니다"출력하고,
				//false를 반환하면 "아이디나 패스워드가 틀립니다" 출력
		
		Member loginInfo = new Member("dooly","1234"); //로그인시 입력한 정보
		MemberService ms = new MemberService();
		
		boolean result =ms.login(loginInfo.getId(), loginInfo.getPwd());
	
		
		if(result) {
			System.out.println("로그인되었습니다");
		}else {
			System.out.println("아이디나 패스워드가 틀립니다.");
		}

	}

}
