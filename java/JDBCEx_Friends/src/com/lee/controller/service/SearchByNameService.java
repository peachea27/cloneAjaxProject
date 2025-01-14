package com.lee.controller.service;

import java.sql.SQLException;
import java.util.List;

import com.lee.dao.FriendsMgmDAO;
import com.lee.dao.FriendsMgmDAOImpl;
import com.lee.dto.SearchNameDTO;
import com.lee.view.FriendDBInsert;
import com.lee.vo.Friend;

public class SearchByNameService implements FriendManagementService {

	@Override
	public void toDo() throws ClassNotFoundException, SQLException {
		FriendsMgmDAO dao = FriendsMgmDAOImpl.getInstance();
		
		SearchNameDTO dto = FriendDBInsert.getSearchByNameData();
		List<Friend> lst= dao.selectFriendByName(dto);
		
		for(Friend f : lst) {
			System.out.println(f.toString());
		}
	}

}
