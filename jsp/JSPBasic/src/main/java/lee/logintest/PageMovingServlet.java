package lee.logintest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PageMovingServlet")
public class PageMovingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PageMovingServlet() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		/* 페이지 이동방법 */
		/* 1)javascript의 location.href을 이용하는 방법 */
//		out.print("<script>");
//		out.print("location.href ='mainTest.jsp';");
//		out.print("</script>");

		/*2)response.sendRedirect()을 이용하는 방법*/
//		response.sendRedirect("mainTest.jsp");
		/* (redirect함) */

		/*3)RequestDispatcher객체를 이용하여 forwarding하는 방법*/
//		request.getRequestDispatcher("mainTest.jsp").forward(request, response);
		/* 이동은 되지만 주소줄은 그대로 남아있음 (차이점을 알아두기)*/
		
		/*4)meta태그*/
//		out.print("<html>");
//		out.print("<head>");
//		out.print("<meta http-equiv='refresh' content ='5; URL=mainTest.jsp'>");
//		out.print("</head>");
//		out.print("</html>");
//		
//		out.flush();
//		out.close();
//		
	}




}
