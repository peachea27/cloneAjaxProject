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

@WebServlet("/orderByEmp.do")
public class OrderEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderMethod = request.getParameter("orderMethod");
		System.out.println("정렬 방식 : " + orderMethod);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		
		try {
			List<EmployeeVO> lst  = dao.orderEmp(orderMethod);
			
			// json으로 응답 
			ResponseToJson rtj = new ResponseToJson();
			out.print(rtj.makeJsonWithJsonSimple(lst));
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			OutputJSONForError.outputJson(e);
		} finally {
			out.flush();
			out.close();
		}
	}
}
