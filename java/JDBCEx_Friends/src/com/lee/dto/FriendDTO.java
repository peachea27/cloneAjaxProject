package com.lee.dto;

public class FriendDTO {

	private int friendNo;
	private String friendName;
	private String mobile;
	private String addr;

	public FriendDTO( String friendName, String mobile, String addr) {
		super();
		this.friendName = friendName;
		this.mobile = mobile;
		this.addr = addr;
	}



	public int getFriendNo() {
		return friendNo;
	}

	public String getFriendName() {
		return friendName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddr() {
		return addr;
	}
	
	@Override
	public String toString() {
		return "FriendDTO [friendNo=" + friendNo + ", friendName=" + friendName + ", mobile=" + mobile + ", addr="
				+ addr + "]";
	}
}
