<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
  
<title>게시판 목록</title>

<script>
	$(function(){
		timediffPostDate();
		testAjax(1,20);
		// pagingSize
		// 유저가 페이징 사이즈를 선택하면
		$(".pagingSize").change(function(){
	
			//pagingSize
			let pagingSize = '{param.pagingSize}';
			if(pagingSize == ''){
				pagingSize = 10;
			}else{
				pagingSize = parseInt(pagingSize);
			}
			
			let pageNo = '${param.pageNo}';
			console.log("pageNo : " + pageNo);
			if(pageNo == ''){
				pageNo = 1;
			}else{
				pageNo = parseInt(pageNo);
			}
			location.href = '/hboard/listAll?pagingSize=' + $(this).val() + "&pageNo=" + pageNo;
		})
		
		showModal();
		$(".modalCloseBtn").click(function(){
			$("#myModal").hide(); // 모달창 닫기
		});
		
	});
	

	
	function showModal(){
		let status = '${param.status}'; // url 주소창에서 status쿼리스트링의 값을 가져와 변수 저장
		
		if(status == 'success'){
			//글 저장성공 모달창
			$(".modal-body").html('<h5>글 저장에 성공하였습니다.</h5>');
			$("#myModal").show();
		}else if(status == 'fail'){
			$(".modal-body").html('<h5>글 저장에 실패하였습니다.</h5');
			$("#myModal").show();
		}else if(status == 'removeSuccess'){
			$(".modal-body").html('<h5>글 삭제에 성공하였습니다.</h5>');
			$("#myModal").show();
		}else if(status == 'removeFail'){
			$(".modal-body").html('<h5>글 삭제에 성공하였습니다.</h5>');
			$("#myModal").show();
			
		}
		//게시글을 불러 올 떄 예외가 발생한 경우 
		let except = '${exception}';
		if(except == 'error'){
			$(".modal-body").html('<h2>문제가 발생해 데이터를 불러오지 못했습니다.</h2>');
			$("#myModal").show();
		}
	}
	
	//게시글의 글작성일을 얻어와서 2시간 이내에 작성한 글이면 new.png 이미지를 제목 옆에 출력한다.
	function timediffPostDate(){
		$(".postDate").each(function(i,e){
			console.log(i + "번째 : " + $(e).html());
			
			let postDate = new Date($(e).html()); //글 작성일 저장 (Date객체로 변환)
			let curDate = new Date(); // 현재 날짜 시간 객체 생성
			
			let diff = (curDate - postDate) / 1000 / 60 /60; // 시간단위
			let title = $(e).prev().prev().html();
			
			if(diff < 3){ // 2시간 이내에 작성한 글이라면
				let output = "<span><img src='/resources/images/new.png' width='25px;'/></span>";
				$(e).prev().prev().html(title + output);				
			}
		});		
	}
	
// 	function choosePagingSizeOption(pageNo){
// 		let pagingSize = $(".form-select").val();
// 		let url = "/hboard/listAll?pageNo="+pageNo+"&pagingSize=" + pagingSize;
// 		location.href = url;
// 	}
	
</script>
</head>
<body>
<jsp:include page="./../header.jsp"></jsp:include>
	<div class="container">
	<h1>계층형 게시판 전체 목록</h1>

	<div class="boardControl">
<%-- 	onchange="choosePagingSizeOption(${pagingInfo.pageNo}) --%>
		<select class="form-select pagingSize" id="pagingSize" >
		  <option value=""></option>
		  <option value="10">10개씩 보기</option>
		  <option value="20">20개씩 보기</option>
		  <option value="40">40개씩 보기</option>
		  <option value="80">80개씩 보기</option>
		</select>	
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items='${boardList}'>
			<c:choose>
				<c:when test="${board.isDelete == 'N'}">
				
				<tr onclick="location.href='/hboard/viewBoard?boardNo=${board.boardNo}';">
					<td>${board.boardNo}</td>
					<c:choose>
						<c:when test="${board.step == 0}">
							<td>${board.title}</td>
						</c:when>
						<c:otherwise>
							<td>
								<c:forEach var="k" begin="2" end="${board.step}">
									&nbsp;&nbsp;&nbsp;
								</c:forEach>	
								<img src='/resources/images/arrow.png'/>RE :${board.title}
							</td>
						</c:otherwise>
					</c:choose>
					<td>${board.writer}</td>
					<td class="postDate">${board.postDate}</td>
					<td>${board.readCount}</td>
				</tr>
				</c:when>
				<c:when test="${board.isDelete == 'Y'}">
					<tr>
						<td>${board.boardNo}</td>
						<td colspan="4" style="color : gray;">삭제된 글입니다.</td>
					</tr>
				</c:when>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
		<div><button type="button" class="btn btn-success" onclick="location.href='/hboard/saveBoard';">글쓰기</button></div>
		
<!-- 		검색어 -->
	<form action="/hboard/listAll" method = "post">
		<div class="input-group mb-3">
		<select class="form-select" id="searchType" name ="searchType" >
		  <option value="">--검색타입--</option>
		  <option value="title">제목</option>
		  <option value="writer">작성자</option>
		  <option value="content">내용</option>
		</select>
  			<input type="text" class="form-control" placeholder="검색어를 입력하세요..." id="searchWord" name="searchWord">
  			<button class="btn btn-success" type="submit">검색</button>
		</div>
		<div>${boardList }</div>	
	</form>
		
