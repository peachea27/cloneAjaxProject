package com.ajaxjsp.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.ajaxjsp.vodto.DepartmentsVO;
import com.ajaxjsp.vodto.EmployeeDTO;
import com.ajaxjsp.vodto.EmployeeVO;
import com.ajaxjsp.vodto.JobsVO;

public interface EmployeesDAO {
	// 모든 직원 정보를 얻어오는 메서드
	List<EmployeeVO> selectAllEmp() throws NamingException, SQLException;
	
	// 모든 jobs 정보를 얻어오는 메서드
	List<JobsVO> selectAllJobs() throws NamingException, SQLException;

	// 모든 부서 정보는 얻어오는 메서드
	List<DepartmentsVO> selectAllDept() throws NamingException, SQLException;
	
	// 사원 저장 (저장프로시저이용)
	String insertEmp(EmployeeDTO emp) throws NamingException, SQLException;

	// 사번으로 사원정보 조회
	EmployeeVO selectEmployeeByEmpNo(int empNo) throws NamingException, SQLException;

	// 사원 정보 수정
	int updateEmployee(EmployeeDTO emp) throws NamingException, SQLException;

	// 사원삭제 (quit_date를 수정)
	int deleteEmployee(int empNo, Date now) throws NamingException, SQLException;

	// 이름으로 검색
	List<EmployeeVO> selectByEmpName(String searchName) throws NamingException, SQLException;

	// 전체 사원 정렬
	List<EmployeeVO> orderEmp(String orderMethod) throws NamingException, SQLException;

	// 검색 + 정렬
	List<EmployeeVO> selectAllEmpSearchOrder(String searchName, String orderMethod) throws NamingException, SQLException;
	
}
