<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>게시글 조회</title>
<script type="text/javascript">
	$(function(){
		$(".modalCloseBtn").click(function(){
			$("#myModal").hide();
		
		})
		
	});
		

	function showRemoveModal() {
		let boardNo =$("boardNo").val();
		$(".modal-body").html("정말"+boardNo+"번 글을 삭제하시겠습니까?");
		$("#myModal").show(500);
	}
</script>
</head>
<body>
<jsp:include page="./../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시글 조회</h1>
		<c:forEach var="boardDetailInfo" items='${boardDetailInfo}'>
			<div class="input-group mb-3">
  				<span class="input-group-text">글 번호</span>
  				<input type="text" class="form-control" name="number" id="boardNo" readonly value='${boardDetailInfo.boardNo}'/>
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
			<div class="input-group mb-3">
  				<span class="input-group-text">조회수</span>
  				<input type="text" class="content" name="content" value='${boardDetailInfo.readCount}' readonly/>
			</div>
		
			
			<div class="mb-3">
			<label for="comment">내용:</label>
			<textarea class="form-control" rows="5" id="content" name="content"  readonly>${boardDetailInfo.content}</textarea>
			</div>
	
			

			
			<div class ="preview">
			<c:forEach var="file" items='${boardDetailInfo.fileList}'>
				<c:choose>
					<c:when test = '${file.thumbFileName != null}'>
						<div><img src ='/resources/boardUpFiles${file.thumbFileName}'/></div>
<%-- 						<p>${file.originFileName}</p> --%>
						
<!-- 						아무 파일도 첨부하지 않은 경우 처리 -->
					</c:when>
					<c:when test="${empty file.newFileName }">
						<div></div>
					</c:when>
					<c:otherwise>
					<div> 
						<a href='/resources/boardUpFiles${file.originFileName}'>
						<img src ='/resources/images/noImg.jpg'/>
						${file.originFileName}</a></div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</div>
			<button type="button" class="btn btn-info" onclick="location.href='/hboard/replyBoard?boardNo=${boardDetailInfo.boardNo }&ref=${boardDetailInfo.ref}&step=${boardDetailInfo.step}&refOrder=${boardDetailInfo.refOrder}';">답글달기</button>
			<button type="button" class="btn btn-info" onclick="location.href='/hboard/modifyBoard?boardNo=${boardDetailInfo.boardNo }';">수정</button>
			<button type="button" class="btn btn-warning" onclick="showRemoveModal();">삭제</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/hboard/listAll';">목록보기</button>
		</c:forEach>
	</div>
	
	
	<!-- The Modal -->
<div class="modal" id="myModal">
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
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="location.href='/hboard/removeBoard?boardNo=${param.boardNo }'">삭제</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>
	
	
	
<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>