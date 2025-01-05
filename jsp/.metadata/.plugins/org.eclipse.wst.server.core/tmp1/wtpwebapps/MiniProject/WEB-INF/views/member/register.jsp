<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
<title>회원가입</title>
<script type="text/javascript">
	$(function(){
		// 아이디 이벤트
		$("#userId").keyup(function(){
			let tmpUserId = $("#userId").val();
			console.log(tmpUserId);
			// 1) 아이디 : 필수, 4-8자, 아이디는 중복 불가
			if(tmpUserId.length < 4 || tmpUserId.length > 8){
				outputError("아이디는 4-8자로 입력하세요", $("#userId"), "red");
			} else{
				//중복체크
				$.ajax({
				    url: '/member/isDuplicate', // 데이터가 송수신될 서버의 주소
				    type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
					data : {
						tmpUserId : tmpUserId
					}, // 데이터 보내기
				    dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
				    success: function (data) {
					    console.log(data);
					    if(data.msg == "duplicate"){
					    	outputError("중복된 아이디입니다",$("#userId"), "red");
					    	$("#userId").focus();
					    }else if(data.msg == "not duplicate"){
					    	outputError("사용 가능한 아이디입니다.", $("#userId"), "green");
					    	$("#idValid").val("checked");
					    }
				    },
				    error: function () {},
				    complete: function () {},
				  });
			}
		});
	
		//비밀번호 체크 이벤트
		$("#userPwd1").blur(function(){
			let tmpPwd = $("#userPwd1").val();
			if(tmpPwd.length < 4 || tmpPwd.length > 8){
				outputError("비밀번호는 4-8자로 입력하세요", $("#userPwd1"), "red");
				$("#idValid").val("");
			}else{
				outputError("사용가능한 비밀번호입니다.", $("#userPwd1"), "green");
			}
		});
		
		$("#userPwd2").blur(function(){
			let tmpPwd2 = $("#userPwd2").val();
			let tmpPwd1 = $("#userPwd1").val();
			
			if(tmpPwd1 != tmpPwd2){
				outputError("비밀번호가 다릅니다", $("#userPwd1"), "red");
				$("#userPwd1").val("");
				$("#userPwd2").val("");
				$("#pwdValid").val("");
			} else if (tmpPwd1 == tmpPwd2){
				outputError("일치", $("#userPwd1"), "green");
				$("#pwdValid").val("checked");
			}
		});
		
		$("#email").blur(function(){
			emailValid();	
		});
	});
	
	
	function outputError(errorMsg, tagObj, color){
		let errTag = $(tagObj).prev();
// 		console.log(errTag);
		$(errTag).html(errorMsg);
		$(errTag).css("color", color);
		$(tagObj).css("border-color", color);
	}
	
	function isValid(){
		let result = false;
		//유효성 검사 조건
		// 1) 아이디 : 필수, 4-8자, 아이디는 중복 불가
		// 2) 비밀번호 : 필수, 4-8자, 비밀번호 확인과 동일해야 한다.
		
		let idCheck = idValid();
		let pwdCheck = pwdValid();
		let genderCheck = genderValid();
		let mobileCheck = mobileValid();
		let emailCheck = emailValid();
		let imgCheck = imgValid();
		
		
		// 동의 항목 체크여부
		let agreeCheck = $("#agree").is(":checked");
		console.log(agreeCheck);
		if(agreeCheck == false){
			alert("동의항목에 체크해 주세요");
			result = false;
		}
		
		if(idCheck && pwdCheck && genderCheck && emailCheck && imgCheck && agreeCheck){
			result =  true;
		}else{
			result =  false;
		}
		return result;
	}
	function imgValid(){
		let result = false;
		let userImg = $("#userImg").val();
		if($("#imgCheck").val() == 'checked' || userImg == ''){
			result = true;
		}
		
		return result;
	}
	
	function idValid(){
		let result = false;
		if($("#idValid").val() == "checked"){
			result = true;
		}else{
			outputError("아이디는 필수 항목입니다", $("#userId"), "red");
		}
		
		return result;
	}
	
	function pwdValid(){
		let result = false;
		if($("#pwdValid").val() == 'checked'){
			result = true;
		}
		
		return result;
	}
	
	function genderValid(){
		//성별은 남성, 여성 중 하나를 반드시 선택해야 한다.
		let genders = document.getElementsByName("gender");
		let result = false;
		for(let gender of genders){
			if(gender.checked){
				console.log("체크됨");
				result = true;
			}
		}
		if(!result){
			outputError("성별은 필수입니다.", $(".genderSpan").next().next(),"red");
		} else { 
			outputError("완료", $(".genderSpan").next().next(),"green");
		}
		
		return result;
	}
	
	function mobileValid(){
		let result = false;
		let tmpUserMobile = $("#mobile").val();
		
		let mobileRegExp = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
		
		if(!mobileRegExp.test(tmpUserMobile)){
			outputError("휴대폰 형식이 아닙니다", $("#mobile"), "red");
		}else{
			outputError("완료", $("#mobile"), "green");
			result = true;
		}
		
		return result;
	}
	
	function emailValid(){
		// 1) 정규표현식을 이용하여 이메일 주소 형식인지 아닌지 판단
		// 2) 이메일 주소 형식이면.. 인증번호를 이메일로 보내고,
		//    인증번호를 다시 입력받아서 검증
		let result = false;
		
		let tmpUserEmail = $("#email").val();
		let emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		if(!emailRegExp.test(tmpUserEmail)){
			outputError("이메일 주소 형식이 아닙니다", $("#email"), "red");
		} else {
			//이메일 중복체크해야함(일단 생략)
			if($("#emailValid").val() == 'checked'){
				result = true;
			}else{
				showAuthenticateDiv(); // 인증번호를 입력하는 div를 보여줌
				callSendMail(); // 이메일 발송
				startTimer(); //타이머 동작
				outputError("이메일 형식입니다", $("#email"), "green");
			}
		}
		return result;
	}
	
	function startTimer(){
		let timer = 10; // 초 단위 
		
		// 71초 
		// min = 1
		// sec = 71 % 60 
		let timerInterval  = setInterval(displayTime, 1000);
	
		function displayTime(){
			// 3:00
			if(timer < 0){
				// 인증시간이 만료 : 타이머 해제
				clearInterval(timerInterval);
				$("#authBtn").prop("disabled", true);
				
				if($("#emailValid").val() != "checked"){
				// 백엔드에 인증시간이 만료되었음을 알려야한다.
				$.ajax({
				    url: '/member/clearAuthCode', // 데이터가 송수신될 서버의 주소
				    type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
				    dataType: "text", // 수신 받을 데이터 타입 (MIME TYPE)
				    success: function (data) {
					    console.log(data);
					    if(data == "success"){
					    	alert("인증번호가 만료되었습니다.");
					    	$(".authenticateDiv").remove();
							$("#email").val("");
							$("#email").focus();
					    }
				    },
				    error: function () {},
				    complete: function () {},
				  });
				}
			} else {
				let min = Math.floor(timer / 60);
				let sec = String(timer % 60).padStart(2,'0'); 
				let remainTime = min + ":" + sec;
				$(".timer").html(remainTime);
				--timer;
			}
		}
	}
	
	function showAuthenticateDiv(){
		alert("이메일로 인증번호를 발송했습니다. \n 인증코드를 입력해 주세요");
		let authDiv = "<div class='authenticateDiv'>"
		authDiv += `<input type = 'text' class="form-control" id="userAuthCode" placeholder="인증번호를 입력하세요"/>`;
		authDiv += `<span class="timer">3:00</span>`;
		authDiv += `<button type = "button" class="btn btn-info" id="authBtn" onclick ="checkAuthCode();">인증하기</button>`;
		authDiv += `</div>`;
		
		$(authDiv).insertAfter("#email");
	}
	
	function checkAuthCode(){
		let userAuthCode = $("#userAuthCode").val();
		
		$.ajax({
		    url: '/member/checkAuthCode', // 데이터가 송수신될 서버의 주소
		    type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
			data : {
				"tmpUserAuthCode" : userAuthCode 
			}, // 데이터 보내기
		    dataType: "text", // 수신 받을 데이터 타입 (MIME TYPE)
		    success: function (data) {
			    console.log(data);
			    if(data == "success"){
			    	outputError("인증완료", $("#email"),"green");
			    	$("#email").attr("readonly",true);
			    	$(".authenticateDiv").remove();
			    	$("#emailValid").val("checked");
			    }else if(data == "fail"){
			    	alert("인증실패");
			    	$("#emailValid").val("");
			    	
			    }
		    },
		    error: function () {},
		    complete: function () {},
		  });
	}
	
	function callSendMail(){
		$.ajax({
		    url: '/member/callSendMail', // 데이터가 송수신될 서버의 주소
		    type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
			data : {
				tmpUserEmail : $("#email").val() 
			}, // 데이터 보내기
		    dataType: "text", // 수신 받을 데이터 타입 (MIME TYPE)
		    success: function (data) {
			    console.log(data);
			    if(data == 'success'){
			    	alert("인증메일이 전송되었습니다. 인증번호를 입력해주세요");
			    	$("#userAuthCode").focus();
			    }
		    },
		    error: function () {},
		    complete: function () {},
		  });
	}
	
	function showPreview(obj){
		// 이미지 파일만 통과
		if(obj.files[0].size > 1024*1024*10){
			alert("10MB이하의 파일만 업로드 가능");
			obj.value = "";
			return;
		}
		
		//파일 타입 확인
		let imageType = ["image/jpeg","image/png","image/gif","image/jpg"];
		let fileType =obj.files[0].type;
		let fileName = obj.files[0].name;
		console.log(fileType);
		
		if(imageType.indexOf(fileType) != -1){ //이미지 파일이라면
			let reader = new FileReader(); // FileReader객체 생성
			reader.readAsDataURL(obj.files[0]); // 업로드된 파일을 읽어온다.
			reader.onload = function(e){
				//reader객체에 의해 파일을 읽기 완료하면 실행되는 콜백함수
				console.log(e.target);
				let imgTag = `<div style='padding: 6px;'><img src ='\${e.target.result}' width='50px'/><span>\${fileName}</span></div>`;
				$(imgTag).insertAfter(obj);
			}
			outputError("이미지 파일입니다", obj, "green");
			$("#imgCheck").val("checked");
		} else { // 이미지 파일이 아니라면
			outputError("이미지 파일만 올릴 수 있습니다", obj, "red");
			$(obj).val("");
		}
	}
	
