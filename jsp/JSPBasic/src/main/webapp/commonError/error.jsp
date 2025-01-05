<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- isErrorPage ="true"설정해주어 에러내용을 그대로 넘겨받고 exception 객체 사용가능 -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 처리 페이지 (공통예외 처리할 때 사용)</title>
</head>
<body>
<h1>에러페이지</h1>
<h2>일시적인 오류가 발생하였습니다.</h2>
<div>에러가 지속되면 민성씨에게 연락주세요....</div>


<h3><%=exception.getClass().getName() %></h3>
<h4><%=exception.getMessage() %></h4> <!-- by zero 0으로 나눠서 에러 -->
<div><%=exception.getStackTrace()[0] %></div>
<div><%=exception.getStackTrace()[1] %></div>
<div><%=exception.getStackTrace()[2] %></div>
<div><%=exception.getStackTrace()[3] %></div>
<div><%=exception.getStackTrace()[4] %></div>
<div><%=exception.getStackTrace()[5] %></div>
</body>
</html>