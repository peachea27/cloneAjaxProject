<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
function figureOut(){

	$.ajax({
        url: "./gGET?result="+result, //데이터가 송수신될 서버의 주소
       // url: "./gGET", //데이터가 송수신될 서버의 주소
        type: "GET", //통신방식(GET,POST,PUT,DELETE),
       /*  data: {
        	"result":result
        }, */
        success: function (data) {
          //통신이 성공하면 수행할 함수
          // location.href="./gGET";
        },
      
        error: function () {},
        complete: function () {
          //통신이 완료되면 수행
        },
      });
    }
	

	
	
	

</script>
</head>
<body>
<h1>삼각형의 넓이를 구해보자!</h1>

<form action="./gGET" method="get">
높이:<input id="heigt" type ="text" name="height"/>;
밑변:<input id="base" type ="text" name="base"/>;
<button type ="submit">계산하기</button>
</form>

<h1>이름, 아이디, 비밀번호를 가져오자!</h1>

<form action="./pPOST" method="post">
	<div>이름: <input type = "text" name="name"/></div>
	<div>아이디:<input type = "text" name="id"/></div>
	<div>비밀번호:<input type = "text" name="pwd"/></div>
	<input type="submit" value="전송"/>
</form>

</body>
</html>