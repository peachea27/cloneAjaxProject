package com.lee.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.lee.controller.service.DuplicateMobileService;
import com.lee.dto.FriendDTO;
import com.lee.dto.SearchNameDTO;

public class FriendDBInsert {
	
	public static FriendDTO getFriendData() {
		FriendDTO friend = null;
		Scanner sc = new Scanner(System.in);
		String name="";
		
		do {/* 이름은 not null이어야 하므로 입력 필수 */
		System.out.print("친구 이름 입력>>>");
		name = sc.nextLine();
		}while(name.equals(""));
		
		String mobile =""; 
		boolean result = false;
		
		do {
		System.out.print("친구 전화번호 입력>>>");
		mobile= sc.nextLine(); //010-111-2222
		/*유니크 조건 때문에 중복체크해야 한다. */
		
		try {
			result =DuplicateMobileService.getInstance().duplicateMobileService(mobile);
			System.out.println(result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}while(result);	
		System.out.print("친구 주소 입력>>>");
		String addr = sc.nextLine();
		
		friend = new FriendDTO(name,mobile,addr);
		System.out.println("friend dto: "+ friend.toString());
		
		return friend;
	}

	public static SearchNameDTO getSearchByNameData() {
		Scanner sc = new Scanner(System.in);
		String name="";
		
		do {
		System.out.println("조회할 친구 이름>>>");
		name = sc.nextLine();
		}while(name.equals(""));
		
		return new SearchNameDTO(name);
		
	}
}
