package com.lee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lee.dto.FriendDTO;
import com.lee.dto.SearchNameDTO;
import com.lee.vo.Friend;

public interface FriendsMgmDAO {

	List<Friend> selectAllFriends() throws ClassNotFoundException, SQLException;

	int checkDuplicateMobile(String mobile) throws ClassNotFoundException, SQLException;

	int getNextFriendNo() throws ClassNotFoundException, SQLException;
	
	int insertFriend(int friendNo, FriendDTO friendDTO) throws ClassNotFoundException, SQLException;

	List<Friend> selectFriendByName(SearchNameDTO dto) throws ClassNotFoundException, SQLException;



	
	
}