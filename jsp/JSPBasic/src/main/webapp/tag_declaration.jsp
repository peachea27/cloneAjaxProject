<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본태그-선언문</title>
</head>
<body>
<%! /* 느낌표 있으면 멤버변수 없으면 지역변수 */
	/* 선언문에서 선언된 변수나 메서드들은 jsp페이지가 초기화될 때 초기화되어서 
	페이지 내의 어떠한 스크립트릿이나 표현식에서도 접근해서 사용할 수 있다 */
	String str ="안녕하세요"; /* 멤버변수 */

	public int abs(int n) { /* 멤버 메서드 */
		if(n < 0){
			n = -n;
		}
		return n;
	}
%>
<%
	out.print("<div>"+str + "</div>");
	out.print("<div>"+abs(-4)+"<div>");
%>
</body>
</html>