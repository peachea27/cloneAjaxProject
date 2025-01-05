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
	<div><fmt:formatNumber value="123456.89"></fmt:formatNumber></div>
	
	<!-- 통화형식 지정 -->
	<div><fmt:formatNumber value="123456" type="currency"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="123456" type="currency" currencySymbol="$"></fmt:formatNumber></div>

	<hr />
	<div><fmt:formatNumber value="0.574" type="percent"></fmt:formatNumber></div>
	
	<hr/>
	<div><fmt:formatNumber value="123456.89" pattern="#,###.#"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="123456.8956" pattern="#,###.###"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="123456.89" pattern="#,###.###"></fmt:formatNumber></div>
	<hr/>
	<!-- 0은 빈자리만큼 0으로 채움 /아래 둘은 같지만 0은 남은 자리를 채움-->
	<div><fmt:formatNumber value="123456.89" pattern="#,###.000"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="123456.89" pattern="#,###,###.000"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="123456.89" pattern="000,000,000.000"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="123456.89" pattern="0,000.000"></fmt:formatNumber></div>
	
	
</body>
</html>