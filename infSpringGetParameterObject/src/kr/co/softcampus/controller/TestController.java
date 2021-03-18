package kr.co.softcampus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.DataBean2;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");									
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data33 : " + data33);	//앞에 있는 하나(300)만 담겨서 나옴(2개 이상이면 List 사용)
		
		for(String str : data3) {
			System.out.println("data3 : " + str);
		}
		return "result";
	}
	
	@GetMapping("/test2")
	//public String test2(@ModelAttribute DataBean bean1,@ModelAttribute DataBean2 bean2) {
	public String test2(DataBean bean1, DataBean2 bean2) {		//@ModelAttribute 생략 가능
		
		System.out.println("data1 : " + bean1.getData1());
		System.out.println("data2 : " + bean1.getData2());
		
		for(int number1: bean1.getData3()) {
			System.out.println("data3 : " + number1);
		}
		
		System.out.println("bean2.data1 : " + bean2.getData1());
		System.out.println("bean2.data2 : " + bean2.getData2());
		
		return "result";
	}
}
