<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
	.topHeader{
		background-image:url("/resources/images/flower.jpg");
		background-size:cover;
		background-position: center;
		height:300px;
	}
	
	.userArea {
		display : flex;
		align-items : center;
	}
	
	.userProfile {
		width : 30px;
		height : 30px;
		border-radius : 20px;
	}
</style>
</head>
<body>
<div class="p-5 bg-primary text-white text-center topHeader">
  <h1>Spring Mini-Project</h1>
  <p>2024</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="/">Weblee</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/hboard/listAll">계층형게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cboard/listAll">댓글형게시판</a>
      </li>
      
      <c:choose>
      	<c:when test="${loginMember != null}">
	      <li class="nav-item userArea">
	        <a class="nav-link" href="/member/myPage">
	        	<img src ="/resources/userImg/${loginMember.userImg}" class="userProfile"/>
	        	<span class="userName">${loginMember.userName}님</span>
	        </a>
	      </li>
	      
	      <li class="nav-item">
	        <a class="nav-link" href="/member/logout">로그아웃</a>
	      </li>
      	</c:when>
      	<c:otherwise>
	      <li class="nav-item">
	        <a class="nav-link" href="/member/register">회원가입</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/member/login">로그인</a>
	      </li>
      	</c:otherwise>
      </c:choose>
      
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>
</nav>
</body>
</html>