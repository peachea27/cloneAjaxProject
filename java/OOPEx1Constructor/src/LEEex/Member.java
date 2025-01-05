package LEEex;

public class Member {
	//memberId, memberPwd, memberName, memberAge
	
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int memberAge;
	
	//생성자

	public Member(String memberId, String memberPwd) {
		this.memberId=memberId;
		this.memberPwd=memberPwd;
	}
	
	//getter
	public String getId() {
		return this.memberId;
	}
	
	public String getPwd() {
		return this.memberPwd;
	}

	
	
	
}
