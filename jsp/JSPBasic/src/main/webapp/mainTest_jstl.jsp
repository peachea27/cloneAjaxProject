<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function getParameter(paraName) {
	  //쿼리스트링에서 파라미터 값 얻어오기
	  let returnVal = null;
	  let url = location.href;
	  
	  
	  
	  if (url.indexOf("?") !== -1) {
	    //쿼리스트링이 있는 경우
	    let queryString = url.split("?")[1];
	    let queryStringArr = queryString.split("&");

	    for (let item of queryStringArr) {
	      if (item.split("=")[0] == paraName) {
	        returnVal = item.split("=")[1];
	        break; //파라미터 값을 찾으면 해당 반복문 블럭을 빠져감
	      }
	    }
	  }
	  console.log(returnVal);
	  return returnVal;
	}
	
	window.onload = function(){
		let status = getParameter("status");
		if(status == "loginSuccess"){
			alert("로그인 성공! 회원님 방가!!")
		}else if(status =="loginFail"){
			alert("아이디나 비밀번호를 확인 후 로그인해주세요")}
			
	}

</script>
</head>
<body>
	<h1>mainTest.jstl</h1>
	
	<c:choose>
		<c:when test="${sessionScope.loginMemberId !=null}">
			<form action="mainTest_jstl_logout_Servlet" method="post">
				<input type="submit" value="로그아웃">
			</form>
		</c:when>
		<c:otherwise>
		<button onclick="location.href='jstl/loginTest_jstl.jsp'">로그인</button>
		</c:otherwise>
	</c:choose>

	
	<div>세션 id: <%=session.getId() %></div>
	<div>로그인한 유저 아이디:<%=session.getAttribute("loginMemberId") %></div>
	<div>${sessionScope.loginMemberId }</div>
	
</body>
</html>