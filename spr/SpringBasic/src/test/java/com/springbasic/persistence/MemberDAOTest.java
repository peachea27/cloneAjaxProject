package com.springbasic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.domain.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void getDateTimeTest() {
		System.out.println(dao.getDateTime());
	}
	
	@Test
	public void insertMemberTest() throws Exception {
		MemberDTO member = new MemberDTO("user3", "1234", "user3@abc.com", "010-1111-3333", "F", null, null, null, "잘 되나요", null);
		if(dao.insertMember(member)==1){
			System.out.println("회원 저장 성공");
		}
	}
	@Test
	public void updateMemberTest() throws Exception{
		MemberDTO member = new MemberDTO("test", null, null, null, null, null, null, "uploadMember/noimage.png", null, null);
		if(dao.updateMember(member)==1) {
			System.out.println("회원수정성공");
		}
	}
	
	@Test
	public void deleteMemberTest()throws Exception{
		String userId="test";
		if(dao.deleteMember(userId)==1) {
			System.out.println("회원삭제성공");
		}
	}
	
	@Test
	public void selectAllMemberTest() throws Exception{
		List<MemberDTO>lst = dao.selectAllMembers();
		
		for(MemberDTO member : lst) {
			System.out.println(member.toString());
		}
	}
	
	@Test
	public void selectMemberByUserIdTest() throws Exception{
		System.out.println(dao.selectMemberByUserId("user3"));
	}
	
	@Test
	public void loginMemberTest() throws Exception{
//		System.out.println(dao.loginMember("user3","1234"));
		if(dao.loginMember("user3","1234")!=null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
	
	////////////////////////
	@Test
	public void insertMTest() {
		MemberDTO dto = new MemberDTO("user2", "1234", "123@sweat", "010-1111-2222", "M", "work", "work", null, null, null);
		if(dao.insertM(dto)==1) {
			System.out.println("user2입력!");
		}
	}
}
