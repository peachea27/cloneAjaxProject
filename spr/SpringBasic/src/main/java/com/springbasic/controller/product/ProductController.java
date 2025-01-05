package com.springbasic.controller.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbasic.domain.productDTO;

@Controller
public class ProductController {
	
	@RequestMapping("viewProduct")
	public void viewProduct() {
		System.out.println("viewProduct ȣ��");
		// WEB-INF/views/viewProduct.jsp ������
	}

	@RequestMapping("viewProduct2")
	public String redirectView() {
		
		return "redirect:/";
		//home controller�� �ּ�: home ��û
	}
	
	@RequestMapping(value="hello" , method=RequestMethod.GET)
	//post�� �ϸ� Request method 'GET' not supported ����
	public void hello() {
		
	}
	
	//�Ķ���͸� �Ѱ��ָ鼭 ������ redirect
	@RequestMapping(value="viewProduct3", method=RequestMethod.GET)
	public String redirectView2(RedirectAttributes rttr) {
		
		rttr.addAttribute("name", "�Ѹ�");//������Ʈ������ �Ѱ�����.�ּ�â�� ?name=�Ѹ��� ����
		rttr.addAttribute("age", 10);
		
		rttr.addFlashAttribute("status", "success");//������Ʈ���� �ѱ��� ����! ��� ����+�ֹ߼�
		
		//Map����ϱ�
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "�Ѹ�");
		map.put("age", "10");
		
		rttr.addAllAttributes(map);
		
		return "redirect:/hello";//����value="hello"�� �θ�
	}
	
	//�Ķ���� ����
	@RequestMapping(value="productTest",method=RequestMethod.GET)
	public void testParam(String name, int age) {//��Ʈ���� �־��ָ� �޾ƿ�
		System.out.println("name : " + name);
		System.out.println("name : " + age);
	}
	
//	@RequestMapping("productForm")
	@GetMapping("productForm")
	public void productFormGET() {
	}

//	@RequestMapping(value="prodPost",method=RequestMethod.POST)
	@PostMapping("prodPost")
//	public String saveProduct(@ModelAttribute(name="prod") productDTO product) {
	public String saveProduct(productDTO product) {
		System.out.println(product.toString());
		
		return "product";
	}
	
	// JSON ����
	@GetMapping("jsonForm")
	public void jsonFormGET() {
		
	}
	
	@PostMapping("savejson")
	public @ResponseBody productDTO outputJson(productDTO product) {
		return product;
	}
	
	
	
}
