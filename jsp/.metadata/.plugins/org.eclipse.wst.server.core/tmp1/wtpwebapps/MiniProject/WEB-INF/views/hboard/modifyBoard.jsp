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
<title>게시글 수정</title>
<script type="text/javascript">
	$(function(){
	});
	
	function removeFileCheckBx(fileId){
		//체크박스를 클릭할 때 호출되는 함수
		console.log(fileId);
		let chkCount = countCheckBoxChecked();
		if(chkCount > 0){
			$(".removeUpFileBtn").removeAttr("disabled");
			$(".removeUpFileBtn").val(chkCount +"개 파일을 삭제합니다");
		}else if(chkCount == 0){
			$(".removeUpFileBtn").attr("disabled", true);
			$(".removeUpFileBtn").val("선택된 파일이 없습니다");
			
			
		}
		
	}
	function countCheckBoxChecked(){
		//체크된 체크박스 갯수
		let result = 0;
		$(".fileCheck").each(function(i,item){
// 			console.log($(item).is(":checked")); //true
			if($(item).is(":checked")){
				result++;
			}
		});
		
		console.log("체크 갯수 : " + result);
		return result;
	}
	
	function removeFile(){
		//비활성화해 놓은 [선택된 파일 삭제]버튼 클릭시 호출
		let removeFileArr = [];
		$(".fileCheck").each(function(i,item){
			if($(item).is(":checked")){ // 파일 삭제하려고 체크박스를 체크했다면
				let tmp = $(item).attr('id'); // 선택된 파일의 id값을 얻어옴 (pk)
				removeFileArr.push(tmp); // 배열에 저장
			}
		});
		
		console.log("삭제될 파일 : " + removeFileArr);
		
		$.each(removeFileArr,function(i,item){
			$.ajax({
				url: "/hboard/modifyRemoveFileCheck",
				type : "POST",
				dataType : "json",
				data :{
					"removeFileNo" : item
				},
				async :false, // 동기 통신방식 
				success: function(data){
					console.log(data);
					if(data.msg == 'success'){
						$("#"+item).parent().parent().css('opacity', 0.2);
					}
				},
				error : function (){},
				complete : function() {}, 
			});
		});
	}
	
	function cancelRemFiles(){
		//파일삭제 취소 버튼 시 호출
		$.ajax({
			url: "/hboard/cancelRemFiles",
			type : "POST",
			dataType : "json",
			async :false, // 동기 통신방식 
			success: function(data){
				console.log(data);
				if(data.msg == 'success'){
					$(".fileCheck").each(function(i,item){
						$(item).prop("checked", false); // 체크박스가 체크되지 않은 상태로 바꿈						
						$(item).parent().parent().css('opacity', 1);
					});
					
					$(".removeUpFileBtn").attr('disabled', true); // 선택파일삭제버튼 비활성화
					$(".removeUpFileBtn").val("선택된 파일이 없습니다"); 
				}
			},
			error : function (){},
			complete : function() {}, 
		});
	}
	
	//파일 추가
	function addRows(obj){
		let rowCnt = $('.fileListTable tr').length;
		console.log('tr갯수 : ' + rowCnt);
		let row = $(obj).parent().parent();
		let inputFileTag = `<tr><td colspan = '2'>
		<input type ='file' class='form-control' id='newFile_\${rowCnt}' name="modifyNewFile"
		 onchange='showPreview(this);'/></td>
		<td><input type='button' class='btn btn-danger' value='파일저장취소' onclick='cancelAddFile(this)'</td></tr>`;
		
		$(inputFileTag).insertBefore(row);
	}
	
	function showPreview(obj){
		console.log(obj.files);
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
		} else { // 이미지 파일이 아니라면
			let imgTag = `<div style='padding: 6px;'><img src ='/resources/images/noImg.jpg' width='50px'/><span>\${fileName}</span></div>`;
			$(imgTag).insertAfter(obj);
		}
	}
	
	function cancelAddFile(obj){
		let fileTag = $(obj).parent().prev().children().eq(0); // input type=file 태그
		$(fileTag).val('');
		$(fileTag).parent().parent().remove();
	}
	
