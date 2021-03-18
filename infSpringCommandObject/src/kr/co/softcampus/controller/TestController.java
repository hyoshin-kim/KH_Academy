package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {

	@PostMapping("/test1")
	//public String test1(@ModelAttribute DataBean bean) {		//커맨드 객체 : HttpServletRequest객체에 자동으로 담기고 jsp로 전달
	public String test1(DataBean bean) {		
		//System.out.println("data1 : " + bean.getData1());
		//System.out.println("data2 : " + bean.getData2());
		
		return "test1";
	}
	
	@PostMapping("/test2")
	public String test2(@ModelAttribute("testData") DataBean bean) {
		
		return "test2";
	}
}
