package ksy.hashmap.memberboard;

import java.util.HashMap;
import java.util.Map;

public class MemberCRD { 
	//member들을 map에 넣어서 관리
	//회원저장, 회원검색, 회원 삭제하는 기능
	private Map<String, Member>memberMap = new HashMap<String, Member>();

	//회원 저장, 회원검색, 회원 삭제하는 기능
	public void insert(Member member) {
		memberMap.put(member.getId(), member);
	}

	public Map<String, Member> getMemberMap() {
		return memberMap; 
	}
	
	public Member selectByUserId(String userId) {
		return memberMap.get(userId);
		//id는 String이지만 get해오는건 Member, member반환
	}

	public Member selectByNickName(String name) {
		for(Member member : memberMap.values()) {
			if(member.getNickname().equals(name)) {
				return member;
			}
		}
		return null;
	}
	
	public void deleteMember(String userId) {
		memberMap.remove(userId);
	}


}
