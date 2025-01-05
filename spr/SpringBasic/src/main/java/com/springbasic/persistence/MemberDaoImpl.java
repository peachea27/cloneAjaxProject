package com.springbasic.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbasic.domain.MemberDTO;

@Repository //아래의 클래스가  DAO객체임을 명시
public class MemberDaoImpl implements MemberDAO {
	
	private static String ns ="com.springbasic.mappers.memberMapper.";
	
	@Inject
	private SqlSession ses; // sqlSessionTemplate객체 주입

	@Override
	public String getDateTime() {
		
		String result = ses.selectOne(ns+"getDateTime");
		return result;
	}

	@Override
	public int insertMember(MemberDTO dto) throws Exception {
		
		int result = ses.insert(ns + "insertMember", dto);
		return result;
	}

	@Override
	public int updateMember(MemberDTO dto) throws Exception {
		
		return ses.update(ns+"updateMember", dto);
	}

	@Override
	public List<MemberDTO> selectAllMembers() throws Exception {
		
		return ses.selectList(ns+"viewAllMember");
	}

	@Override
	public int deleteMember(String userId) throws Exception {
		
		return ses.delete(ns+"deleteMember",userId);
	}

	@Override
	public MemberDTO selectMemberByUserId(String userId) throws Exception {
		
		return ses.selectOne(ns+"viewMemberByUserId");
	}

	@Override
	public MemberDTO loginMember(String userId, String userPwd) throws Exception {
		
		//여러개의 파라미터 값을 Map으로 감싸서 넘길 수 있다.
		Map<String, String>param = new HashMap<String, String>();
		param.put("us erId", userId);
		param.put("userPwd", userPwd);
		
		return ses.selectOne(ns+"loginMember",param);
	}

	@Override
	public int insertM(MemberDTO dto) {
		int result =ses.insert(ns + "insertM", dto);
		return result;
	}


	
	
	

}
