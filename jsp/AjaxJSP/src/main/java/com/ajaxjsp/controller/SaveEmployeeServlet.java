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

@WebServlet("/saveEmp.do")
public class SaveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SaveEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사원저장 서블릿 호출");

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 파라미터 읽어오기
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
		EmployeeDTO empDto = new EmployeeDTO(0, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId);
		System.out.println(empDto.toString());
		
		// employee_id (pk)
		// 1) max(employee_id) + 1 값을 얻어온다.
		// 2) 1)번에서 얻은 값을 다음 저장될 사원의 employee_id 에 대입하여 insert문을 실행한다.
		
		// 저장 프로시저 사용
		
		EmployeesDAO dao = EmployeesDAOImpl.getInstance();
		
		try {
			
			String result = dao.insertEmp(empDto);
			
			// json으로 응답
			if (result.equals("SUCCESS")) { // 저장 성공
				JSONObject json = new JSONObject();
				json.put("status",	"SUCCESS");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
				String outputDate = sdf.format(Calendar.getInstance().getTime());
				json.put("outputDate", outputDate);
				out.print(json.toJSONString());
				
			} else if (result.equals("ERROR")){ // 저장 실패
				JSONObject json = new JSONObject();
				json.put("status",	"ERROR");
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
