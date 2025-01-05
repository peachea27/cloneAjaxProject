<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	let empData = null;
	let jobsData = null;
	let deptsData = null;
	
$(document).ready(function(){
	getAllEmployees();
	getJobsData();
	getDeptInfo();
	
	$(".writeIcon").click(function(){
		$("#writeJobId").html(makeJobSelection());
		$("#writeManager").html(makeManagerSelection());
		$("#writeDepartment").html(makeDeptSelection());
		
		$("#writeModal").show();
	});
	
	// 직급 정보 입력시 (사원 저장)
	$("#writeJobId").change(function(){
		console.log($(this).val());
		
		if ($(this).val() != '') {
			let selectedJobId = $("#writeJobId option:selected").val();
// 			console.log(selectedJobId);
			makeSalInput(selectedJobId, "write");
		}
	});
	
	// 사원 저장 버튼 클릭시
	$(".writeBtn").click(function () {
		let writeFirstName = $("#writeFirstName").val();
		let writeLastName = $("#writeLastName").val();
		let writeEmail = $("#writeEmail").val();
		let writePhoneNumber = $("#writePhoneNumber").val();
		let writeHireDate = $("#wirteHireDate").val();
		let writeJobId = $("#writeJobId").val();
		let writeSalary = $("#writeSalary").val();
		let writeComm = $("#writeComm").val();
		let writeManager = $("#writeManager").val();
		let writeDepartment = $("#writeDepartment").val();
		
		let tmpEmp = {
				firstName : writeFirstName,
				lastName : writeLastName,
				email : writeEmail,
				phoneNumber : writePhoneNumber,
				hireDate : writeHireDate,
				jobId : writeJobId,
				salary : writeSalary,
				comm : writeComm,
				managerId : writeManager,
				departmentId : writeDepartment
		};
		
		console.log(tmpEmp);
		
		inputEmpValidate(tmpEmp);
		
	});
	
	// -----------------------------------------------------------------------
	// 직급 정보 입력시 (사원 수정)
	$("#modifyJobId").change(function(){
// 		console.log($(this).val());
		
		if ($(this).val() != '') {
			let selectedJobId = $("#modifyJobId option:selected").val();
// 			console.log(selectedJobId);
			makeSalInput(selectedJobId, "modify");
		}
	});
	
	// 사원 수정버튼 클릭시
	$(".modifyBtn").click(function(){
		// 입력값 읽어오기
		let empNo = $("#modifyEmployeeId").val();
		let modifyFirstName = $("#modifyFirstName").val();
		let modifyLastName = $("#modifyLastName").val();
		let modifyEmail = $("#modifyEmail").val();
		let modifyPhoneNumber = $("#modifyPhoneNumber").val();
		let modifyHireDate = $("#modifyHireDate").val();
		let modifyJobId = $("#modifyJobId").val();
		let modifySalary = $("#modifySalary").val();
		let modifyComm = $("#modifyComm").val();
		let modifyManager = $("#modifyManager").val();
		let modifyDepartment = $("#modifyDepartment").val();
		
		
		// 읽어온 값을 객체로 만들기
		let tmpEmp = {
				employeeId : empNo,
				firstName : modifyFirstName,
				lastName : modifyLastName,
				email : modifyEmail,
				phoneNumber : modifyPhoneNumber,
				hireDate : modifyHireDate,
				jobId : modifyJobId,
				salary : modifySalary,
				comm : modifyComm,
				managerId : modifyManager,
				departmentId : modifyDepartment
		};
		
		console.log(tmpEmp);
		
		// 컨트롤러로 요청-응답받기
		let url = "modifyEmp.do";
	    $.ajax({
	        url: url, // 데이터가 송수신될 서버의 주소
	        type: "POST", // 통신 방식 (GET, POST, PUT, DELETE)
	    	data: tmpEmp, // 데이터 보내기
	        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
	        success: function (data) { // 통신이 성공하면 수행할 함수
		        console.log(data);
	        
	        	if (data.status == "fail-modify") {
	        		alert("수정 실패");
	        	} else if (data.status == "success-modify") {
	        		alert("수정 성공");
	        	} else if (data.status == "fail") {
	        		alert("예외 발생");
	        	}
	        	
	        	$("#modifyModal").hide();
	        	getAllEmployees(); 

	        	// location.reload(); // 페이지 새로고침
	        },
	        error: function () {},
	        complete: function () {},
	      });
		
		
		
		
	});
	
	// 사원 삭제버튼 클릭시
	$(".deleteBtn").click(function(){
		let empNo = $("#delEmpNo").text();
		console.log(empNo);
		
		let url = "removeEmp.do";
	    $.ajax({
	        url: url, // 데이터가 송수신될 서버의 주소
	        type: "get", // 통신 방식 (GET, POST, PUT, DELETE)
	    	data: {"empNo" : empNo}, // 데이터 보내기
	        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
	        success: function (data) { // 통신이 성공하면 수행할 함수
		        console.log(data);
	        
	        	if (data.status == "fail") {
	        		alert("삭제 실패");
	        	} else if (data.status == "success") {
	        		alert("삭제 성공");
	        	}
	        	
	        	$("#deleteModal").hide();
	        	getAllEmployees(); 

	        	// location.reload(); // 페이지 새로고침
	        },
	        error: function () {},
	        complete: function () {},
	      });
		
	});
	
	// 이름으로 사원 검색하기 (엔터키를 치면 검색)
	$("#findEmpName").keyup(function(e){
		if (e.keyCode == 13) { // 엔터를 눌렀을 때
			 // 검색어 가져오기
// 				alert($(this).val());
			let searchName = $(this).val().toLowerCase();
			 console.log(searchName);
			 
			 // 검색 요청-응답받기
			$.ajax({
		        url: "findEmpByName.do", // 데이터가 송수신될 서버의 주소
		        type: "get", // 통신 방식 (GET, POST, PUT, DELETE)
		    	data: {"searchName" : searchName}, // 데이터 보내기
		        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
		        success: function (data) { // 통신이 성공하면 수행할 함수
			        console.log(data);
			        outputEntireEmployees(data);
		        },
		        error: function () {},
		        complete: function () {},
		      });
		}
	});
	
	
	// 정렬 방식 변경
	$(".orderMethod").click(function(){
		// 선택된 정렬 방식 읽어오기
// 		alert($(this).val());
		let orderMethod = $(this).val();
		
		$.ajax({
	        url: "orderByEmp.do", // 데이터가 송수신될 서버의 주소
	        type: "get", // 통신 방식 (GET, POST, PUT, DELETE)
	    	data: {"orderMethod" : orderMethod}, // 데이터 보내기
	        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
	        success: function (data) { // 통신이 성공하면 수행할 함수
		        console.log(data);
		        outputEntireEmployees(data);
	        },
	        error: function () {},
	        complete: function () {},
	      });
		
		
		
	});

	
	// 모달 닫기
	$(".closeModal").click(function(){
		$("#writeModal").hide();
		$("#modifyModal").hide();
		$("#deleteModal").hide();
	});
	
});

