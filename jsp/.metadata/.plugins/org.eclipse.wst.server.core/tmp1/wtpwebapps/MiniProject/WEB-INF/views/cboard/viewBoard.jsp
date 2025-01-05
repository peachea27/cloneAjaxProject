<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://kit.fontawesome.com/541891a451.js" crossorigin="anonymous"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
<title>게시글 조회</title>
<script type="text/javascript">
	let pageNo = 1;
	$(function(){
		
		getAllComments(pageNo);
		
		$(".fa-heart").click(function(){
			let commenter = preAuth();
			
			if($(this).attr("id") == 'dislike'){//안좋아요 -> 좋아요
				$(this).attr("id", "like");
				$(this).removeClass("fa-regular").addClass("fa-solid");
			}else if($(this).attr("id") == "like"){ // 좋아요 ->안좋아요
				$(this).attr("id", "dislike");
				$(this).removeClass("fa-solid").addClass("fa-regular");
			}
			sendBoardLike($(this).attr("id"));
		});
		
		$(".modalCloseBtn").click(function(){
			$("#myModal").hide();
		})
	});
	
	function sendBoardLike(doesLike){
		console.log(doesLike);
		let who = preAuth(); // 로그인한 userId
		let boardNo = '${param.boardNo}';
		
		$.ajax({
		    url: '/cboard/boardlike',
		    type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
			data : {
				"who" : who,
				"boardNo" : boardNo,
				"like" : doesLike
			},
		    dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
		    success: function (data) {
		    	console.log(data);
				
		    },
		    error: function () {
		    },
		    complete: function () {},
		  });	
		
	}
	
	function getAllComments(pageNo){
		$.ajax({
		    url: '/comment/all/${param.boardNo}/' + pageNo  , // 데이터가 송수신될 서버의 주소
		    type: "GET", // 통신 방식 (GET, POST, PUT, DELETE)
		    dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
		    success: function (data) {
			    console.log(data);
		    	if(data.resultCode == 200 || data.resultMessage == 'SUCCESS'){
			    outputcomments(data);
		    	}
// 			    displayAllComments(data);
		    },
		    error: function () {},
		    complete: function () {},
		  });	
	}
	
	function outputcomments(comments){
		let output ='<div class="list-group">';
		
		if(comments.data.commentList.length == 0){
			output +=`<div class="empty">`;
			output += `<div>댓글이 비었습니다.</div>`;
			output += `</div>`;
		} else {
			$.each(comments.data.commentList, function(i,e){
				output += `<div class="list-group-item comment" id="comment_\${e.commentNo}">`;
				output += `<div class='commentBody'>`;
				
				output += `<div class='commenterProfile'>`;
				output += `<img src='/resources/userImg/\${e.userImg}'/>`;
				output += `</div>`;
				
				output += `<div class='commentBodyArea'>`;
				output += `<div class='commentHeader'>`;
				
				output += `<div class='commentContent'>\${e.content}`;
				
				if(e.commenter != '${loginMember.userId}'){
					// 작성자와 로그인유저가 같지 않은 경우
					output += `<div class='commentBtns'></div></div>`;
				}else if(e.commenter == '${loginMember.userId}'){
					output += `<div class='commentBtns'><img src ="/resources/images/modify.png" onclick='modifyComment(\${e.commentNo});'/>`;
					output += `<img src= "/resources/images/remove.png" onclick='removeComment(\${e.commentNo})'/></div></div>`;
				}
				
				output += `<div class='commentInfo' >`;
				let elapsedTime = processPostDate(e.regDate);
				output += `<div class= "regDate">\${elapsedTime}</div>`;
				
				output += `<div class='commenter'>\${e.commenter}</div>`;
				output += `</div>`;
				
				output += `</div>`;
				output += `</div>`;
				output += `</div>`;
				output += `</div>`;
			});
			
			outputPagination(comments);
		}
		output += '</div>';
		
		$(".commentList").html(output);
	}
	
	//댓글 페이징
	function outputPagination(comments){
		let output = `<ul class="pagination justify-content-center" style="margin:20px 0">`;
		let pagingInfo = comments.data.pagingInfo;
		console.log(pagingInfo);
		if(pageNo > 1){
			output += `  <li class="page-item"><a class="page-link" onclick="getAllComments(--pageNo)">Previous</a></li>`;
		}else if(pageNo == 1){
			output += `  <li class="page-item disabled"><a class="page-link" >Previous</a></li>`;
		}
		
		for(let i = pagingInfo.startPageNoCurBlock; i <= pagingInfo.endPageNoCurBlock ; i++){
			if(pageNo == i){
				output += `<li class="page-item active"><a class="page-link" onclick="pageNo = \${i}; getAllComments(\${i});" >\${i}</a></li>`;			
			}else{
				output += `<li class="page-item"><a class="page-link" onclick="pageNo = \${i}; getAllComments(\${i});" >\${i}</a></li>`;			
			}
		}
		
		if(pageNo < pagingInfo.totalPageCnt){
			output += `<li class="page-item"><a class="page-link" onclick="getAllComments(++pageNo);">Next</a></li>`;
		} else if(pageNo == pagingInfo.totalPageCnt){
			output += `<li class="page-item disabled"><a class="page-link" >Next</a></li>`;
		}
		
		
		output += `</ul>`;
		
		$(".commentPagination").html(output);
	}
	
	function modifyComment(commentNo){
		alert("수정 기능");
		$(".commentContent").html("<input");
	}
	
	function removeComment(commentNo){
		alert("삭제 기능");
		
	}
	
	function displayAllComments(json){
			let output ='<ul class="list-group">';
			
			if(json.length >0){
				$.each(json,function(i,e){
					output += `<li class="list-group-item">`;
					output += `<div>\${e.content}<div>`;
					output += `<div><span>\${e.commenter}</span>`;
					let elapsedTime = processPostDate(e.regDate);
					console.log("elapseTime :" + elapseTime);
					output += `<span>\${elapseTime}</span></div>`;
					output += `</li>`;
				});
			}
			output += `</ul>`;
			$(".commentList").html(output);
	}
	
	function processPostDate(postDate){
		//댓글 작성일시 방금전, 몇분 전, 몇시간 전 .... 의 형식으로 출력
// 		let time = (Date.now() - regDate)/1000;
// 		console.log("time by min : " + time/60);
// 		let timeStr = "";
// 		if(time < 60){
// 			timeStr = "방금 전";
// 		}
// 		if(time / 60 >= 1 && time / 60 < 60){
// 			timeStr = Math.floor(time/60) + "분 전";
// 		}
// 		if(time / (60 * 60) >= 1 && time / (60 * 60) < 60 ){
// 		  timeStr = Math.floor(time/(60*60)) + "시간 전";
// 		}
// 		if(time / (60 * 60 * 24) >= 1 && time / (60 *60 * 24) < 7){
// 			timeStr = Math.floor(time / (60 * 60 * 24)) + "일 전";
// 		}
// 		if(time / (60 * 60 * 24) >= 7){
// 			timeStr = Math.floor(time / (60 * 60 * 24)) +"주 전";
// 		}
		const regDate = new Date(postDate); // 댓글 작성 시간
		const now = new Date(); //현재 시간
		
		let diff = (now - regDate) / 1000;
		
		const times =[
			{name : "일", time : 24 * 60 * 60},
			{name : "시간", time : 60 * 60},
			{name : "분", time : 60} 
		];
		
		for(let val of times){
			let elapsedTime = Math.floor(diff / val.time);
			console.log(diff, elapsedTime);
			
			if(elapsedTime > 0  && val.name  != '일'){
				//하루보다 크지 않다
				return elapsedTime + val.name + "전";
			} else if(elapsedTime >0 && val.name == '일'){
				//하루가 지남
				return regDate.toLocaleString();
			}
		}
		return "방금 전";
	}
	
	function showRemoveModal(){
		let boardNo = $("#boardNo").val();
		$(".modal-body").html("정말 " + boardNo + "번 글을 삭제하시겠습니까?");
		$("#myModal").show(500);
	}
	
	function saveComment(){
		// 댓글 저장
		let boardNo = $("#boardNo").val();
		let content = $("#commentContent").val();
// 		let commenter = '${loginMember.userId}';// 자바스크립트에서 session객체 받아올때 작은따옴표 써야함
		let commenter = preAuth();
		
		const newComment = {
				'boardNo' : boardNo,
				'content' : content,
				'commenter' : commenter,
		}
		
		if(content.length < 1){
			alert("댓글 내용을 입력하세요");
			return;
		}else if(content.length >= 1 && commenter != null){
			$.ajax({
			    url: '/comment/' + boardNo  , // 데이터가 송수신될 서버의 주소
			    type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
				data : JSON.stringify(newComment), // 보내는 데이터
				headers : {
					"Content-Type" : "application/json"
				}, // 송신할 데이터가 json임을 백엔드에 알려줌
			    dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
			    success: function (data) {
				    console.log(data);
				    if(data.msg == 'success'){
				    	$("#commentContent").val(''); // 댓글 입력창 비우기
					    getAllComments(1);
				    }
			    },
			    error: function () {},
			    
			    complete: function () {},
			  });
		}
	}
	
	function preAuth(){
		let commenter = '${loginMember.userId}';
		if(commenter == ''){// 로그인을 안했다 --> 로그인 페이지로 이동
			location.href ='/member/login?redirectUrl=viewBoard&boardNo=${param.boardNo}';
		}else{
			return '${loginMember.userId}';
		}
		
	}
	
	function showLikeUserList(){
		alert("show");
	}
