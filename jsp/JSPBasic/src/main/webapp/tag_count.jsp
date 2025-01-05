<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 선언문 --> 
 <%! int globalCnt = 0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 태그</title>
</head>
<body>

<%
	int localCnt =0;
	
	out.print("<br>localCnt : ");
	out.print(++localCnt);
	out.print("<br>globalCnt : ");
	out.print(++globalCnt);
%>

</body>
</html>