<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload=function(){
	let theCookie="theCookie";
	let cookieValue="";
	let cookieData =document.cookie;
	let start =cookieData.indexOf(theCookie);
	
	if(start !==-1){
	let end =start+theCookie.length
	cookieValue =cookieData.substring(start,end);
	
	if(cookieValue=="theCookie"){
	
	}
	}
	
}
</script>

</head>
<body>
<h1>로그인</h1>

<%
	String loginId ="";
	Cookie[] cookies = request.getCookies();
	
	for(Cookie cookie : cookies){
		String cookieName = cookie.getName();
		if(cookieName.equals("remember")){
			loginId = cookie.getValue();
		}
	}
	
	String rememberChecked ="";
	if(!loginId.equals("")){
		rememberChecked ="checked";
	}

%>

<form action="RememberIdServlet" method="post">
<div>아이디 : <input type="text" name="userId" value="<%=loginId%>"/>
			<input type="checkbox" name="rememberId" value="Y" <%= rememberChecked %> />아이디저장
</div>
<div>패스워드 : <input type="text" name="userPwd"/></div>
<div>
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
</div>
</form>
</body>
</html>