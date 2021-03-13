package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for(String str1 : data3) {
			System.out.println("data3 : " + str1);
		} 
		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");	//checkbox는 선택을 안하면 null값으로 넘어옴
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		if(data3 != null) {
			for(String str1 : data3) {
				System.out.println("data3 : " + str1);
			}
		}
		return "result";
	}
	
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		if(data3 != null) {
			for(String str1 : data3) {
				System.out.println("data3 : " + str1);
			}
		}
		return "result";
	}
	
	@GetMapping("/test4/{data1}/{data2}/{data3}")	//{}에 들어가는건 값 (jsp에서 test4/100/200/300 일 경우 100까지가 이름이면 )
	public String test4(@PathVariable int data1,		//형변환도 가능
						@PathVariable String data2,
						@PathVariable String data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		return "result";
	}
	

	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int [] data3,
						@RequestParam String data4) {	//Required String parameter 'data4' is not present로  data4가 넘어오는 값이 없는데 파라미터로 받아서 오류
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

			for(int num1 : data3) {
				System.out.println("data3 : " + num1);
			}
		return "result";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam(value="data1") int value1,	// 파라미터와 주입한 이름이 다를 경우 value를 씀
						@RequestParam(value="data2") int value2,
						@RequestParam(value="data3") int [] value3) {
		System.out.println("data1 : " + value1);
		System.out.println("data2 : " + value2);

			for(int num1 : value3) {
				System.out.println("data3 : " + num1);
			}
		return "result";
	}
	
	@GetMapping("/test7")
	public String test6(@RequestParam int data1,
						@RequestParam(required=false) String data2,
						@RequestParam(defaultValue="0") int data3) {	//Required String parameter 'data2' is not present(주입하는 값이 없는데 받을 경우 오류 남
														//존재 하지 않지만 null값으로 처리 하고 싶으면 required 사용)
														//데이터 타입이 String인 이유는 int로 하면 null이 int로 형변환 하면서 오류가 남
						//defaultValue : data가 없어도 defalut값 설정
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		return "result";
	}
}
