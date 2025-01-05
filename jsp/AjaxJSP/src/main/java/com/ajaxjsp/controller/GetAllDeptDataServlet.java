package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.ajaxjsp.etc.OutputJSONForError;
import com.ajaxjsp.vodto.DepartmentsVO;


@WebServlet("/getAllDept.do")
public class GetAllDeptDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllDeptDataServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dept 서블릿 호출");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		
		try {
			List<DepartmentsVO> lst = dao.selectAllDept();
			
			JSONObject json = new JSONObject();
			json.put("status", "success");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			String outputDate = sdf.format(Calendar.getInstance().getTime());
			
			json.put("outputDate", outputDate);
			json.put("count", lst.size());
			
			JSONArray depts = new JSONArray();
			
			if (lst.size() > 0) {
				for (DepartmentsVO d : lst) {
					JSONObject dept = new JSONObject();
					dept.put("DEPARTMENT_ID", d.getDepartment_id());
					dept.put("DEPARTMENT_NAME", d.getDepartment_name());
					dept.put("MANAGER_ID", d.getManager_id());
					dept.put("LOCATION_ID", d.getLocation_id());
					
					depts.add(dept);
				}
				json.put("DEPTS", depts);
			}
			 out.print(json.toJSONString());
			
		} catch (NamingException | SQLException e) {
			out.print(OutputJSONForError.outputJson(e));
			
		} finally {
			out.close();
		}
		
	}

}
