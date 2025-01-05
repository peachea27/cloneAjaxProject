package com.springbasic.persistence;

import java.util.List;

import com.springbasic.domain.MemberDTO;

public interface MemberDAO {
	//DB�κ��� ���� ��¥�ð��� ������ �޼���
	String getDateTime();
	
	//ȸ�� ����
	int insertMember(MemberDTO dto) throws Exception;
	//ȸ������ ����
	int updateMember(MemberDTO dto) throws Exception;
	//ȸ�� ����
	int deleteMember(String userId) throws Exception;
	
	//a��� ȸ�� ��ȸ
	List<MemberDTO>selectAllMembers() throws Exception;
	//���̵�� ȸ����ȸ
	MemberDTO selectMemberByUserId(String userId) throws Exception;
	//�α���
	MemberDTO loginMember(String userId, String userPwd) throws Exception;
	
	////
	int insertM(MemberDTO dto);
}
