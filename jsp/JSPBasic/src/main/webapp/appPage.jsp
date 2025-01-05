<%@page import="java.util.Set"%>
<%@page import="lee.dto.ProductDTO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application영역</title>
</head>
<body>
	<h1>application영역에서 바인딩한 객체 읽어오기</h1>
	
	<%
		Map<String,ProductDTO> phoneMap = (Map<String,ProductDTO>)application.getAttribute("phones");
		Set<String>keys = phoneMap.keySet();
		for (String key : keys){
			ProductDTO product = phoneMap.get(key);
			out.print("상품이름:"+product.getProdName()+"색상"+product.getColor()+"<br />");
		}
	
	%>
</body>
</html>