package com.springbasic.membercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping("memberView")
	public String doMemberView() {
		System.out.println("doMemberView 호출됨");
		
		return "doMemberView"; 
	}
	
	//memberView 등 매핑주소가 같으면 ambiguous mapping오류 발생
	@RequestMapping(value={"memberSave","memberSave2"}, method=RequestMethod.GET)
	//"memberSave","memberSave2": 두가지 주소 모두로 가능
	public String doMemberSave() {
		System.out.println("doMemberSave호출됨");
		return "memberSave";
	}
	
	@RequestMapping(value="memberTest")
	public void doMemberTest(@RequestParam(name="name")String name,
							@RequestParam(name="age", required=false, defaultValue = "0")int age) {
		//주소에서 쿼리스트링으로 ?name=key&age=30 추가하면 정상작동
		//required=false : 필수는 아님, null 출력됨 //int age일땐 오류? ->defaultValue = "0"
						
		System.out.println("name : "+name +" ,age : "+age);
	}
	
	@RequestMapping(value="paramTest")
	public String paramTest(@RequestParam(name="age", required = false, defaultValue="0") Integer age) {
		System.out.println("age : " +age);
		
		//1)String age일 때 
		//?쿼리스트링이 없음 : 400 에러
		//?age=3 -> age :3
		//?age=  -> age :(빈문자)
		//?쿼리스트링이 없음 + (required = false) -> age : null
		//?쿼리스트링이 없음 + (required = false, defaultValue="0") -> age : 0
		
		//2)int age
		//?쿼리스트링이 없음 : 400 에러
		//?age=3 -> age :3
		//?쿼리스트링이 없음 + (required = false) -> 500에러 -> int를 Integer로 수정하면 age:null
		//?쿼리스트링이 없음 + (required = false, defaultValue="0")int age -> age : 0
		return "paramTest";
	}
}
