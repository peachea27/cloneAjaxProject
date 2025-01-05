package com.lee.controller.service;

import java.sql.SQLException;
import java.util.List;

import com.lee.dao.FriendsMgmDAOImpl;
import com.lee.vo.Friend;

public class OutputEntireFriendService implements FriendManagementService{

	
	@Override
	public void toDo() throws ClassNotFoundException, SQLException {
		System.out.println("전체 친구 조회하러 가기");
		FriendsMgmDAOImpl fmd = FriendsMgmDAOImpl.getInstance();
		
		List<Friend>lst = fmd.selectAllFriends();
		
		for(Friend f : lst) {
			System.out.println(f.toString());
		}
	}
	
}

