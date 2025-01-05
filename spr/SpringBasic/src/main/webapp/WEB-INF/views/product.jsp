<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>product.jsp</h1>
<div>prod : ${prod }</div>
<div>상품번호 : ${prod.prodNo }</div>
<div>상품이름 : ${prod.prodName }</div>
<div>상품가격 : ${prod.price }</div>

<hr/>
<div>${productDTO }</div>
</body>
</html>