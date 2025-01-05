function registerValid() {
  let valid = false; //일단 false로 잡고 하나하나 다 검사해서 통과하면 true
  //아이디 검사

  let idCheck = validUserId($("#userId").val());
  let pwdCheck = validPwd($("#pwd1").val(), $("#pwd2").val());
  let emailCheck = validEmail($("#email").val());
  //휴대폰 번호 유효성 검사해보기!!

  let genderCheck = validGender();

  //취미 정보를 수집
  let hobbies = getHobby();
  //hobby=study&hobby=music&hobby=travel이런식으로 수집, 다중으로 선택해서 넘겨줄 때는 하나의 칼럼을 만든 뒤(hobby), 하나만 선택하면 하나만, 세개를 선택하면 1,2,3으로 넣기/장바구니도 같은 원리 하나의 칼럼에 다 넣어야지 아니면 공간 낭비
  //getHobby():,로 선택된 취미를 결합해서 반환

  let jobCheck = getjob(); //직업 체크여부

  let memo = getMemo(); //메모내용

  let isAgree = false;
  console.log(document.getElementById("agree").checked);
  if (document.getElementById("agree").checked) {
    isAgree = true;
  } else {
    outputError("가입조항에 동의해 주세요", $("#agree"));
  }

  if (idCheck && pwdCheck && emailCheck && genderCheck && jobCheck && isAgree) {
    //모든 필수항목 유효성 검사 통과
    valid = true;
  }
  return valid;
}

function getMemo() {
  console.log(document.getElementById("memo").value);
}

function getjob() {
  //반드시 하나를 선택하도록 한다
  let isValid = false;
  console.log(document.getElementById("job").value);
  // document.getElementById('job').value=='--직업을 선택하세요--'
  console.log(document.getElementById("job").selectedIndex); //0
  if (document.getElementById("job").selectedIndex == 0) {
    outputError("필수항목입니다", $("#job"));
  } else {
    isValid = true;
  }
  return isValid;
}

function getHobby() {
  let hobbies = "";
  let hobbyArr = document.getElementsByName("hobby");
  console.log(hobbyArr);
  console.log(hobbyArr[0].checked);
  for (let i = 0; i < hobbyArr.length; i++) {
    if (hobbyArr[i].checked == true) {
      console.log(hobbyArr[i].value);
      hobbies += hobbyArr[i].value + ",";
      //여기서 콤마를 빼는 방향으로 처리할수도
    }
  }
  console.log(hobbies);
  //console: study,travel,sports,
  // 마지막 콤마를 없애서 반환하자
  console.log(hobbies.slice(0, -1)); //첫인덱스부터 마지막뺀 인덱스까지
  console.log(hobbies.substring(0, hobbies.length - 1));

  return hobbies.slice(0, -1);
}

function validGender() {
  let isValid = false;
  let radio1 = false; //여성 라디오버튼
  let radio2 = false; //남성 라디오 버튼
  console.log(document.getElementsByName("gender")[0].checked);
  if (document.getElementsByName("gender")[0].checked) {
    radio1 = true;
  }
  if (document.getElementsByName("gender")[1].checked) {
    radio2 = true;
  }
  //아무것도 체크되지 않았다면
  if (radio1 == false && radio2 == false) {
    outputError("성별은 필수항목입니다.", $("#radio-result"));
  } else {
    isValid = true;
  }
  return isValid;
}

function validEmail(email) {
  let emailRegExp =
    /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

  let isValid = false;

  if (!emailRegExp.test(email)) {
    outputError("이메일 형식이 아닙니다.", $("#email"));
  } else {
    isValid = true;
  }

  return isValid;
}

function validPwd(pwd1, pwd2) {
  let isValid = false;
  if (pwd1 === "") {
    outputError("비밀번호는 필수항목입니다", $("#pwd1"));
  } else if (pwd1.length <= 3 || pwd1.length >= 13) {
    outputError("4자 이상 12자 이하로 입력하세요", $("#pwd1"));
  } else if (pwd1 !== pwd2) {
    outputError("비밀번호가 일치하지 않습니다", $("#pwd2"));
  } else {
    //이전까지는 계속 false로 남아있다가
    isValid = true;
  }

  return isValid;
}

function validUserId(userId) {
  //아이디(*):4자 이상 8자 이하(소문자로 저장)
  let idCheck = false;
  console.log(userId === ""); //유저가 아이디를 입력하지 않음
  if (userId === "") {
    //에러메시지 출력, 여러번 쓸거니까 함수로 만들자
    outputError("아이디는 필수 항목입니다.", $("#userId"));
  } else if (userId.length <= 3 || userId.length >= 9) {
    outputError("4자 이상 8자 이하로 입력하세요.", $("#userId"));
  } else {
    idCheck = true;
  }

  return idCheck;
  //공백도 제거해주고...
}
function outputError(errorMsg, tagObj) {
  //errorMsg를 tagObj객체 다음 요소에 삽입시켜서 출력한다
  let err = `<div class='errMsg'>${errorMsg}</div>`;
  $(err).insertAfter($(tagObj));
  $(".errMsg").hide(4000); //아무것도 입력안하면 4초동안 등장
}
