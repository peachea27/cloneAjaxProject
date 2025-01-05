package com.springbasic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbasic.domain.Student;

/**
 * Handles requests for the application home page.
 */
@Controller //���� Ŭ������ ��Ʈ�ѷ������� ���
public class HomeController {
	
	//�α׸� ���� �� �ֵ��� �ϴ� ��ü
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//servlet���κ��� ��û�� ��ü�� ����
	// "/"�� GET������� ��û�Ǹ�, �Ʒ��� home�޼��带 ȣ���Ѵ�.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//model : controller�ܿ��� view������ ���ε��� �����͸� �Ѱ��ִ� ��ü
		model.addAttribute("serverTime", formattedDate );
		
		//view resolver���� "home"���ڿ��� ��ȯ
		//"/WEB-INF/views/" + "home" + ".jsp"�� ��üȭ �Ǿ�
		//���� Dispatcher Servlet�� ���� response��
		return "home";
	}
	
	@RequestMapping(value="/doAct1")
	public String doAction1() {
		System.out.println("doAction1�� ȣ���");
		return "doAction1";
	}
	
	@RequestMapping(value="/doAct2")
	public void doAction2() {
		logger.info("doAct2�� ȣ���");
	}
	
	@RequestMapping(value="/doAct3")
	public String doAction3(Model model) {
		logger.info("doAction3�� ȣ���");
		
		String name="lyh";
		model.addAttribute("name", name); //model��ü�� ���ε�
		
		return "doAction3";
	}
	
	@RequestMapping(value="/doAct4")
	public ModelAndView doAction4() {
		logger.info("doAction4�� ȣ���");
		
		String name="lyh";
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name); //ModelAndView��ü�� ���ε�
		mav.setViewName("doAction4");
		
		return mav;
	}
	
	@RequestMapping(value="/doAct5")
	public void doAction5(Model model) {
		logger.info("doAct5�� ȣ���");
		
		Student stu = new Student("24001", "ȫ�浿");
//		model.addAttribute("student", stu);
//		model.addAttribute("stu", stu);
		
		//���ε��ϴ� ��ü�� �̸��� �������� ���� ��쿡��
		//�ڵ����� Ŭ������ �ձ��ڸ� �ҹ��ڷ� �ٲ㼭 ���ε�
		model.addAttribute(stu);
	}
}
