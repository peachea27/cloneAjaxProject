package com.lee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.lee.dto.FriendDTO;
import com.lee.dto.SearchNameDTO;
import com.lee.vo.Friend;

public class FriendsMgmDAOImpl implements FriendsMgmDAO{

	private static FriendsMgmDAOImpl instance = null;
	
	private FriendsMgmDAOImpl() {}
	
	public static FriendsMgmDAOImpl getInstance() {
		
		if (instance ==null) {
			instance = new FriendsMgmDAOImpl();
		}
		return instance;
		
	}
	
	@Override
	public List<Friend> selectAllFriends() throws ClassNotFoundException, SQLException {
		
		List<Friend> lst = new ArrayList<Friend>(); /* 꼭 list일 필요는 없다 */
		
		Connection con = DBConnection.getConnection();
		
		String query ="Select * from friends";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			lst.add(new Friend(rs.getInt("friendNo"),
						rs.getString("friendName"), 
						rs.getString("mobile"), 
						rs.getString("addr")));	
		}
		
		DBConnection.close(rs, pstmt, con);
		return lst;
	}

	@Override
	public int checkDuplicateMobile(String mobile) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		int result = 0;
		
		if(con != null) {
			String query ="select count(*) as cnt from friends where mobile =?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, mobile);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt("cnt"); /* 이방법도 있지만 or */
//				rs.getInt(1); /* 첫번째 것을 받아오기 */
			}
		DBConnection.close(rs, pstmt, con);
		}
		return result;
		
	}

	@Override
	public int getNextFriendNo() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		int result = 0;
		
		if(con != null) {
			String query = "select max(friendNo)from friends";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result =rs.getInt(1)+1;
			}
			DBConnection.close(rs, pstmt, con);
		}
		
		return result;
	}
	
	
	@Override
	public int insertFriend(int friendNo, FriendDTO friendDTO) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		int result =0;
		if(con != null) {
			String query ="insert into friends values(? ,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, friendNo);
			pstmt.setString(2,  friendDTO.getFriendName());
			pstmt.setString(2,  friendDTO.getMobile());
			pstmt.setString(2,  friendDTO.getAddr());
			
			result = pstmt.executeUpdate();
			DBConnection.close(pstmt, con);
		}
		return result;

	}

	@Override
	public List<Friend> selectFriendByName(SearchNameDTO dto) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		List<Friend> lst = new ArrayList<Friend>();
		
		if(con != null) {
			String query ="select * from friends where friendname =? ";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getFriendName());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				lst.add(new Friend(rs.getInt("friendNo"), 
						rs.getString("friendName"),
						rs.getString("mobile"), 
						rs.getString("addr")));
			}
			DBConnection.close(rs,pstmt,con);
		}
	return lst;	
	}

}

