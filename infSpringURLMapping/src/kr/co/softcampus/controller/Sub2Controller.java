package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sub2")
public class Sub2Controller {

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String sub1Test3() {
		return "sub2/test5";
	}
	
	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String sub1Test4() {
		return "sub2/test6";
	}
}
