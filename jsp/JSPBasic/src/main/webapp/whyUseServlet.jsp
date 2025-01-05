<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>왜 servlet을 사용하는가</title>
<script>
	function hello(){
		alert("!");
	}
</script>
<style>
	h1{
		background-color:  lime;
		}
</style>
</head>
<body>
	<h1 onclick="hello();">왜 Servlet을 사용하는가?</h1>
	
	<% /* 자바코드는 프론트에서 보이지 않는다 */
			int num =3;
			out.print(num);
			
			/* num이 짝수이면 빨간색으로 "짝수입니다" 출력 */
			/* 홀수이면 파란색으로 "홀수입니다" 출력 */
			
			if(num % 2 == 0){
				%>
				<div style="color : red;">짝수입니다.</div>
				<% 
			}else{
				%>
				<div style="color : blue;">홀수입니다.</div>
				<%
			}
	%>
</body>
</html>