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
import com.ajaxjsp.vodto.EmployeeDTO;

@WebServlet("/modifyEmp.do")
public class ModifyEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyEmployeeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사원 정보 수정 POST요청 empNo : " + request.getParameter("employeeId"));
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 파라미터 읽어오기
		int empNo = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
//		email = "SKING";
		String phoneNumber = request.getParameter("phoneNumber");
		
		String strHireDate = request.getParameter("hireDate");
		// strHireDate = "2024/08/21"; // IllegalArgumentException 예외 발생
		// Date 타입으로 변환 (yyyy-[m]m-[d]d 포맷을 지켜야 한다)
		Date hireDate = Date.valueOf(strHireDate);
		
		String jobId = request.getParameter("jobId");
		float salary = Float.parseFloat(request.getParameter("salary"));
		float commissionPct = Float.parseFloat(request.getParameter("comm"));
		int managerId = Integer.parseInt(request.getParameter("managerId"));
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		
		// 저장할 데이터를 DTO객체로 만들어서 DAO로 전송
		EmployeeDTO empDto = new EmployeeDTO(empNo, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId);
		System.out.println(empDto.toString());
		
		EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		
		try {
			int result = dao.updateEmployee(empDto);
			
			if (result == 1) { // 사원정보 수정 성공
				JSONObject json = new JSONObject();
				json.put("status",	"success-modify");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
				String outputDate = sdf.format(Calendar.getInstance().getTime());
				json.put("outputDate", outputDate);
				out.print(json.toJSONString());
				
			} else { // 수정 실패
				JSONObject json = new JSONObject();
				json.put("status",	"fail-modify");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
				String outputDate = sdf.format(Calendar.getInstance().getTime());
				json.put("outputDate", outputDate);
				out.print(json.toJSONString());
			}
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			out.print(OutputJSONForError.outputJson(e));
		} finally {
			out.flush();
			out.close();
		}
	}
}
