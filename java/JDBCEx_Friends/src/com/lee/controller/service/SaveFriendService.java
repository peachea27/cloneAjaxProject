package com.lee.controller.service;

import java.sql.SQLException;

import com.lee.dao.FriendsMgmDAO;
import com.lee.dao.FriendsMgmDAOImpl;
import com.lee.dto.FriendDTO;
import com.lee.view.FriendDBInsert;

public class SaveFriendService implements FriendManagementService{

	@Override
	public void toDo() {
		System.out.println("친구 저장하러 가자");
		
		
		FriendsMgmDAO dao = FriendsMgmDAOImpl.getInstance();
		
		
		/* 친구 정보 */
		FriendDTO frienddto= FriendDBInsert.getFriendData();

		/* friendNo값 */
		try {
			int friendNo = dao.getNextFriendNo();
		if(	dao.insertFriend(friendNo, frienddto)==1) {
			
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
