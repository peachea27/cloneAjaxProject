<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL로 표현 가능한 데이터</title>
</head>
<body>
	<div>정수형:${10 }</div>
	<div>실수형:${3.14 }</div>
	<div>문자열:${"오늘 매우 덥습니다" }</div>
	<div>논리형:${true }</div>
	<div>null:${null }</div> <!-- 아무것도 출력 안됨 -->
	
	
</body>
</html>