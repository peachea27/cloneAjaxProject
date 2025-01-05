<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello.jsp</h1>
<div>이름:${param.name }</div>
<div>나이:<%=request.getParameter("age") %></div>
<div>status:${status }</div><!-- 쿼리스트링엔 없지만 부르면 잘 찍힘 -->

<hr />
<h1>hello.jsp</h1>
<div>이름:${param.name }</div>
<div>나이:${param.age }</div>
</body>
</html>