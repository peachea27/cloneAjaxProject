<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>POST 방식으로 요청</title>
<script type="text/javascript">
	/* ajax */
	function call(){
		$.ajax({
	          url: "./hPOST", //데이터가 송수신될 서버의 주소
	          type: "POST", //통신방식(GET,POST,PUT,DELETE)
	          data: {
	        	  "name":"둘리"
	        	  }, 
	          success: function (data) {
	            console.log("ajax success");
	          }
	        });
	}
</script>
</head>
<body>
	<form action="./hPOST" method="post">
		<div>이름:<input type ="text" name="name"/></div>
		<div>나이:<input type ="text" name="age"/></div>
		<input type="submit" value= "전송"/>;
	</form>
	<button onclick="call()">Ajax로 서블릿 요청</button>
	
	
</body>
</html>