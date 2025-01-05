package lee.logintest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RememberIdServlet")
public class RememberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RememberIdServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userId = request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		String rememberId =request.getParameter("rememberId"); //"Y" or null
		
//		if(userId.equals("abcd") && userPwd.equals("1234")) //이렇게 하면 null이 생기는데 null은 equals소환 못함
		if("abcd".equals(userId) && "1234".equals(userPwd)){
			/*로그인 성공*/
			/* null이면 else로 넘어가니까 else로 가지 말라고 확실하게 not null */
//			if ("Y".equals(rememberId)) {
				if(rememberId != null && rememberId.equals(rememberId)) {
				/*아이디를 저장*/
				/*쿠키생성*/
				Cookie cookie = new Cookie("remember", userId);
				cookie.setPath("/");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}else {
				/* 아이디 저장하지 않음 */
				/* 쿠키 삭제 */
				Cookie cookie = new Cookie("remember", userId); /* 값은 상관없음 */
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				
			}
			
			response.sendRedirect("rememberId.jsp");
		}
		
//		{
//			HttpSession se = request.getSession();
//			se.setAttribute("sessionId", id);
//			se.setAttribute("sessionpwd", pwd);
//			
//			if(remember.equals("Y")) {
//				Cookie mycook = new Cookie("theCookie", "cookieContents");
//				mycook.setMaxAge(24*60*60);
//				response.addCookie(mycook);
//			}
//			
//			response.sendRedirect("rememberId.jsp?status=loginSuccess");
//		}
//		
	
		
		
		//		Cookie[] mycookies = request.getCookies();
//		for(Cookie c : mycookies) {
//			if(c.getName().equals("theCookie")) {
//				
//			}
//		}
	}

}
