package ksy.hashmap.memberboard;

public class Member {
	private String id;
	private String nickname;
	
	Member(String id,String nickname){
		this.id=id;
		this.nickname=nickname;
	}

	public String getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", nickname=" + nickname + "]";
	}
}
