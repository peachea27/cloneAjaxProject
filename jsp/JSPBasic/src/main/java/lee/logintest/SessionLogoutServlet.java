package lee.logintest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLogoutServlet")
public class SessionLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SessionLogoutServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 로그아웃 처리 : session객체에 남아있는 로그인 정보를 지우고 무효화*/
		HttpSession ses = request.getSession();
		
		ses.removeAttribute("loginMemberId"); /* 로그인 정보 삭제 */
		ses.removeAttribute("loginMemberPwd"); /* 로그인 정보 삭제 */
		
		ses.invalidate(); /* 세션 무효화 -> 세션 갱신*/
		
		System.out.println("세션 id (무효화 직후)"+ses.getId());
		
		response.sendRedirect("mainTest.jsp?status=logoutSuccess");
	}

}