function inputEmpValidate(tmpEmp) {
	// 사원 저장시 유효성 검사
	// not null? (필수 항목) - last_name, hire_date
	// email : not null & unique
	// 바인딩한 정보가 선택이 되어있는지?
	let isLastNameValid = checkNameValid(tmpEmp.lastName);
	let isHireDateValid = checkHireDateValid(tmpEmp.hireDate);
	let isEmailValid = checkEmailValid(tmpEmp.email);
	let isJobIdValid = checkJobIdValid(tmpEmp.jobId);
	let isManagerIdValid = checkManagerIdValid(tmpEmp.managerId);
	let isDepartmentIdValid = checkDepartmentIdValid(tmpEmp.departmentId);
	
	if (isLastNameValid && isHireDateValid && isEmailValid && isJobIdValid && isManagerIdValid && isDepartmentIdValid){
		// 유효성 검사 모두 통과
		let url = "saveEmp.do";
	    $.ajax({
	        url: url, // 데이터가 송수신될 서버의 주소
	        type: "GET", // 통신 방식 (GET, POST, PUT, DELETE)
	    	data: tmpEmp, // 데이터 보내기
	        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
	        success: function (data) { // 통신이 성공하면 수행할 함수
		        console.log(data);
	        
	        	if (data.status == "ERROR") {
	        		alert("저장 실패");
	        	} else if (data.status == "SUCCESS") {
	        		alert("저장 성공");
	        	} else if (status.status == "fail") {
	        		alert("예외 발생");
	        	}
	        	
	        	$("#writeModal").hide();
// 	        	location.reload(); // 페이지 새로고침

	        	intInputModal(); // 태그를 ''로 비워주기
	        	getAllEmployees(); 
	        },
	        error: function () {},
	        complete: function () {},
	      });
		
	}
}

