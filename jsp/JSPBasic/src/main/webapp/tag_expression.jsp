<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본태그 - 표현식 expression</title>
</head>
<body>

<%! 
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
<!-- 표현식에서는 out.print(str;)로 변환되므로, 세미콜론을 입력하지 않아야 한다. -->
<%-- <div><% str; %></div> --%>
<div>
<%=str %>
</div>
<div><%=abs(-4) %></div>
</body>
</html>