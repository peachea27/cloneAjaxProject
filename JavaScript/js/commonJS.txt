// 많이 쓰는 함수를 저장해놓기 //찜기능을 만들때 다시 쿠키를 사용해보세요

function getParameter(paraName) {
  //쿼리스트링에서 파라미터 값 얻어오기
  let returnVal = null;
  let url = location.href;
  if (url.indexOf("?") !== -1) {
    //쿼리스트링이 있는 경우
    let queryString = url.split("?")[1];
    let queryStringArr = queryString.split("&");

    for (let item of queryStringArr) {
      if (item.split("=")[0] == paraName) {
        returnVal = item.split("=")[1];
        break; //파라미터 값을 찾으면 해당 반복문 ㄴ블럭을 빠져감
      }
    }
  }
  console.log(returnVal);
  return returnVal;
}

//쿠키 관련 함수
function readCookie(searchName) {
  //searchName 이름의 쿠키를 찾아서,
  //있으면
  //alert('쿠키 찾아보자');
  let returnVal = null; //여기 null을 넣으면 null이 반환되게 만들 수 있다
  let cook = document.cookie;
  console.log(cook); //myCook=ksy; notice=Y
  console.log(cook === ""); //==도 ok/true:쿠키가 없는 경우 :""
  let cookArr = cook.split(";");

  for (let i = 0; i < cookArr.length; i++) {
    let cookName = cookArr[i].split("=")[0];
    if (cookName.trim() == searchName) {
      //쿠키를 찾았다!
      returnVal = cookArr[i].split("=")[1];
    }
  }
  return returnVal;
}

function saveCookie(cookieName, cookieValue, expDate) {
  // alert('쿠키저장함수호출');
  alert(cookieName + ";" + cookieValue + ";" + expDate);

  let now = new Date();
  now.setDate(now.getDate() + expDate);
  let tmpCookie =
    cookieName + "=" + cookieValue + ";expires=" + now.toUTCString();
  //쿠키 저장
  document.cookie = tmpCookie;
}
