package com.springbasic.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.service.ExTxService;
import com.springbasic.service.SaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ExTxTest {
	
	@Inject
	private ExTxService service;
	
	@Inject
	private SaveService saveService;
	
//	@Test
//	public void tranxTest() throws Exception {
//		service.saveData("abc");
//	}
	@Test
	public void testPropagation() {
		saveService.insertIntroTables();
	}
}
