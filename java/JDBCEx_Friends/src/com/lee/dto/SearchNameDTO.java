package com.lee.dto;

public class SearchNameDTO {

	private String friendName;
	public String getFriendName() {
		return friendName;
	}
	/**
	 * @param friendname 
	 * 
	 */
	public SearchNameDTO(String friendName) {
		super();
		this.friendName=friendName;
	}
	@Override
	public String toString() {
		return "SearchNameDTO [friendName=" + friendName + "]";
	}

}
