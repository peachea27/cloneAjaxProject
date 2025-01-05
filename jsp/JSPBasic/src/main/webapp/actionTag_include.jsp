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
<title>액션태그 - include</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>action 태그를 이용한 include</h1>
<div>본문</div>
	
	<%
		int a = 30;
	%>
	<%=a %>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>