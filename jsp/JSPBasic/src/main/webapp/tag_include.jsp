<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
      <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>기본태그 - include 지시자</title>
</head>
<body>
<%@include file="header.jsp" %>

<h1>Hello,jsp</h1>
<!-- header.jsp에 이미 선언되어 있는 지역변수이기 때문에, 아래와 같이 또 선언할 수 없다 -->
<%-- <% int a = 50; %> --%> <!-- Duplicate local variable a -->
<%=a %>

<%@ include file="footer.jsp" %>

</body>
</html>