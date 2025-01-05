<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#remember").click(function(){
			alert("자동로그인은 공공장소에 사용하지 않은 것을 권고합니다");
		});
	});
	
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>로그인</h1>
		<form action="/member/login" method="post">
			<div class="mb-3 mt-3">
    			<label for="userId" class="form-label">아이디:</label>
    			<input type="text" class="form-control" id="userId" placeholder="아이디를 입력하세요" name="userId">
    			<input type="hidden" id="idValid"/>
  			</div>
			<div class="mb-3 mt-3">
    			<label for="userPwd1" class="form-label">비밀번호:</label>
    			<input type="password" class="form-control" id="userPwd" placeholder="비밀번호를 입력하세요" name="userPwd">
  			</div>
  			<div class="form-check">
				  <input class="form-check-input" type="checkbox" id="remember" name="remember"/>
				  <label class="form-check-label">Remember me</label>
			</div>
  			<button class="btn btn-success" type="submit">로그인</button>
  			<button class="btn btn-secondary" type="reset">취소</button>
		</form>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>