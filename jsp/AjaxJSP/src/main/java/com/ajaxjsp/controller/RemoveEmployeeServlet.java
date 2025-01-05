package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.ajaxjsp.etc.OutputJSONForError;

@WebServlet("/removeEmp.do")
public class RemoveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RemoveEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		System.out.println("사원 삭제 요청 empNo : " + empNo);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		
		Date now = new Date(System.currentTimeMillis());
//		Date now2 = new Date(Calendar.getInstance().getTimeInMillis());
		
		try {
			int result = dao.deleteEmployee(empNo, now);
			
			if (result == 1) { // 삭제 ( quit_date 업데이트) 성공
				JSONObject json = new JSONObject();
				json.put("status",	"success");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
				String outputDate = sdf.format(Calendar.getInstance().getTime());
				json.put("outputDate", outputDate);
				out.print(json.toJSONString());
				
			} else { // 수정 실패
				JSONObject json = new JSONObject();
				json.put("status",	"fail");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
				String outputDate = sdf.format(Calendar.getInstance().getTime());
				json.put("outputDate", outputDate);
				out.print(json.toJSONString());
			}
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			OutputJSONForError.outputJson(e);
		} finally {
			out.flush();
			out.close();
		}
		
	}

}
