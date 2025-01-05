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
	<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
	<div>톰캣 서버의 기본 로케일: <%=response.getLocale() %></div> <!-- ko_KR : 한국 기준으로 되어있다-->
	<div>통화<fmt:formatNumber value="123456" type="currency"></fmt:formatNumber> </div>
	<div>현재 날짜 시간:<fmt:formatDate value="${now }" type="both"/> </div>
	
	<hr/>
	<fmt:setLocale value="en_US"/>
	<c:set var="nowUS" value="<%=new java.util.Date() %>" ></c:set>
	<div>로케일(us):<%=response.getLocale() %></div>
	<div>통화<fmt:formatNumber value="123456" type="currency"></fmt:formatNumber> </div> <!-- 달러로 나옴 -->
	<div>현재 날짜 시간: <fmt:formatDate value="${nowUS }" type="both" timeZone="America/New_York"/> </div>
	
	<hr />
	<fmt:timeZone value="GMT-4">
	<div>뉴욕 시간 GMT-4: <fmt:formatDate value="${nowUS }" type="both"/> </div>
	</fmt:timeZone>
	
	<hr/>
	<fmt:setLocale value="ja_JP"/>
	<div>로케일(jp):<%=response.getLocale() %></div>
	<div>통화<fmt:formatNumber value="123456" type="currency"></fmt:formatNumber> </div>
	<div>현재 날짜 시간: <fmt:formatDate value="${now }" type="both"/> </div>
</body>
</html>