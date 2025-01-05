<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set and remove</title>
</head>
<body>

<c:set var="msg" value="졸려요"></c:set>

<div>${pageScope.msg }</div>
<div>${msg }</div>
<hr/>

<div><c:out value="${msg }"></c:out></div>
<div><c:out value="광복절에 뭐하지"></c:out></div>

<hr/>
<c:remove var="msg"/>
<div><c:out value="${msg }"></c:out></div>
</body>
</html>