</script>
<style type="text/css">
	i{
		width : 25px;
		height : 25px;
	}
</style>
</head>
<body>
<jsp:include page="./../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시글 조회</h1>
			<div class="input-group mb-3">
  				<span class="input-group-text">글 번호</span>
  				<input type="text" class="form-control"  id="boardNo" readonly value='${boardDetailInfo.boardNo}'/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">글 제목</span>
  				<input type="text" class="form-control" name="title" id="title" value='${boardDetailInfo.title}' readonly/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">작성자(이메일)</span>
  				<input type="text" class="form-control" name="writer" value='${boardDetailInfo.writer}(${boardDetailInfo.email})' readonly/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">작성일</span>
  				<input type="text" class="form-control" name="postDate" value='${boardDetailInfo.postDate}' readonly/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">조회수</span>
  				<input type="text" class="form-control" name="readCount" value='${boardDetailInfo.readCount}' readonly/>
			</div>

			<a onclick="showLikeUserList();">좋아요 ${boardDetailInfo.likecount}개</a>
			<div>${peopleWhoLike.size()}</div>
<!-- 			이글을 A님 B님 C님 외 N명이 좋아합니다 -->
			<div class="mb-3 mt-3">
				이 글을 
				<span>
					<c:if test="${not empty  peopleWhoLike}">
						<c:if test="${peopleWhoLike.size() le 3}">
							<c:forEach var="who" items='${peopleWhoLike }' varStatus="status" >
								<c:if test="${status.first }">${who }님</c:if>
								<c:if test="${not status.first}">, ${who}님</c:if>
							</c:forEach>이 좋아합니다.
						</c:if>
						<c:if test="${peopleWhoLike.size() ge 4}">
							<c:forEach var="who" items='${peopleWhoLike}' begin="1" end="3">${who}님</c:forEach>
							외 <span>${peopleWhoLike.size() - 3}</span>명이 좋아합니다.
						</c:if>
					</c:if>
				</span>
			</div>
