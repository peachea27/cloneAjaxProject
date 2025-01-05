package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.ajaxjsp.etc.OutputJSONForError;
import com.ajaxjsp.etc.ResponseToJson;
import com.ajaxjsp.vodto.EmployeeVO;

@WebServlet("/getAllEmp.do")
public class GetAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetAllEmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchName = request.getParameter("searchName");
		String orderMethod = request.getParameter("orderMethod");
		
		System.out.println("검색 정렬 서블릿 호출 - " + searchName + ", " + orderMethod);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 검색어가 없으면 searchName : null
		
		EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		
		try {
			List<EmployeeVO> lst = dao.selectAllEmpSearchOrder(searchName, orderMethod);
			// json응답
			ResponseToJson rtj = new ResponseToJson();
			String json = rtj.makeJsonWithJsonSimple(lst);
			out.print(json);

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			out.print(OutputJSONForError.outputJson(e));
		} finally {
			out.flush();
			out.close();
		}
					
		
		
	}


}