function intInputModal() {
	$("#writeFirstName").val('');
	$("#writeLastName").val('');
	$("#writeEmail").val('');
	$("#writePhoneNumber").val('');
	$("#wirteHireDate").val('');
	$("#writeJobId").val('');
	$("#writeSalarySpan").text(''); 
	$("#writeComm").val('0');
	$("#writeManager").val('');
	$("#writeDepartment").val('');
}

function checkDepartmentIdValid(departmentId) {
	let isDepartmentIdValid = true;
	if (departmentId == ''){
		printErrMsg('writeDepartment', '부서를 선택하세요');
		isDepartmentIdValid = false;
	}
	return isDepartmentIdValid;
}

function checkManagerIdValid(managerId) {
	let isManagerIdValid = true;
	if (managerId == '') {
		printErrMsg('writeManager', '매니저를 선택하세요.');
		isManagerIdValid = false;
	}
	return isManagerIdValid;
}

function checkJobIdValid(jobId) {
	let isJobIdValid = true;
	if (jobId == '') {
		printErrMsg('writeJobId', '직무를 선택하세요.');
		isJobIdValid = false;
	}
	return isJobIdValid;
}

function checkEmailValid(email) {
	// email : not null & unique
	
	// not null 체크
	let isEmailNNValid = true;
	if (email == '') {
		printErrMsg('writeEmail', ' Eamil은 필수항목입니다');
		isEmailNNValid = false;
	}
	
	// email 중복 검사
	let isEmailUKValid = true;
	$.each(empData.employees, function(i, e){
		if (e.EMAIL.toUpperCase() == email.toUpperCase()){
			// 중복!!
			printErrMsg('writeEmail', 'Email이 중복되면 안돼요오오오오~');
			isEmailNNValid = false;
		}
	});
	
	if (isEmailNNValid && isEmailUKValid) {
		return true;
	} else {
		return false;
	}
}

function checkHireDateValid(hiredate) {
	// hire_date : not null
	let isHireDateValid = true;
	console.log(hiredate == '');
	if (hiredate == '') {
		printErrMsg('wirteHireDate', '입사일은 필수항목입니다.');
		isHireDateValid = false;
	}
	return isHireDateValid;
}

function checkNameValid(lastname) {
	// last_name :  not null
	let isNameValid = true;
	
// 	console.log(lastname == '');
// 	console.log(lastname.length < 1);
	if (lastname.length < 1) {
		// 에러 메시지 출력
		printErrMsg('writeLastName', '성은 필수항목입니다.');
		isNameValid = false;
	}
	
	return isNameValid;
}


function printErrMsg(id, msg) {
	let errMsg = `<div class='errMsg'>\${msg}</div>`;
	$(errMsg).insertAfter($(`#\${id}`).parent());
	$(`#\${id}`).focus();
	$(".errMsg").hide(2000);
}

