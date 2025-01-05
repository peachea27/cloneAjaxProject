<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- "/ELScopeTestServlet" -->
<html>
<head>
<meta charset="UTF-8">
<title>바인딩 시킨 영역으로 접근하여 출력</title>
</head>
<body>
<h1>elScope.jsp</h1>
<h2>바인딩 시킨 영역으로 접근하여 출력</h2>
<div>member : ${requestScope.member }</div>
<div>member.userId:${requestScope.member.userId }</div>
<div>member.pwd:${requestScope.member.pwd1 }</div>
<div>member.email:${requestScope.member.email }</div>

<div>session result : ${sessionScope.result }</div> <!-- (5+3=8) -->
<div>request result : ${requestScope.result }</div> <!-- 바인딩시킨적 없으므로 null -->

<hr/><!--EL이 내장객체 순회하면서 일치하는 정보를 찾음 -->
<div>member : ${member }</div>
<div>member.userId : ${member.userId }</div>
<div>result : ${result }</div> 
</body>
</html>