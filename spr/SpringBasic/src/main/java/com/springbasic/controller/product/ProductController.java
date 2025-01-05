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
		System.out.println("viewProduct 호출");
		// WEB-INF/views/viewProduct.jsp 포워딩
	}

	@RequestMapping("viewProduct2")
	public String redirectView() {
		
		return "redirect:/";
		//home controller의 주소: home 요청
	}
	
	@RequestMapping(value="hello" , method=RequestMethod.GET)
	//post로 하면 Request method 'GET' not supported 오류
	public void hello() {
		
	}
	
	//파라미터를 넘겨주면서 페이지 redirect
	@RequestMapping(value="viewProduct3", method=RequestMethod.GET)
	public String redirectView2(RedirectAttributes rttr) {
		
		rttr.addAttribute("name", "둘리");//쿼리스트링으로 넘겨진다.주소창에 ?name=둘리가 생김
		rttr.addAttribute("age", 10);
		
		rttr.addFlashAttribute("status", "success");//쿼리스트링에 넘기지 않음! 숨어서 간다+휘발성
		
		//Map사용하기
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "둘리");
		map.put("age", "10");
		
		rttr.addAllAttributes(map);
		
		return "redirect:/hello";//매핑value="hello"를 부름
	}
	
	//파라미터 수집
	@RequestMapping(value="productTest",method=RequestMethod.GET)
	public void testParam(String name, int age) {//스트링에 넣어주면 받아옴
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
	
	// JSON 응답
	@GetMapping("jsonForm")
	public void jsonFormGET() {
		
	}
	
	@PostMapping("savejson")
	public @ResponseBody productDTO outputJson(productDTO product) {
		return product;
	}
	
	
	
}
