<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입회원 정보</title>
</head>
<body>
<!-- Bean객체 생성 -->
<jsp:useBean id="member" class="lee.dto.MemberDTO" scope='session'></jsp:useBean>
<%-- <jsp:setProperty property="userId" name="member"/> --%>
<jsp:setProperty property="*" name="member"/>

<div>아이디: <jsp:getProperty property="userId" name="member"></jsp:getProperty></div>
<div>이메일: <jsp:getProperty property="email" name="member"></jsp:getProperty></div>

<a href="registerMember_1.jsp">registerMember_1로 이동</a>
</body>
</html>