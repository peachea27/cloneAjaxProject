package com.springbasic.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbasic.persistence.ExTxDAO;

@Service
public class ExTxServiceImpl implements ExTxService {

	@Inject
	private ExTxDAO dao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveData(String data) throws Exception {
		if(dao.insertDataTblA(data) == 1) {
			System.out.println("tableA에 저장 성공");
		}else {
			System.out.println("tableA에 저장 실패");
		}
		
		System.out.println("예외발생!!");
//		throw new RuntimeException();
		throw new Exception();
		
//		if(dao.insertDataTblB(data) == 1) {
//			System.out.println("tableB에 저장 성공");
//		}else {
//			System.out.println("tableB에 저장 실패");
//		}

	}

}
