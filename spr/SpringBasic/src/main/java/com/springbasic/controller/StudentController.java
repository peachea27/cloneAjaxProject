package com.springbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbasic.domain.Student;

@Controller
@RequestMapping("/student/*")// /student/* �� ��� url�� ���ؼ� mapping
public class StudentController {

	@RequestMapping("outputStudent")
	public void outputStudent(Model model) {
		
		Student stu = new Student("24001", "ȫ�浿");
		model.addAttribute("student", stu);
		
		
	}
	
	@RequestMapping(value="InputStudent", method=RequestMethod.GET)
	public void inputStudentGET() {
		System.out.println("InputStudentGet ȣ���");
	}
	
	@RequestMapping(value="saveStudent", method = RequestMethod.POST)
	public String inputStudentPOST(@RequestParam("stuNo") String stuNo,
								@RequestParam("stuName") String stuName, Model model,RedirectAttributes rttr) {
		System.out.println("�й�:"+stuNo+",�̸� : "+stuName);
		
		Student stu = new Student(stuNo, stuName);
		model.addAttribute("inputStudent", stu);
		
//		rttr.addAttribute("inputStudnet", stu)//type conversuon error
//		rttr.addFlashAttribute("inputStudent", stu); //ok
		rttr.addAttribute("stuNo", stu.getStuNo());
		rttr.addAttribute("stuName", stu.getStuName());
		return "redirect:homeStudent";
	}
	
	@RequestMapping("homeStudent")//�����ϸ� get���
	public void homeStudent() {
		System.out.println("homeStudent GET ��û");
	}
}
