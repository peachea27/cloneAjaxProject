package ksy.hashmap.memberboard;

public class Board {
// 글번호, 제목, 내용, 글쓴이
	private int boardId;
	private String title;
	private String content;
	private String userId;

	/**
	 * @param boardId
	 * @param title
	 * @param content
	 * @param userId
	 */
	
	
	  public Board(int boardId, String title, String content, String userId) {
	  super(); this.boardId = boardId; this.title = title; this.content = content;
	  this.userId = userId; }
	 
	 
	 
	public int getBoardId() {
		return boardId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getUserId() {
		return userId;
	}

}
