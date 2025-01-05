<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>회원가입</title>

</head>
<body>
    <div class="container">
        <form action="registerMember.jsp" method="post" name ="frm">
        <h1 style="color : pink;">회원 가입</h1>
        <p>아래 항목을 기입해 주세요.</p>
        <hr />
<div class="mb-3 mt-3">        
        <label for="userId"><b>아이디</b></label>
        <input type="text" class="form-control" placeholder="Enter id" name="userId" id="userId" />
      </div>
      <div class="mb-3 mt-3">
        <label for="pwd1"><b>비밀번호</b></label>
        <input type="password" class="form-control" placeholder="Enter Password" name="pwd1" id="pwd1" />
</div>

<div class="mb-3 mt-3">
        <label for="email"><b>Email</b></label>
        <input type="text" class="form-control" placeholder="Enter Email" name="email" id="email" />
</div>
<div class="mb-3 mt-3">
        <label for="mobile"><b>휴대폰 번호</b></label>
        <input type="text" class="form-control" placeholder="Enter mobile" name="mobile" id="mobile" />
</div>

        <div class="clearfix">
          <button type="reset" class="cancelbtn">Cancel</button>
          <button type="submit" class="signupbtn">Sign Up</button>
        </div>
  </form>
      </div>
  <!-- </div> -->
</body>
</html>