//------------------------------------------------------------------
function makeDeptSelection() {
	// 부서 정보를 동적으로 select태그에 바인딩
	let output = "<option value=''>--부서를 선택하세요-- </option>";
	$.each(deptsData.DEPTS, function(i, elt){
		output += `<option value='\${elt.DEPARTMENT_ID}' >\${elt.DEPARTMENT_NAME}</option>`;
	});
	
	return output;
}

function getDeptInfo() {
	// 모든 부서 데이터를 얻어오기
	let url = "getAllDept.do";
    $.ajax({
        url: url, // 데이터가 송수신될 서버의 주소
        type: "GET", // 통신 방식 (GET, POST, PUT, DELETE)
        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
        success: function (data) { // 통신이 성공하면 수행할 함수
	          console.log(data);
         	if (data.status == "fail"){
         		alert("데이터를 불러오지 못했습니다");
         	} else if (data.status == "success") {
         		deptsData = data;
         	} 
        },
        error: function () {},
        complete: function () {},
      });
} 


function makeManagerSelection() {
	// 매니저 정보를 동적으로 바인딩
	let output = "<option value=''>--매니저를 선택하세요--</option>";
	$.each(empData.employees, function(i, e){
		output += "<option value='" + e.EMPLOYEE_ID + "'>" + e.LAST_NAME + ", " + e.FIRST_NAME + "</option>";
	});
	return output;
}


function makeSalInput(inputJobId, mode){
	// mode : "write", "modify"
	let minSal = 0;
	let maxSal = 0;
	let avgSal = 0;
	
	// 선택된 job_id의 최소급여, 최대급여 
	$.each(jobsData.JOBS, function(i, e){
		if (inputJobId == e.JOB_ID){
			minSal = e.MIN_SALARY;
			maxSal = e.MAX_SALARY;
		}
	});
	
	avgSal = (minSal + maxSal) / 2;
	console.log(minSal, maxSal, avgSal);
	
	$(`#\${mode}Salary`).attr("max", maxSal);
	$(`#\${mode}Salary`).attr("min", minSal);
	$(`#\${mode}Salary`).attr("step", 10);
	
	if (mode == 'write'){
		$("#writeSalary").val(avgSal);
		$("#writeSalarySpan").html(avgSal);
	}
	
}

function changeSal(sal) {
	$("#writeSalarySpan").html(sal);
}

function modiChangeSal(sal){
	$("#modifySalarySpan").html(sal);
}

function changeSalary(id, sal){
// 	console.log(id, sal);
	$(`#\${id}Span`).html(sal.toLocaleString("en-US", {style : 'currency', currency:'USD'}));
}



function makeJobSelection() {
	// 직급 (job_id)정보를 동적으로 select태그에 바인딩
	let output = "<option value=''>--직급을 선택하세요-- </option>";
	$.each(jobsData.JOBS, function(i, elt){
		output += "<option value='" +  elt.JOB_ID + "'>" + elt.JOB_TITLE +"</option>";
	});
	
	return output;
}

function getJobsData(){
	let url = "getJobsData.do";
    $.ajax({
        url: url, // 데이터가 송수신될 서버의 주소
        type: "GET", // 통신 방식 (GET, POST, PUT, DELETE)
        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
        success: function (data) { // 통신이 성공하면 수행할 함수
	          console.log(data);
         	if (data.status == "fail"){
         		alert("데이터를 불러오지 못했습니다");
         	} else if (data.status == "success") {
	          jobsData = data;
         	}
        },
        error: function () {},
        complete: function () {},
      });
	
}


function getAllEmployees() {
	let url = "getAllEmployees.do";
    $.ajax({
        url: url, // 데이터가 송수신될 서버의 주소
        type: "GET", // 통신 방식 (GET, POST, PUT, DELETE)
        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
        success: function (data) { // 통신이 성공하면 수행할 함수
          console.log(data);
          empData = data;
          outputEntireEmployees(data);
        },
        error: function () {},
        complete: function () {},
      });
}

