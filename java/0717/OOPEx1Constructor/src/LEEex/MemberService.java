package LEEex;

public class MemberService {

	//login(아이디, 비밀번호) 메서드 -> true | false를 반환
	
	//가입시 회원 정보: "dooly", "1234"
	
	boolean login(String memberId, String memberPwd) {
		if(memberId.equals("dooly") && memberPwd.equals("1234")) {
			return true;
		}
		return false;

	}

}
