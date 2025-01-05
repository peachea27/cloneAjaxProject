package ksy.hashmap.memberboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberBoardMain {

	public static void main(String[] args) {
		//회원가입
		Member mem1 = new Member("user1", "닉네임1");
		Member mem2 = new Member("user2", "닉네임2");
		Member mem3 = new Member("user3", "닉네임3");
		
		MemberCRD memCrd = new MemberCRD();
		memCrd.insert(mem1);
		memCrd.insert(mem2);
		memCrd.insert(mem3);
		
		//회원 검색
		Member searchMem1= memCrd.selectByUserId(mem1.getId());
		System.out.println(searchMem1);
		
		Member searchMem2= memCrd.selectByNickName(mem2.getNickname());
		System.out.println(searchMem2);
		
		memCrd.deleteMember("user3");//회원삭제
		System.out.println("탈퇴여부 확인 : "+memCrd.selectByUserId("user3"));//null: 잘 지워졌음

		//^^map에도 담을 수 있다. 아래는 예시
		List<Member>members = new ArrayList<Member>();
		members.add(mem1);
		members.add(mem2);
		//~//
		
		/*
		 * // 회원이 게시글을 몇개 작성한다.
		 */		 List<Board> boards = new ArrayList<Board>(); 
		
		  boards.add(new Board(1, "제목1", "내용1", "user1")); boards.add(new Board(2,
		  "제목2", "내용2", "user2")); boards.add(new Board(3, "제목3", "내용3", "user1"));
		  boards.add(new Board(4, "제목4", "내용4", "user2")); //
		 		//^^예시 계속
		Map<String, Board>bMap= new HashMap<String, Board>();
		bMap.put("1", new Board(1, "제목1", "내용1", "user1"));
		bMap.put("2", new Board(2, "제목2", "내용2", "user2"));
		
//		Map<String, List>memboard = new HashMap<String, List>(); //리스트대신 해시맵 등 넣어도됨
		Map<String, Map>memboard = new HashMap<String, Map>();
//		memboard.put("member", members);
//		memboard.put("board", boards);
		memboard.put("member", memCrd.getMemberMap());
		memboard.put("board", bMap);
		
		HashMap<String, Member> newMemMap =(HashMap)memboard.get("member");
		//~//
		
//		출력: 게시판 (글번호, 제목, 글쓴이, 내용)
		for(Board board : boards) {
			System.out.println("글번호: "+ board.getBoardId());
			System.out.println("제목: "+board.getTitle());
			System.out.println("글쓴이: "+memCrd.getMemberMap().get(board.getUserId()).getNickname());
			System.out.println("글번호: "+board.getBoardId());
		}
	}

}
