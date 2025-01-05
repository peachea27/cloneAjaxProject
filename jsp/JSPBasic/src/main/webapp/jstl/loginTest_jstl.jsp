<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인하기3</h1>
<form action="LoginTest_jstl_Servlet" method="post">
<div>아이디 : <input type="text" name="userId"/></div>
<div>패스워드 : <input type="text" name="userPwd"/></div>
<div>
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
</div>
</body>
</html>