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
<!-- 	횟수만큼 반복하고 싶을 때 -->
<c:forEach var="i" begin="1" end="10">
	<div>${i }번째 div태그</div>
</c:forEach>
<hr />
<c:forEach var="i" begin="1" end="9" step="2">
	<div>${i }번째 div태그</div>
</c:forEach>

<!-- 구구단 출력 -->
<c:forEach var="dan" begin="2" end="9">
<h1>${dan }단</h1>
<c:forEach var="i" begin="1" end="9">
	<div>${dan }X ${i }=${dan*i }</div>
</c:forEach>
</c:forEach>

<%-- <c:forEach var="i" begin="1" end="9">
<div>
<c:forEach var="j" begin="2" end="9">
 ${j }X${i } = ${i*j}
</c:forEach></div></c:forEach> --%>
</body>
</html>