<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 - userBean</title>
</head>
<body>
	<!-- 기본생성자를 이용해서 id속성값의 이름으로 Bean(객체)를 생성한다 -->
	<jsp:useBean id="member1" class="lee.dto.MemberDTO"></jsp:useBean>
	
	<!-- userBean으로 생성된 Bean객체에 속성 값을 설정(setter호출) -->
	<jsp:setProperty property="userId" name="member1" value="hkd"/>
	<jsp:setProperty property="pwd1" name="member1" value="1234"/>
	<jsp:setProperty property="email" name="member1" value="hkd@abc.com"/>
	
	<% out.print(member1.toString()); %>
	
	<div>아이디:<jsp:getProperty property="userId" name="member1"/></div>
	<div>이메일:<jsp:getProperty property="email" name="member1"/></div>
</body>
</html>