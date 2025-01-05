<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
  
  <!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>


<title>Insert title here</title>
<script type="text/javascript">
	
	$(function(){
		$('#summernote').summernote({
			 maximumImageFileSize : 1024 * 1024 * 10,
			 placeholder: 'Hello Bootstrap 5',
		     tabsize: 2,
		     height: 100
		});
	});
	
	function validBoard(){
			// 게시글의 제목 (not null) 유효성 검사
			let result = false;
			let title = $("#title").val();
			console.log(title ==='');
			
			if(title == ''){
				//제목을 입력하지 않은 경우
				alert("제목을 입력하세요");
				$("#title").focus();
			} else{
				// 제목을 입력했을 때
				result = true;
			}
			return result;
	}
</script>
<style>

</style>
</head>
<body>
<jsp:include page="./../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시글 작성</h1>
		<form action="saveBoard" method="post">
			<div class="input-group mb-3">
  				<span class="input-group-text">글 제목</span>
  				<input type="text" class="form-control" name="title" id="title" placeholder="글 제목을 입력하세요..."/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">작성자</span>
  				<input type="text" class="form-control" name="writer" placeholder="작성자를 입력하세요..." value="${loginMember.userId}" readonly/>
			</div>
	
			<!-- 	내용		 -->
			<div>
	  		<textarea id="summernote" name="content"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary" onclick="return validBoard();">저장</button>
			<button type="reset" class="btn btn-primary" >취소</button>
		</form>
	</div>
<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>