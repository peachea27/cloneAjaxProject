package lee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EX1UserInfoPOST")
public class EX1UserInfoPOST extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EX1UserInfoPOST() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST방식으로 요청");
		
		request.setCharacterEncoding("utf-8");
		
		String userName =request.getParameter("userName");
		String userId =request.getParameter("userId");
		String userPwd =request.getParameter("userPwd");
		
		System.out.println(userName+", "+userId+", "+userPwd);
		
	}

}
