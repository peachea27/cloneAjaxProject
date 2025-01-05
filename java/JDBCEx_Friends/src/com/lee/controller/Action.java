package com.lee.controller;

import com.lee.controller.service.FriendManagementService;
import com.lee.controller.service.OutputEntireFriendService;
import com.lee.controller.service.SaveFriendService;
import com.lee.controller.service.SearchByNameService;

public class Action {

	/* 싱글톤 */
	private static Action instance = null;
	
	private Action() {} // private 기본생성
	
	public static Action getInstance() {
		if(instance == null) {
			instance = new Action();
		}
		return instance;
	}
	
	public FriendManagementService getService(int menu) {
		
		FriendManagementService result = null;
		
		switch (menu) {
		case 1:
			result =new OutputEntireFriendService();
			break;
		case 2:
			result = new SaveFriendService();
			break;
		case 3:
			result = new SearchByNameService();
			break;
		case 9:
			System.exit(0); /* 사실 정리안된 상태에서 종료는 좋은 방법은 아님, 불리안을 false하든가 하는 방법이 낫다 */
		}
		return result;
	}
}
