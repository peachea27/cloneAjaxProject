<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validation(){
		let isValid =false;
		let kor = document.getElementById("kor").value;
		if(kor <0 || kor >100){
			alert("국어점수는 유효하지 않습니다!");
		}else{
			isValid=true;
		}
		return isValid;
	}
</script>
</head>
<body>
	<form action="ValidationServlet" method="get">
	<div>국어:<input type="text" name="kor" id="kor"/></div>
	<div>영어:<input type="text" name="eng"/></div>
	<div>수학:<input type="text" name="math"/></div>
	<input type="submit" value="전송" onclick="return validation();">
	</form>
</body>
</html>