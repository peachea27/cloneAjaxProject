package lee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mainTest_jstl_logout_Servlet")
public class mainTest_jstl_logout_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public mainTest_jstl_logout_Servlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그아웃 요청됨");
		HttpSession ses =request.getSession();
		
		ses.removeAttribute("loginMemberId");
		
		ses.invalidate();
		response.sendRedirect("mainTest_jstl.jsp?status=logoutSuccess");

	}

}
