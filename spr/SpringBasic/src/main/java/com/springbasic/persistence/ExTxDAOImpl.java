package com.springbasic.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ExTxDAOImpl implements ExTxDAO {

	@Inject
	SqlSession ses;
	
	String namespace ="com.springbasic.mappers.tableAMapper.insertData";
	@Override
	public int insertDataTblA(String data) {
		
		return ses.insert(namespace, data);
	}

	@Override
	public int insertDataTblB(String data) {
		return ses.insert("com.springbasic.mappers.tableBMapper.insertData",data);
	}

}
