import { localAxios } from "@/util/http-commons";
//http 통신 라이브러리 : axios
//응답제어(예외처리): 성공 시 then(), 실패 시 catch()

//async/await 사용법
//function 앞에 async를 붙이고 객체 앞에 await 붙이기
// async 해당 함수는 자동으로 프로미스(객체)를 반환
// 비동기 처리 패턴

//localAxios 함수 사용하기 위해 선언
const local = localAxios();

//파티 생성 url 정의
const url = "/api/v1/parties";

//예시) 노션의 api 명세 참고
// 파티를 생성할 경우 총무의 정보를 백단에 보내주는 함수 예시
async function createParty(param, success, fail) {
  console.log("param", param);
  await local.post(`${url}`, param).then(success).catch(fail);
}

//예시2)
// 파티 목록을 조회
// function getPartiesToday(param, success, fail) {
//     local.get(`${url}`, { params }).then(success).catch(fail);
// }

// 파티 입장 전 파티 상세정보 조회
function getParty(code, success, fail){
  console.log("파티정보 조회:",code);
  local.get(`${url}/${code}`).then(success).catch(fail);
  
}

//파티 입장 후 주문자&주문메뉴 내역 조회
function getOrderList(code, success, fail){
  console.log("주문내역 조회", code);
  local.get(`${url}/${code}/order-menus`).then(success).catch(fail);
}


//파티 입장 후 주문 넣기
function createOrder(code, success, fail){
  console.log("주문넣기", code);
  local.post(`${url}/${code}/order-menus`).then(success).catch(fail);
}

//파티 입장 후 주문 삭제
function deleteOrderMenu(code, id, success, fail){
  console.log("주문 삭제", code);
  console.log("주문 삭제할 id", id)
  local.delete(`${url}/${code}/order-menus/${id}`).then(success).catch(fail);
}



export { createParty, getParty, getOrderList, createOrder, deleteOrderMenu };