<!-- 		페이지 네이션 -->
		<div>
		${pagingInfo}
		</div>
		<div>${search }</div>
		<div class ="paging">
			<ul class="pagination justify-content-center">
				<c:if test ='${pagingInfo.pageNo == 1 }'>
			    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
				</c:if>
				<c:if test = '${pagingInfo.pageNo > 1 }'>
			    <li class="page-item"><a class="page-link" href="/hboard/listAll?pageNo=${pagingInfo.pageNo - 1}&pagingSize=${param.pagingSize}&searchType=${search.searchType}&searchWord=${search.searchWord}">Previous</a></li>
			    </c:if>
			    <c:forEach var = "i" begin ='${pagingInfo.startPageNoCurBlock}' end='${pagingInfo.endPageNoCurBlock }'>
				    <li class="page-item"><a class="page-link" href="/hboard/listAll?pageNo=${i}&pagingSize=${param.pagingSize}">${i}</a></li>
			    </c:forEach>
			    <c:if test="${pagingInfo.pageNo < pagingInfo.totalPageCnt}">
			    <li class="page-item"><a class="page-link" href="/hboard/listAll?pageNo=${pagingInfo.pageNo + 1}&pagingSize=${param.pagingSize}&searchType=${search.searchType}&searchWord=${search.searchWord}">Next</a></li>
			    </c:if>
			    <c:if test="${pagingInfo.pageNo== pagingInfo.totalPageCnt}">
			    <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
			    </c:if>
  			</ul>
		</div>
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
        <button type="button" class="btn btn-danger modalCloseBtn" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
		
	</div>
	<div>
		<img src="data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAEy0lEQVR4Xu1YW2xUVRStxuCHPyq+6GNmKqQqVT5A+qAzd6YPpBQk0gopIH5QgxETIWAUfgzaBCIN1iiJiQ/4EDUiPxZBYjVqRA0gJK0aKjbaJhoVFGmB9p5zH8u9z5npzNw6naE/DMldycrNnDmPvc7eZ+9zb0GBDx8+fPjw4cOHDx+XAxk02kQguk8EjYPEj64oQ0aXCBjbR2ZUFnvtzIhLwcg0EYx8ZwejIDF5Q0s/L9jByCIUFFzjtTsNKC+fQp33IhQD7UTeMb65o1Yg1uC1PQ0orQs6Ie0J7yT5wriY8/Rc6LV/DFYosgClteMG5yNJzF8UbvO8GhSoQ/PVIsQiz4hgtM+8M1zm1TGxkEAEYlq1fo61GeltJWGIwnnjyf8X0bM4nBxbQm13VKXPV1yj+3nXzsD4WT4xUmiU5CaEDJazmmA9uRWirCHZPqMe1tPbIcvmkwE1kDXLIVdthHwkneLehZCrN0HWrtKGs4jZS2A//wpEeWO8LQzZ8KjuzxvitSED3RB7xvhxuCx2S3Yht1fB3ncIDPuZFyFKY3rh5U8BQsB+docS6B7rUX3gukk6Dux3uuB8exLONydprkpF5/CXqquz/zDErRXEuXAHfoNzrBdiZuN4GyamS7XmKHnoxomF3EYLdx/RNl4cgaxepj2wYgNgkpDnXla77n5/Gu4fZyArmiFjK8coptfC6fpMjedx4v6H4P48QD8k3P5B7eW75mthH36qQ8xrQxayZ2Qw+hIKYtdlFsI7+MlXAImAbcM92qPa5Ir1cSGdFCJxIYO/w7zhPpgk3qQ+5s1zaCMqYO94XRkqlzwO2bIOsCzYr70LXKKNaWqD1bZF/W+/8Ko+d14bsjBeMiSooGcRcgTuqX44b7yvF9z5Fhm1Nl1IzykVSu6/QwDz/DDw51mIyhZYrSRakvE7d6tzxeMSXrDWt8Pes195SD64dlIeYVIdhBkIN2QX0j8AMWsRHDaYDLXadwGjZlJIbx8wdAF25x44u94m7oXd8Sbk9DoV9zzG7emD894BNR/P7R7vgb37AxViLFwd9NRMdhlkIaOBSH0OQgYh5y6FpB3GyChw9h/tndTQGqDQuv4eCA4p5tQ5OkvdNBvuiR90Avj7HOzNHWpumzfj3JDypNP9tR7jXT8HqtAKGBbfFScW0h0XUtWiXG9taFcitJDEYf8JLoWSrF8NufixMYqZC1RmSpwTDisVQmwAh2ccFmdEri3e9XMgH3YzYHQilu2wH/wc7ulfIcgjqo2MYy8pAzZtU/HuHu/VFqWlXxfOx1+onZZGq/6bwktS5uJ5OMO5fb+odpmoKd71szPH9EuTy0gr5JrNyYW4jpAx1pYOlV7ZS6oPF0Eufgny76qH9TjKRpKyk2xelzzQPPfSJ2Ct3DipQ54oiLi7Ymr2gsjk6wVfN1Lb+GCmXjMSfbxMrdSF1bqWpM7Dv71z50C+oki+ohTF0l+4xERC8oyJSyP+79JohsKNnMK8g/KN8bfGMxmv8aOhWCjfX6wc5Qlj2A4aTV77x4DyZVPEVfCqa5YaD3htHwf98SGahx8flCcumoHYYhRsvdZrd0bQ4DVUYPhz0CGhPwldQUYOiEB020hxXZHXTh8+fPjw4cOHDx8+JoX/AFz0k1hwmuItAAAAAElFTkSuQmCC
		"/>
	</div>
<jsp:include page="./../footer.jsp"></jsp:include>

<script type="text/javascript">
function testAjax(pageNo, pagingSize){
	$.ajax({
		url: "/hboard/listAllAjax",
		type : "GET",
		dataType : "json",
		data: {
			pageNo : pageNo,
			pagingSize : pagingSize
		},
		async :false, // 동기 통신방식 
		success: function(data){
			console.log(data);
		},
		error : function (){},
		complete : function() {}, 
	});
}
</script>
</body>
</html>