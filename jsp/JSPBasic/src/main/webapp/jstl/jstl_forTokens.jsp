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

<%
	String heroes ="캡틴아메리카노,헐쿠,스파이더맨,아이언맨,토르";
	pageContext.setAttribute("heroes",heroes);
%>

<ul>
	<c:forTokens var="hero" items="${heroes }" delims=",">
		<li>${ hero }</li>
	</c:forTokens>
</ul>

<c:redirect url="../hello.jsp"></c:redirect>

</body>
</html>