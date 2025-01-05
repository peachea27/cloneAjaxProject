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
	String[] heroes ={"캡틴아메리카노","헐쿠","스파이더맨","아이언맨","토르"};
	pageContext.setAttribute("heroes",heroes);
%>

<!-- 짝수번째 index칼럼의 td배경색을 노란색으로 바꾸기 -->
<table border="1">
	<tr>
		<th>index</th><th>count</th><th>hero</th>
	</tr>
	
	<c:forEach var="hero" items="${heroes }" varStatus="status">
		<tr>
			<c:choose>
			<c:when test="${status.index % 2 ==0 }"> 
					<td style="background-color: yellow;">${status.index }</td>
				</c:when>
				<c:otherwise>
					<td>${status.index }</td>
				</c:otherwise>
			</c:choose>
			
			<td>${status.count }</td>
			<td>${hero }</td>
		</tr>
	</c:forEach>
</table>

<!-- 첫번째 tr의 글자색을 빨간색으로 하고, 첫번째 tr이 아니면 글자색 검정색으로 한다. -->
 <table border="1">
	<tr>
		<th>index</th><th>count</th><th>hero</th>
	</tr>
	
	<c:forEach var="hero" items="${heroes }" varStatus="status">
	<c:choose>
		<c:when test="${status.first }">
		<tr style="color : red;">
			<c:choose>
			<c:when test="${status.index % 2 ==0 }"> 
					<td style="background-color: yellow;">${status.index }</td>
				</c:when>
				<c:otherwise>
					<td>${status.index }</td>
				</c:otherwise>
			</c:choose>
			
			<td>${status.count }</td>
			<td>${hero }</td>
		</tr>
		</c:when>
		<c:otherwise>
		<tr>
			<c:choose>
			<c:when test="${status.index % 2 ==0 }"> 
					<td style="background-color: yellow;">${status.index }</td>
				</c:when>
				<c:otherwise>
					<td>${status.index }</td>
				</c:otherwise>
			</c:choose>
			
			<td>${status.count }</td>
			<td>${hero }</td>
		</tr>
		</c:otherwise>
		</c:choose>
	</c:forEach>
</table>

</body>
</html>