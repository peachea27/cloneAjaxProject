package lee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lee.dto.MemberDTO;

@WebServlet("/ELScopeTestServlet")
public class ELScopeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ELScopeTestServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 =5, num2 =3;
		int result = num1+num2;
		
		MemberDTO member = new MemberDTO("gildong", "1234", "gildong@abc.com");
		
		request.setAttribute("member", member);
		
		HttpSession ses= request.getSession();
		ses.setAttribute("result", result);
		
		request.getRequestDispatcher("jstl/elScope.jsp").forward(request, response);
	}



}
