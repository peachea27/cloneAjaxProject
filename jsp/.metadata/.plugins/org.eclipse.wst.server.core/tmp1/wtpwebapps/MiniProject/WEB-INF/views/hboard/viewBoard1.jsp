<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
<title>게시글 조회</title>
<script type="text/javascript">
	
</script>
</head>
<body>
<jsp:include page="./../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시글 조회</h1>

			<div class="input-group mb-3">
  				<span class="input-group-text">글 번호</span>
  				<input type="text" class="form-control" name="number" id="number" readonly value='${board.boardNo}'/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">글 제목</span>
  				<input type="text" class="form-control" name="title" id="title" value='${board.title}' readonly/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">작성자</span>
  				<input type="text" class="form-control" name="writer" value='${board.writer}' readonly/>
			</div>
			
			<div class="mb-3">
			<label for="comment">내용:</label>
			<textarea class="form-control" rows="5" id="content" name="content"  readonly>${board.content}</textarea>
			</div>
	
			

			
			<div class ="preview">
			<c:forEach var="file" items='${fileList}'>
				<c:choose>
					<c:when test = '${file.thumbFileName != null}'>
						<div>
							<img src ='/resources/boardUpFiles${file.thumbFileName}'/>
						<p>${file.originFileName}</p>
						</div>
					</c:when>
					<c:otherwise>
						
					<div> 
						<img src ='/resources/images/noImg.jpg'/>
						<p>${file.originFileName}</p>
					</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
<%-- 				<c:forEach var="file" items='${fileList}'> --%>
<%-- 				<c:choose> --%>
<%-- 				<c:when test='${file.ext} =="png" '> --%>
<!-- 						<div> -->
<%-- 							<img src ='/resources/boardUpFiles${file.newFileName}'/> --%>
<%-- 							<p>${file.newFileName}</p> --%>
<!-- 						</div> -->
<%-- 				</c:when> --%>
<%-- 				<c:when test='${file.ext} == "jpeg" '> --%>
<!-- 						<div> -->
<%-- 							<img src ='/resources/boardUpFiles${file.newFileName}'/> --%>
<%-- 							<p>${file.newFileName}</p> --%>
<!-- 						</div> -->
<%-- 				</c:when> --%>
<%-- 				<c:when test='${file.ext} == "gif" '> --%>
<!-- 						<div> -->
<%-- 							<img src ='/resources/boardUpFiles${file.newFileName}'/> --%>
<%-- 							<p>${file.newFileName}</p> --%>
<!-- 						</div> -->
<%-- 				</c:when> --%>
<%-- 					<c:otherwise> --%>
<!-- 					<div> -->
<!-- 						<img src ='/resources/images/noImg.jpg'/> -->
<%-- 							<h2>${file.ext}</h2> --%>
<%-- 						<p>${file.newFileName}</p> --%>
<!-- 					</div> -->
<%-- 					</c:otherwise> --%>
<%-- 					</c:choose> --%>
<%-- 				</c:forEach> --%>
			</div>
			
			<button type="button" class="btn btn-primary" onclick="">수정</button>
			<button type="button" class="btn btn-primary" onclick="">삭제</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/hboard/listAll';">목록보기</button>
	</div>
<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</body>
</html>