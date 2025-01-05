package com.springbasic.membercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping("memberView")
	public String doMemberView() {
		System.out.println("doMemberView ȣ���");
		
		return "doMemberView"; 
	}
	
	//memberView �� �����ּҰ� ������ ambiguous mapping���� �߻�
	@RequestMapping(value={"memberSave","memberSave2"}, method=RequestMethod.GET)
	//"memberSave","memberSave2": �ΰ��� �ּ� ��η� ����
	public String doMemberSave() {
		System.out.println("doMemberSaveȣ���");
		return "memberSave";
	}
	
	@RequestMapping(value="memberTest")
	public void doMemberTest(@RequestParam(name="name")String name,
							@RequestParam(name="age", required=false, defaultValue = "0")int age) {
		//�ּҿ��� ������Ʈ������ ?name=key&age=30 �߰��ϸ� �����۵�
		//required=false : �ʼ��� �ƴ�, null ��µ� //int age�϶� ����? ->defaultValue = "0"
						
		System.out.println("name : "+name +" ,age : "+age);
	}
	
	@RequestMapping(value="paramTest")
	public String paramTest(@RequestParam(name="age", required = false, defaultValue="0") Integer age) {
		System.out.println("age : " +age);
		
		//1)String age�� �� 
		//?������Ʈ���� ���� : 400 ����
		//?age=3 -> age :3
		//?age=  -> age :(����)
		//?������Ʈ���� ���� + (required = false) -> age : null
		//?������Ʈ���� ���� + (required = false, defaultValue="0") -> age : 0
		
		//2)int age
		//?������Ʈ���� ���� : 400 ����
		//?age=3 -> age :3
		//?������Ʈ���� ���� + (required = false) -> 500���� -> int�� Integer�� �����ϸ� age:null
		//?������Ʈ���� ���� + (required = false, defaultValue="0")int age -> age : 0
		return "paramTest";
	}
}