</script>
<style type="text/css">
	.hobbies{
		display : flex;
		flex-direction: row;
		justify-content : space-between;
	}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>회원가입 페이지</h1>
		
		<form action="/member/register" method ="post" enctype="multipart/form-data">
			<div class="mb-3 mt-3">
    			<label for="userId" class="form-label">아이디:</label><span>에러메세지 스팬</span>
    			<input type="text" class="form-control" id="userId" placeholder="아이디를 입력하세요" name="userId">
    			<input type="hidden" id="idValid"/>
  			</div>
			<div class="mb-3 mt-3">
    			<label for="userPwd1" class="form-label">비밀번호:</label>
    			<input type="password" class="form-control" id="userPwd1" placeholder="비밀번호를 입력하세요" name="userPwd">
  			</div>
			<div class="mb-3 mt-3">
    			<label for="userPwd2" class="form-label">비밀번호 확인:</label>
    			<input type="password" class="form-control" id="userPwd2" placeholder="비밀번호를 재입력하세요" >
    			<input type="hidden" id="pwdValid"/>
  			</div>
			<div class="mb-3 mt-3">
    			<label for="userName" class="form-label">이름:</label>
    			<input type="text" class="form-control" id="userName" placeholder="이름을 입력하세요" name="userName">
  			</div>
  			<span class="genderSpan">성별 : </span><span></span>
  			
  			<div class="form-check">
			  <label class="form-check-label" for="female">
			  <input type="radio" class="form-check-input" id="female" name="gender" value="F">여성
			  </label>
			</div>
			<div class="form-check">
			  <label class="form-check-label" for="male">
			  <input type="radio" class="form-check-input" id="male" name="gender" value="M">남성
			  </label>
			</div>
			<div class="mb-3 mt-3">
    			<label for="mobile" class="form-label">휴대폰 번호:</label><span></span>
    			<input type="text" class="form-control" id="mobile" placeholder="휴대폰 번호를 입력하세요" name="mobile">
  			</div>
			<div class="mb-3 mt-3">
    			<label for="email" class="form-label">이메일:</label><span></span>
    			<input type="email" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email">
    			<input type="hidden" id="emailValid"/>
  			</div>
