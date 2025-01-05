<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>doAction5.jsp</h1>
<div>${student }</div>
<div>학번 : ${Student.stuNo }</div> //대문자로 하면 안됨 
<div>이름 : ${student.stuName }</div>
<hr />
<div>${stu }</div>
<div>학번 : ${stu.stuNo }</div>
<div>이름 : ${stu.stuName }</div>
</body>
</html>