<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>page3</h1>

<%
	
	/* 각 내장객체 영역에 바인딩된 정보 확인 */
	out.print("pageContext: "+pageContext.getAttribute("name")+"<br/>");
	out.print("request: "+request.getAttribute("name")+"<br/>");
	out.print("session : "+session.getAttribute("name")+"<br/>");
	out.print("application : "+application.getAttribute("name")+"<br/>");
	
// 	request.getRequestDispatcher("scope_page1.jsp").forward(request, response);/* stackoverflow */
%>
</body>
</html>