function outputEntireEmployees(json) {
	// 모든 직원 데이터 파싱하여 출력
	$("#outputDate").html("출력일시 : " + json.outputDate);
	$("#outputCnt").html("총 직원수 : " + json.count);
	
	let output = " <table class='table table-striped'><thead>";
	output += "<tr><th>사번</th><th>이름</th><th>이메일</th><th>전화번호</th>";
	output += "<th>입사일</th><th>직급</th><th>급여</th><th>커미션(%)</th><th>매니저</th>";
	output += "<th>부서명</th><th>수정</th><th>삭제</th></tr></thead>";
	
	output += "<tbody>";
	$.each(json.employees, function(i, item){
		output += "<tr><td>" +  item.EMPLOYEE_ID + "</td>";
		output += "<td>" +  item.LAST_NAME + ", " + item.FIRST_NAME +"</td>";
		output += "<td>" + item.EMAIL + "</td>";
		output += "<td>" + item.PHONE_NUMBER + "</td>";
		output += "<td>" + item.HIRE_DATE + "</td>";
		output += "<td>" + item.JOB_ID + "</td>";
		output += "<td>$" + (item.SALARY).toLocaleString("en-US") + "</td>";
		output += "<td>" + (item.COMMISSION_PCT) * 100 + "</td>";
		
		// 매니저 이름 찾기
		let managerId = item.MANAGER_ID;
		let managerName = "";
		$.each(empData.employees, function(i, mitem) {
			if (managerId == mitem.EMPLOYEE_ID) {
				// 매니저를 찾았다!
				managerName = mitem.LAST_NAME + ", " + mitem.FIRST_NAME;
			}
		});
		output += "<td>" + managerName + "</td>";
		
		output += "<td>" + item.DEPARTMENT_NAME + "</td>";
		output += "<td><img src='images/update.png' class='modifyDeleteIcons' onclick='showModiModal("+ item.EMPLOYEE_ID + ");'/></td>";
		output += "<td><img src='images/delete.png' class='modifyDeleteIcons' onclick='showDelModal("+ item.EMPLOYEE_ID + ");'/></td>";
		output += "</tr>";
	});
	
	output += "</tbody></table>";
	
	$(".empInfo").html(output);
}

function showDelModal(empNo){
	$("#deleteModal").show();
}


function showModiModal(empNo) {
// 	alert(empNo);
	// 사원 수정 모달창 띄우기
	$("#modifyModal").show();
	$("#modifyEmployeeId").val(empNo); // 사번을 수정모달에 바인딩
	
	let url = "getEmployee.do";
    $.ajax({
        url: url, // 데이터가 송수신될 서버의 주소
        type: "GET", // 통신 방식 (GET, POST, PUT, DELETE)
    	data : { "empNo" : empNo }, // 보내는 데이터
        dataType: "json", // 수신 받을 데이터 타입 (MIME TYPE)
        success: function (data) { // 통신이 성공하면 수행할 함수
          console.log(data);
          if (data.status == 'fail') {
        	  alert("데이터를 불러오지 못했습니다");
          } else if (data.status == 'success') {
        	  bindingDataModifyModal(data);
          }
        },
        error: function () {},
        complete: function () {},
      });
	
}

