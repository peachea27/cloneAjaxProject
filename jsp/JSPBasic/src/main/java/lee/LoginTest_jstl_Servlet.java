package lee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jstl/LoginTest_jstl_Servlet")
public class LoginTest_jstl_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginTest_jstl_Servlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post 호출");
		
		String id= request.getParameter("userId");
		String pwd=request.getParameter("userPwd");
		
		if ("abcd".equals(id) && "1234".equals(pwd)) {
			HttpSession ses= request.getSession();
			ses.setAttribute("loginMemberId",id);
			
			response.sendRedirect("../mainTest_jstl.jsp?status=loginSuccess");
		}
	}

}