<!--   				취미 -->
  			<div class="form-check mb-3 mt-3">
  				<div class="hobbies">
 					 <span><input class="form-check-input" type="checkbox"  name="hobbies" value="something" >볼링</span>
 					 <span> <input class="form-check-input" type="checkbox"  name="hobbies" value="something" >게임</span>
 					 <span><input class="form-check-input" type="checkbox"  name="hobbies" value="something" >운동</span>
 					 <span><input class="form-check-input" type="checkbox"  name="hobbies" value="something" >문화생활</span>
				</div>
  			</div>
<!--   				유저 프로필 사진 -->
  			<div class="mb-3 mt-3">
  				<label class="form-check-labe">회원 프로필 사진 :</label>
  				<input type ="file" class="form-control" name="userProfile" id ="userImg" onchange="showPreview(this)"/>
  			</div>
  			<input type="hidden" id="imgCheck"/>
  			
  			<div class="form-check">
  				<input class="form-check-input" type="checkbox" id="agree" name="agree" value="Y">
  				<label class="form-check-label">회원가입 조항에 동의합니다.</label>
			</div>
  			
  			<input type="submit" class="btn btn-success" value = "회원가입" onclick="return isValid();"/>
  			<input type="reset" class="btn btn-danger" value = "취소" />
  			
  			
		</form>
		
	</div>
	
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>