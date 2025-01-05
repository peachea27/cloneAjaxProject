<%@page import="lee.dto.ProductDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 영역</title>
</head>
<body>
	<h1>application영역</h1>
	
	<%
		Map<String,ProductDTO> maps = new HashMap<>();
				maps.put("galaxy", new ProductDTO("갤럭시",1,1000,"블루"));
				maps.put("iphone", new ProductDTO("아이폰",1,2000,"블랙"));
				
				/* application객체에 바인딩(바람직하지 않음, 서버는 항상 켜져있으므로 계속 바인딩되어있음, 저장되는게 너무 많아짐) */
				application.setAttribute("phones", maps);
		%>
	
	<div><a href = "appPage.jsp">appPage.jsp로 이동하기</a></div>
</body>
</html>