<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본태그 - 주석</title>
</head>
<body>
<!-- 간단한 주석문 --> <!-- 이건 변환됨 개발자모드에서 볼 수 있다 -->

<%-- jsp 기본 태그 주석문 내용은 Servlet 코드로 변환되지 않음--%>
<% String name ="홍길동"; %> <!-- 표현식이 아니니까 ;찍어줘야 -->

Hello<%=name %>


</body>
</html>