package lee.logintest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SendRedirectServlet")
public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SendRedirectServlet() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST방식 요청");
		
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		if(userId.equals("abcd")&& userPwd.equals("1234")) {
			/* 로그인 성공 */
			
//			out.print("<script>alert('로그인 성공')</script>");
			response.sendRedirect("mainTest.jsp?status=loginSuccess");
			
		} else {
			/* 로그인 실패 */
			response.sendRedirect("mainTest.jsp?status=loginFail");
		}
	}

	
}
