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
	<div>당신이 좋아하는 계절은
		<%=request.getParameter("favSeason") %>입니다.
	
	</div>
	<div>별명: <%=request.getParameter("nickName") %></div>
	
	<hr/>
	<div>${param.nickName }님이 좋아하는 계절은
	${param.favSeason}입니다.</div>
		
	<hr/>
	<div>${param.nickName }님이 좋아하는 계절은
		${paramValues.favSeason[0] }과
		${paramValues.favSeason[1] }입니다.</div>
		
	<hr />
	<div>좋아하는 계절:
		<c:forEach var="season" items="${paramValues.favSeason }">
		${season }
		</c:forEach>
	</div>
</body>
</html>