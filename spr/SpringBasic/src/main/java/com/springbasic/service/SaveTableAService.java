package com.springbasic.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springbasic.persistence.ExTxDAO;

@Service
public class SaveTableAService {
	@Inject
	private ExTxDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertTableA() {
		dao.insertDataTblA("aaaaa");
	}
}