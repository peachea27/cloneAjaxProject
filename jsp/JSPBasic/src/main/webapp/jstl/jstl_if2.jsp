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
	${param.favSeason == '봄' } <!-- true -->
	<c:if test="${param.favSeason == '봄' }">
		<!-- test의 조건이 참일 때 실행 문장들 -->
		<div style="color:green;">${param.nickName }님은 봄을 좋아하시네요</div>
	</c:if>
	
	<c:if test="${param.favSeason == '여름' }">
		<!-- test의 조건이 참일 때 실행 문장들 -->
		<div style="color:blue;">${param.nickName }님은 여름을 좋아하시네요</div>
	</c:if>
	
	<c:if test="${param.favSeason == '가을' }">
		<!-- test의 조건이 참일 때 실행 문장들 -->
		<div style="color:orange;">${param.nickName }님은 가을을 좋아하시네요</div>
	</c:if>
	
	<c:if test="${param.favSeason == '겨울' }">
		<!-- test의 조건이 참일 때 실행 문장들 -->
		<div style="color:gray;">${param.nickName }님은 겨울을 좋아하시네요</div>
	</c:if>
</body>
</html>