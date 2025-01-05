package lee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/readCook.do")
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ReadCookieServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Cookie[] cooks= request.getCookies();
		
		/* myCook이라는 쿠키의 값만 출력 */
		for(Cookie c : cooks) {
			if(c.getName().equals("myCook")) {
				out.print(c.getName()+" : "+c.getValue());
			}
		}
		
//		for(Cookie c : cooks) {
//			out.print(c.getName()+" : "+c.getValue());
//		}
		
		/* myCook 쿠키 삭제하기 */
		for(Cookie c: cooks ) {
			if(c.getName().equals("myCook")) {
				c.setMaxAge(0);//쿠키 만료일을 0으로 설정 -> 쿠키 삭제
				c.setPath("/");
				response.addCookie(c);
				
				
			}
		}
		
	}

}
