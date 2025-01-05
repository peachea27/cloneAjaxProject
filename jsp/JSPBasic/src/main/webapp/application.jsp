<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - application</title>
</head>
<body>
<div> 웹 어플리케이션 컨텍스트 패스 <%=application.getContextPath() %></div>
<div>웹 어플리케이션의 실제 저장 경로<%=application.getRealPath("application.jsp") %></div>
<div><a href="applicationTest.jsp">applicationTest로 이동하기</a></div>

<hr />
<%!
	public String callApplicationObj() {
		ServletContext application = this.getServletContext();
		return application.getContextPath();
	}

	public String callApplicationObj(ServletContext app){
		return app.getRealPath("application.jsp");
	}
%>

<div>callApplicationObj() : <%=callApplicationObj() %></div>
<div>callApplicationObj(ServletContext app) : <%=callApplicationObj(application) %></div>
</body>
</html>