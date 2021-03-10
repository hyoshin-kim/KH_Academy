package com.javalec.spring_pjt_baord.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_baord.command.BCommand;
import com.javalec.spring_pjt_baord.command.BContentCommand;
import com.javalec.spring_pjt_baord.command.BDeleteCommand;
import com.javalec.spring_pjt_baord.command.BListCommand;
import com.javalec.spring_pjt_baord.command.BModifyCommand;
import com.javalec.spring_pjt_baord.command.BReplyCommand;
import com.javalec.spring_pjt_baord.command.BReplyViewCommand;
import com.javalec.spring_pjt_baord.command.BWriteCommand;

@Controller
public class BController {

	BCommand command;
	
	@RequestMapping("/list")	//리스트
	public String list(Model model) {
		System.out.println("list()");
		
		command = new BListCommand();
		command.execute(model);	
		
		return "list";
	}
	
	@RequestMapping("/write_view")	//작성하는 화면
	public String write_view(Model model) {
		System.out.println("writer_view()");

		return "write_view";
	}
	
	@RequestMapping("/write")		//작성
	public String write(HttpServletRequest request,Model model) {
		System.out.println("write()");

		model.addAttribute("request",request);
		command = new BWriteCommand();
		command.execute(model);
			
		return "redirect:list";
	}
	
	@RequestMapping("content_view")	//글 내용 보는거
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view()");

		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")	//수정 하는 부분이라 post
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("modify()");
		 
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")	//답글 작성 부분 보는거?
	public String reply_view(HttpServletRequest request,Model model) {
		System.out.println("reply_view()");
		 
		model.addAttribute("request",request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")	//답글 작성
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("reply()");
		 
		model.addAttribute("request",request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")	//삭제
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
