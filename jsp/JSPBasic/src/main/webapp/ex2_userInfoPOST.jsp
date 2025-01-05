<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function pwdValidation(){
		let isValid =false;
		let pwd = document.getElementById("userPwd").value;
		console.log(pwd);
		/* 정규식으로 비밀번호 설정하기 (최소 8글자, 글자 1개, 숫자 1개, 특수문자 1개) */
		let regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
		console.log(regExp.test(pwd)); /* boolean반환 */
		
		if(regExp.test(pwd)==false){
		alert('비밀번호 형식에 맞지 않습니다.')
		}else{
		isValid=true;
		}
		
		return isValid;
	}
</script>
</head>
<body>
	<form action ="EX1UserInfoPOST" method="POST">
	<div>이름: <input type="text" name="userName"></div>
	<div>아이디: <input type="text" name="userId"></div>
	<div>비밀번호: <input type="text" name="userPwd" id="userPwd"></div>
	<input type="submit" value="전송" onclick="return pwdValidation()">
	</form>
</body>
</html>