</script>
<style>
	.fileBtns{
		display : flex;
		justify-content : flex-end;
	}
	
</style>
</head>
<body>
<jsp:include page="./../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시글 수정</h1>
		<c:forEach var="boardDetailInfo" items='${boardDetailInfo}'>
		<form action ="/hboard/modifyBoardSave" method ="post" enctype="multipart/form-data">
			<div class="input-group mb-3">
  				<span class="input-group-text">글 번호</span>
  				<input type="text" class="form-control"  id="boardNo" name="boardNo" readonly value='${boardDetailInfo.boardNo}'/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">글 제목</span>
  				<input type="text" class="form-control" name="title" id="title" name="title" value='${boardDetailInfo.title}' />
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">작성자(이메일)</span>
  				<input type="text" class="form-control" id="writer" name="writer" value='${boardDetailInfo.writer}' readonly/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">작성일</span>
  				<input type="text" class="form-control" id ="postDate" value='${boardDetailInfo.postDate}' readonly/>
			</div>
			<div class="input-group mb-3">
  				<span class="input-group-text">조회수</span>
  				<input type="text" class="form-control" id ="readCount" value='${boardDetailInfo.readCount}' readonly/>
			</div>
		
			
			<div class="mb-3">
			<label for="comment">내용:</label>
			<textarea class="form-control" rows="5" id="content" name="content" >${boardDetailInfo.content}</textarea>
			</div>
	
			

			
			<div class ="fileList">
				 <table class="table table-hover fileListTable">
				    <thead>
				      <tr>
				        <th>#</th>
				        <th>uploadedFiles</th>
				        <th>fileName</th>
				      </tr>
				    </thead>
				    <tbody>
				    	<c:forEach var="file" items="${boardDetailInfo.fileList}">
				    		<c:if test="${file.boardUpFileNo != '0'}">
				    			<tr>
				    				<td>
				    					 <input type="checkbox" class="form-check-input fileCheck" id="${file.boardUpFileNo}"
				    					 onclick="removeFileCheckBx(this.id);">
				    				</td>
				    				<td>
				    					<c:choose>
				    					<c:when test="${file.thumbFileName != null}">
				    						<img src ='/resources/boardUpFiles${file.thumbFileName}'/>
				    					</c:when>
				    						<c:when test="${file.thumbFileName == null}">
				    							<a href='/resources/boardUpFiles${file.newFileName}'>
												<img src ='/resources/images/noImg.jpg'/>${file.newFileName}</a>
				    						</c:when>
				    					</c:choose>
				    				</td>
				    				<td>
				    					${file.originFileName }
				    				</td>
				    			</tr>
				    		</c:if>
				    	</c:forEach>
				    	<tr>
				    		<td colspan ="3" style="text-align: center;">
				    			<img alt="" src="/resources/images/add.png" onclick="addRows(this)"/>
				    		</td>
				    	</tr>
				    </tbody>
				 </table>
				 <div class="fileBtns">
				 	<input type="button" class="btn btn-danger removeUpFileBtn" disabled value="선택한 파일 삭제" onclick="removeFile();"/>
				 	<input type="button" class="btn btn-secondary cancelRemove"  value="파일 삭제 취소" onclick="cancelRemFiles();"/>
				 </div>
			</div>
			
			<div>
			<button type="submit" class="btn btn-primary" > 저장</button>
			<button type="button" class="btn btn-warning" onclick="location.href='/hboard/viewBoard?boardNo=${boardDetailInfo.boardNo}'">취소</button>
			</div>
			</form>
		</c:forEach>
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
        <button type="button" class="btn btn-info modalCloseBtn" data-bs-dismiss="modal" onclick="location.href='/hboard/removeBoard?boardNo=${param.boardNo}'">삭제</button>
        <button type="button" class="btn btn-danger modalCloseBtn" data-bs-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>
</body>
</body>
</html>