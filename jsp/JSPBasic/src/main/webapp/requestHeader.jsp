<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - request</title>
</head>
<body>
	<%
		Enumeration headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
		 	String headerName =(String)headers.nextElement();
		 	String headerValue = request.getHeader(headerName);
		 	out.print("헤더명 :" + headerName+ ":" + headerValue+"<br />");
		}
	%>
</body>
</html>