package lee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServeltGet
 */
@WebServlet("/hPOST") /* 매핑주소 */
public class HelloServletPOST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServletPOST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("GET방식 호출됨");
		
		String name = request.getParameter("name");
		System.out.println("이름 : " + name); /* 한글이 깨져서 출력 */
		
		/* 출력 */
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset =utf-8"); 
		/* 응답할 문서의 종류와 인코딩 방식을 설정 (out객체를 얻어 오기 전에 설정해야 한다) */
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Get방식 출력 응답</title>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<h1>"+name+"</h1>");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("POST방식 호출됨");
		
		request.setCharacterEncoding("utf-8"); /* request객체 인코딩 설정 */
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		
		
		System.out.println("name: "+name+", age: "+age);
		
		response.setContentType("text/html; charset =utf-8"); 
		PrintWriter out = response.getWriter();
		/* 응답할 문서의 종류와 인코딩 방식을 설정 (out객체를 얻어 오기 전에 설정해야 한다) */
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Post방식 출력 응답</title>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div>이름: "+name+"</div>");
	      out.write("<div>나이: "+age+"</div>");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}

}