function bindingDataModifyModal(data) {
	// 사원 수정 모달창에 데이터 바인딩
	$("#modifyFirstName").val(data.employee.FIRST_NAME);
	$("#modifyLastName").val(data.employee.LAST_NAME);
	$("#modifyEmail").val(data.employee.EMAIL);
	$("#modifyPhoneNumber").val(data.employee.PHONE_NUMBER);
	$("#modifyHireDate").val(data.employee.HIRE_DATE);
	
	$("#modifyJobId").html(makeJobSelection());
	$("#modifyJobId").val(data.employee.JOB_ID);
	
	// salary input태그의 range세팅
	makeSalInput(data.employee.JOB_ID, 'modify');
	
	$("#modifySalarySpan").html((data.employee.SALARY).toLocaleString("en-US", {style : 'currency', currency:'USD'}));
	$("#modifySalary").val(data.employee.SALARY);
	
	$("#modifyComm").val(data.employee.COMMISSION_PCT);
	
	$("#modifyManager").html(makeManagerSelection());
	$("#modifyManager").val(data.employee.MANAGER_ID);

	$("#modifyDepartment").html(makeDeptSelection());
	$("#modifyDepartment").val(data.employee.DEPARTMENT_ID);
	
}

function showDelModal(empNo){
// 	alert(empNo);
$("#deleteModal").show();
$("#delEmpNo").html(empNo);
}

</script>
<style>
.writeIcon {
	position : fixed;
	right : 50px;
	top : 20px;
}

#writeIconImg {width : 50px;}

.input-group-text {	width : 120px;}

.modifyDeleteIcons {width : 25px;}

.errMsg { color : red;}

