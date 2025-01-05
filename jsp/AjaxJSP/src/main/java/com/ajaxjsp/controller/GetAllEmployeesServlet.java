package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ajaxjsp.vodto.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/getAllEmployees.do")
public class GetAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllEmployeesServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 호출됨");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
	    EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		 
		 try {
			List<EmployeeVO> lst = dao.selectAllEmp();
			
//			for (EmployeeVO e : lst) {
//				System.out.prin  tln(e.toString());
//			}
			
			// json으로 변환해서 응답
			// 1) json-simple 이용
//			String jsonString = toJs onWithJsonSimple(lst);
//			out.print(jsonString);
			
			// 2) gson 이용
//			String jsonString = toJsonWithGson(lst);
//			System.out.println(jsonString);
			
			String jsonString = toJsonWithGsonMap(lst);
			out.print(jsonString);
			
		} catch (NamingException | SQLException e) {
//			e.printStackTrace();
			out.print(OutputJSONForError.outputJson(e));
			
		} finally {
			out.close();
		}
	}


	private String toJsonWithGson(List<EmployeeVO> lst) {
		Gson gson = new Gson();
//		 gson.toJson(lst);
		return gson.toJson(lst);
	}

	private String toJsonWithGsonMap(List<EmployeeVO> lst) {
		Map map = new HashMap();
		map.put("status", "success");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String outputDate = sdf.format(Calendar.getInstance().getTime());
		map.put("outputDate", outputDate);
		
		map.put("count", lst.size());
		map.put("employees", lst);
		
//		Gson gson = new Gson();
//		return gson.toJson(map);
		
		Gson gsondate = new GsonBuilder().setDateFormat("yy-MM-dd").create();
		return gsondate.toJson(map);
	}

	private String toJsonWithJsonSimple(List<EmployeeVO> lst) {
		JSONObject json = new JSONObject();
		
		json.put("status", "success");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String outputDate = sdf.format(Calendar.getInstance().getTime());
		
		json.put("outputDate", outputDate);
		json.put("count", lst.size());
		
		if (lst.size() > 0) {
			JSONArray employees = new JSONArray();
			
			for (EmployeeVO e : lst) {
				JSONObject employee = new JSONObject();
				employee.put("EMPLOYEE_ID", e.getEmployee_id());
				employee.put("FIRST_NAME", e.getFirst_name());
				employee.put("LAST_NAME", e.getLast_name());
				employee.put("EMAIL", e.getEmail());
				employee.put("PHONE_NUMBER", e.getPhone_number());
				
				Date tmpDate = e.getHire_date();
				SimpleDateFormat sdfHireDate = new SimpleDateFormat("yyyy-MM-dd");
				
				employee.put("HIRE_DATE", sdfHireDate.format(tmpDate));
				employee.put("JOB_ID", e.getJob_id());
				employee.put("SALARY", e.getSalary());
				employee.put("COMMISSION_PCT", e.getCommission_pct());
				employee.put("MANAGER_ID", e.getManager_id());
				employee.put("DEPARTMENT_NAME", e.getDepartment_name());
				
				employees.add(employee);
			}
			json.put("employees", employees);
		}
		
		return json.toJSONString();
	}

	

}
