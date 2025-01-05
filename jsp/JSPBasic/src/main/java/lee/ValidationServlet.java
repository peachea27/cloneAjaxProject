package lee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/*url매핑 주소에/를 안쓰면 서블릿 매핑에서 유효하지 않은<url-pattern>서블릿이 실행되지 않음*/
@WebServlet("/ValidationServlet")

public class ValidationServlet extends HttpServlet{

	public ValidationServlet() {
		super();
	}

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET방식 호출");
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		
		/* 한글이 안깨지게 하는 법 */
		resp.setContentType("text/html; charset=utf-8");
//		PrintWriter out = resp.getWriter();
		
//		if(kor < 0 || kor >100) {
//			out.print("<script>");
//			out.print("alert('국어점수가 잘못 입력되었습니다!');");
//			out.print("location.href='validation.jsp';");
//			out.print("</script>");
//		}
//		
		int tot = kor + eng +math;
		float avg = tot/3f;
		
		System.out.println("총점 :"+tot+",평균"+avg);
//		 out.write("<!DOCTYPE html>\r\n");
//	      out.write("<html>\r\n");
//	      out.write("<head>\r\n");
//	      out.write("<meta charset=\"UTF-8\">\r\n");
//	      out.write("<title>성적표</title>\r\n");
//	      out.write("</head>\r\n");
//	      out.write("<body>\r\n");
//	      out.write("<div> 국어:"+kor+"</div>");
//	      out.write("<div> 영어:"+eng+"</div>");
//	      out.write("<div> 수학:"+math+"</div>");
//	      out.write("<div> 총점:"+tot+"</div>");
//	      out.write("</body>\r\n");
//	      out.write("</html>\r\n");
		
		/* 출력방법(2) */
		/* 출력할 변수를 바인딩(짐싸기) */
		req.setAttribute("kor", kor);
		req.setAttribute("eng", eng);
		req.setAttribute("math", math);
		req.setAttribute("tot", tot);
		req.setAttribute("avg", avg);
		/*전송- 짐 보내기*/
		RequestDispatcher rd = req.getRequestDispatcher("./outputScore.jsp");
		rd.forward(req, resp);
		
	}

	
	
}