.sortEmp, .cntDateInfo {
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>

<%-- <c:set var="a" value="aaa"></c:set> --%>
<%-- <div>${a }</div> --%>
<script type="text/javascript">
	let b = 'bbb';
	console.log(`\${b }`); 
	console.log('${a }');
</script>

<%-- 
 		Connection con = DBConnection.dbConnect();
 		out.print(con.toString());
--%>
	<div class="container">
		<h1>Employees with AJAX</h1>
	

<!-- 	이름으로 검색어 입력	 -->
		<div class="mb-3 mt-3">
			<input type="text" class="form-control " placeholder="찾을 사원의 이름을 입력하세요....." id="findEmpName">
		</div>		
		
<!-- 		정렬방식 선택 -->
		<div class="sortEmp mb-3">
			<div class="form-check">
				<input type="radio" class="form-check-input orderMethod" id="orderEmpNo" name="optradio" value="empNo" checked> 사번순(오름차순)
				<label class="form-check-label" for="orderEmpNo"></label>
			</div>
			<div class="form-check">
				<input type="radio" class="form-check-input orderMethod" id="orderHireDate" name="optradio" value="hireDate"> 입사일순 (내림차순) 
				<label class="form-check-label" for="orderHireDate"></label>
			</div>
			<div class="form-check">
				<input type="radio" class="form-check-input orderMethod" id="orderSal" name="optradio" value="salary"> 급여순(내림차순) 
				<label class="form-check-label" for="orderSal"></label>
			</div>
			
		</div>
		
		
		<div class="cntDateInfo mb-3">
			<div id="outputDate" class="genInfo"></div>
			<div id="outputCnt" class="genInfo"></div>
		</div>
		
		
		<div class="empInfo"></div> <!--  모든 직원 테이블 출력 -->
	
		<div class="writeIcon"><img src="images/addEmp.png" alt="insertEmp" id="writeIconImg"/></div>
	
	<!--  ----------------- 사원 입력을 위한 모달창 ------------------------ -->
<div class="modal" id="writeModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">사원 입력</h4>
        <button type="button" class="btn-close closeModal" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="input-group  mb-3">
	    	<span class="input-group-text">이름</span>
	    	<input type="text" class="form-control" placeholder="first name..." id="writeFirstName">
  		</div>
  		
  		<div class="input-group  mb-3">
	    	<span class="input-group-text">성</span>
	    	<input type="text" class="form-control" placeholder="last name..." id="writeLastName">
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">이메일</span>
	    	<input type="text" class="form-control" placeholder="email..." id="writeEmail">
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">전화번호</span>
	    	<input type="text" class="form-control" placeholder="phone number..." id="writePhoneNumber">
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">입사일</span>
	    	<input type="date" class="form-control" placeholder="hire date..." id="wirteHireDate">
  		</div>
        
        <div class="input-group  mb-3" >
	    	<span class="input-group-text">직급</span>
	    	<select class="form-select" id="writeJobId"></select>
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">급여</span>
	    	<span id="writeSalarySpan"></span>
<!-- 	    	<input type="range" class="form-range"  id="writeSalary" onchange="changeSal(this.value);"> -->
	    	<input type="range" class="form-range"  id="writeSalary" onchange="changeSalary(this.id, this.value);">
  		</div>
  		
  		<div class="input-group  mb-3">
	    	<span class="input-group-text">커미션</span>
	    	<input type="number" class="form-control" value= "0" min="0" max="0.99" step="0.01" id="writeComm">
  		</div>
  		
  		<div class="input-group mb-3">
	    	<span class="input-group-text">매니저</span>
	    	<select class="form-select" id="writeManager"></select>
  		</div>
  		
  		<div class="input-group mb-3">
	    	<span class="input-group-text">부서명</span>
	    	<select class="form-select" id="writeDepartment"></select>
  		</div>
        
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  writeBtn" data-bs-dismiss="modal">Save</button>
        <button type="button" class="btn btn-danger  closeModal" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

	<!--  ----------------- 사원 수정을 위한 모달창 ------------------------ -->
<div class="modal" id="modifyModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">사원 수정</h4>
        <button type="button" class="btn-close closeModal" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<div class="input-group  mb-3">
	    	<span class="input-group-text">사번</span>
	    	<input type="text" class="form-control" id="modifyEmployeeId" readonly>
  		</div>
      
        <div class="input-group  mb-3">
	    	<span class="input-group-text">이름</span>
	    	<input type="text" class="form-control"  id="modifyFirstName">
  		</div>
  		
  		<div class="input-group  mb-3">
	    	<span class="input-group-text">성</span>
	    	<input type="text" class="form-control" id="modifyLastName">
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">이메일</span>
	    	<input type="text" class="form-control"  id="modifyEmail">
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">전화번호</span>
	    	<input type="text" class="form-control" id="modifyPhoneNumber">
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">입사일</span>
	    	<input type="date" class="form-control" id="modifyHireDate">
  		</div>
        
        <div class="input-group  mb-3" >
	    	<span class="input-group-text">직급</span>
	    	<select class="form-select" id="modifyJobId"></select>
  		</div>
        
        <div class="input-group  mb-3">
	    	<span class="input-group-text">급여</span>
	    	<span id="modifySalarySpan"></span>
<!-- 	    	<input type="range" class="form-range"  id="modifySalary" onchange="modiChangeSal(this.value);"> -->
	    	<input type="range" class="form-range"  id="modifySalary" onchange="changeSalary(this.id, this.value);">
  		</div>
  		
  		<div class="input-group  mb-3">
	    	<span class="input-group-text">커미션</span>
	    	<input type="number" class="form-control" value= "0" min="0" max="0.99" step="0.01" id="modifyComm">
  		</div>
  		
  		<div class="input-group mb-3">
	    	<span class="input-group-text">매니저</span>
	    	<select class="form-select" id="modifyManager"></select>
  		</div>
  		
  		<div class="input-group mb-3">
	    	<span class="input-group-text">부서명</span>
	    	<select class="form-select" id="modifyDepartment"></select>
  		</div>
        
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-success  modifyBtn" data-bs-dismiss="modal">수정</button>
        <button type="button" class="btn btn-danger  closeModal" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>
	
	<!-- 사원 삭제 모달 -->
<div class="modal" id="deleteModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">사원 삭제</h4>
        <button type="button" class="btn-close closeModal" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div>
        	<span id="delEmpNo"></span>번 사원을 정말 삭제할까요?
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      	<button type="button" class="btn btn-success  deleteBtn" data-bs-dismiss="modal">삭제</button>
        <button type="button" class="btn btn-danger closeModal" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>
	
	
	</div>
</body>
</html>