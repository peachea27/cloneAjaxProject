<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그</title>

</head>
<body>
	<jsp:forward page="actionTag_forwardParam_1.jsp">
		<jsp:param value="hkd" name="userId"/>
		<jsp:param value="20" name="age"/> 
		<jsp:param value="홍길동" name="name"/> 
	</jsp:forward>
	

</body>
</html>