<!-- 				boardNo번 글을 좋아요한 로그인한 유저인 경우, solid 하트로 보여주기 -->
			<div>
				<c:set var='hasHeart' value='false'></c:set>
				<c:forEach var="who" items="${peopleWhoLike}">
					<c:if test="${who == loginMember.userId}">
						<i class="fa-solid fa-heart" id="like"></i>
						<c:set var='hasHeart' value='true'></c:set>
					</c:if>
				
				</c:forEach>
				<c:if test="${hasHeart == false }">
					<i class="fa-regular fa-heart" id="dislike"></i>
				</c:if>
			</div>
		
			
			<div class="mb-3">
			<label for="comment">내용:</label>
			<div class="form-control" id="content" >${boardDetailInfo.content}</div>
			</div>
			<button type="button" class="btn btn-primary" onclick="location.href='/cboard/modifyBoard?boardNo=${boardDetailInfo.boardNo}'">수정</button>
			<button type="button" class="btn btn-warning" onclick="showRemoveModal();">삭제</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/cboard/listAll';">목록보기</button>
			
			<div class="commnetInputArea">
				<input type="text" class="form-control" id="commentContent" placeholder="댓글을 입력하세요" />
				<img alt="" src="/resources/images/comment.png" onclick="saveComment();"/>
			</div>
			
			<div class ="commentList">
			</div>
			<div class="commentPagination"></div>
	</div>
<jsp:include page="./../footer.jsp"></jsp:include>

		<!-- The Modal -->
<div class="modal" id="myModal" >
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close modalCloseBtn" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-info modalCloseBtn" data-bs-dismiss="modal" onclick="location.href='/cboard/removeBoard?boardNo=${param.boardNo}'">삭제</button>
        <button type="button" class="btn btn-danger modalCloseBtn" data-bs-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>
</body>
</body>
</html>