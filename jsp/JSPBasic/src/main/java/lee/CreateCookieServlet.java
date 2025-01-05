package lee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCookieServlet
 */
@WebServlet("/createCook.do")
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateCookieServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie c = new Cookie("myCook", "ksy");
		
		c.setMaxAge(24 * 60 * 60); /* 하루동안 쿠키 저장 */
		c.setPath("/");
		response.addCookie(c); /* 만들어진 쿠키 객체를 response객체에 담아서 저장 */
		
		Cookie sesId = new Cookie("mySession",request.getSession().getId());
		sesId.setMaxAge(7*24*60*60);
		response.addCookie(sesId);
	}

}
