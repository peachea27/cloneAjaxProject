package com.lee.controller.service;

import java.sql.SQLException;

import com.lee.dao.FriendsMgmDAO;
import com.lee.dao.FriendsMgmDAOImpl;

public class DuplicateMobileService {

	private static DuplicateMobileService instance = null;
	
	private DuplicateMobileService() {}
	
	public static DuplicateMobileService getInstance() {
		if(instance == null) {
			instance = new DuplicateMobileService();
		}
		return instance;
	}
	
	public boolean duplicateMobileService(String mobile) throws ClassNotFoundException, SQLException {
		boolean result = false;
		
		FriendsMgmDAO dao = FriendsMgmDAOImpl.getInstance();
		
		if(dao.checkDuplicateMobile(mobile)==1) {
			result =true;
		}
		
		return result;
	}
	
}