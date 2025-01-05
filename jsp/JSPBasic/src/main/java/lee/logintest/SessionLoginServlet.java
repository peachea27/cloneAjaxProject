package lee.logintest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SessionLoginServlet() {
        super();
   
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd =request.getParameter("userPwd");

		
		if(userId.equals("abcd") && userPwd.equals("1234")) {
			/* 로그인 성공 -세션 객체에 로그인 정보를 남긴다.*/
			HttpSession ses = request.getSession(); /* 세션 객체를 얻어옴 */
			
			System.out.println("세션 id: "+ses.getId());
			
			ses.setAttribute("loginMemberId", userId); /* 로그인한 멤버의 아이디를 바인딩 */
			ses.setAttribute("loginMemberPwd", userPwd); /* 로그인한 멤버의 아이디를 바인딩 */
			
			ses.setAttribute("dooly", "아 배고파");
			response.sendRedirect("mainTest.jsp?status=loginSuccess"); /* 쿠키는 그대로 */
			

			
		}
		
	}

}
