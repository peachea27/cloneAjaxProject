<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적표</title>
</head>
<body>
<h1>성적표</h1>
<table border="1">
	<tr>
	<td>국어</td>
	<td>영어</td>
	<td>수학</td>
	<td>총점</td>
	<td>평균</td>
	</tr>
	<tr>
	<td>${kor }</td>
	<td>${eng }</td>
	<td>${math }</td>
	<td>${tot }</td>
	<td>${avg }</td>
	</tr>
</table>
</body>
</html>