package com.mvc.jsonexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JsonController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);
	
	@RequestMapping(value="test1.do",method=RequestMethod.POST)
	public void test1Method(Sample vo, HttpServletResponse response, HttpSession session) throws IOException {
		//response.setContentType("text/html,charset=UTF-8");
		
		//PrintWriter 객체를 생성하여 통신에 대한 응답 결과를 전달한다.
		PrintWriter out = response.getWriter();
		
		System.out.println("vo : " + vo);
		if(vo.getName().equals("신사임당")) {
			session.setAttribute("sample", vo);
			out.append("ok");
			out.flush();
		}else {
			out.append("fail");
			out.flush();
		}
		out.close();
	}
	
	@RequestMapping(value="test2.do",method=RequestMethod.POST)
	@ResponseBody	//결과를 response 객체에 담아서 보내는 어노테이션
	public String test2Method(HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html,charset=UTF-8");
		
		JSONObject job = new JSONObject();
		//Map형식의 JSONObject 객체를 생성하여 출력할 값을 key와 Value 형태로 담는다
		job.put("no", 123);	//json객체에 key값,value 값
		job.put("title","test return json object");
		
		//한글 전송 시 깨질 우려가 있으므로, URLEncoder로 UTF-8 방식의 인코딩을 처리함
		job.put("writer", URLEncoder.encode("홍길동","utf-8"));
		job.put("content", URLEncoder.encode("json 객체를 뷰로 리턴하는 테스트","utf-8"));
		
		//JSONObject를 string 형태로 리턴
		return job.toJSONString();
	}
	
	@RequestMapping(value="test3.do", method=RequestMethod.POST)
	public void test3Method(HttpServletResponse response) throws IOException {
		//logger.info("test3Method()run...");			//이건 왜 하는거?
		
		//List를 json 배열로 만들어서, 뷰로 리턴
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("u1","pwd1","홍길동",25,"hong@kh.org"));
		list.add(new User("u2","pwd2","김길동",30,"kim@kh.org"));
		list.add(new User("u3","pwd3","이길동",35,"lee@kh.org"));
		list.add(new User("u4","pwd4","최길동",40,"choi@kh.org"));
		list.add(new User("u5","pwd5","박길동",45,"park@kh.org"));
		
		//전송용 최종 json 객체
		JSONObject sendJson = new JSONObject();
		
		//JSONArray 객체를 생성하여 JSONObject 객체를 하나씩 담음
		JSONArray jarr = new JSONArray();
		
		//list를 jarr에 저장
		for(User user : list) {
			//user정보 저장할 json 객체 선언
			JSONObject juser = new JSONObject();
			juser.put("userId", user.getUserId());
			juser.put("userPwd", user.getUserPwd());
			juser.put("userName", URLEncoder.encode(user.getUserName()));
			juser.put("userAge", user.getAge());
			juser.put("userEmail", user.getEmail());
			jarr.add(juser);
		}
		//전송할 객체 배열을 JSONObject에 담아 한 번에 전달
		sendJson.put("list", jarr);
		response.setContentType("application/json; char=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(sendJson.toJSONString());
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="test4", method=RequestMethod.POST)
	public ModelAndView test4Method(ModelAndView modelAndView) throws UnsupportedEncodingException{
		
		//담아서?
		Sample sample = new Sample();
		sample.setName("신사임당");
		sample.setAge("35");

		//한글 인코딩
		sample.setName(URLEncoder.encode(sample.getName(),"utf-8"));
		
		//맵에 넣어주고?
		Map<String, Sample> map = new HashMap<String, Sample>();
		map.put("sample", sample);
		
		modelAndView.addAllObjects(map);	
		modelAndView.setViewName("jsonView");	//jsp 이름쓰는 곳
		
		return modelAndView;
		
	}
}
