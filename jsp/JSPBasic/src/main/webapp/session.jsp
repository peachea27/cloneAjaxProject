<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - session</title>
</head>
<body>
	<div>세션 id : <%=session.getId() %></div> <!-- 브라우저를 껐다 켜지 않는한 계속 동일 -->
	<div>세션 유효 시간 : <%=session.getMaxInactiveInterval() %>초(sec)</div> 
</body>
</html>