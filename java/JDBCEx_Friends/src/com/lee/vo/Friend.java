package com.lee.vo;

public class Friend {
	/* 멤버 변수 */
	private int friendNo;
	private String friendName;
	private String mobile;
	private String addr;
	
	/**생성자
	 * @param friendNo
	 * @param friendName
	 * @param mobile
	 * @param addr
	 */
	public Friend(int friendsNo, String friendName, String mobile, String addr) {
		super();
		this.friendNo = friendsNo;
		this.friendName = friendName;
		this.mobile = mobile;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Friend [friendNo=" + friendNo + ", friendName=" + friendName + ", mobile=" + mobile + ", addr=" + addr
				+ "]";
	}
	
	

	
	
}
