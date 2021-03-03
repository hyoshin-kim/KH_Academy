package com.mvcproject.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.member.controller.model.service.MemberService;
import com.mvcproject.member.controller.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="memberList.do",method=RequestMethod.GET)
	public ModelAndView memberListService(ModelAndView modelAndView, HttpServletRequest reqeust) throws Exception {
		
		List<Member> memberList = memberService.selectMemberAll();
		
		// memberList.size() list 데이터 건수를 리턴  jsp  <%  %>  ${}   jstl
		/*for(int i = 0; i < memberList.size(); i++) { // memberList 데이터 갯수 만큼 반복

			//System.out.println(i);
			Member member = memberList.get(i);
			
			System.out.println(i+ "name:" + member.getName());
			System.out.println("email:" + member.getEmail());

		}*/
		
		modelAndView.addObject("memberList", memberList);
		modelAndView.setViewName("member/memberList");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberView.do",method=RequestMethod.GET)
	public String memberViewService(@RequestParam("id") String id, Model model) throws Exception {
		
		Member member = memberService.selectMember(id);
		model.addAttribute("member", member);
		
		return "member/memberView";
	}
	
	@RequestMapping(value="memberDel.do",method=RequestMethod.GET)  //@PostMapping 
	public ModelAndView deleteMember(Member member, ModelAndView modelAndView) throws Exception {
		
		int cnt = memberService.deleteMember(member);
		
		modelAndView.addObject("cnt",cnt);
		modelAndView.setViewName("member/memberDelComplete");
		return modelAndView;
	}
	
	@RequestMapping(value="memberIns.do", method=RequestMethod.GET)
	public ModelAndView memberInsForm(ModelAndView modelAndView) throws Exception {
				
		modelAndView.setViewName("member/memberInsForm");
		return modelAndView;
	}
	
	@RequestMapping(value="memberIns.do", method=RequestMethod.POST)
	public ModelAndView memberIns(Member member,ModelAndView modelAndView) throws Exception {
		
		int cnt = memberService.insertMember(member);
		modelAndView.addObject("cnt",cnt);
		modelAndView.setViewName("member/memberInsComplete");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberUpt.do", method=RequestMethod.GET)
	public ModelAndView memberUptForm(@RequestParam("id") String id, ModelAndView modelAndView) throws Exception {
		
		Member member = memberService.selectMember(id);
		modelAndView.addObject("member",member);
		modelAndView.setViewName("member/memberUptForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberUpt.do", method=RequestMethod.POST)
	public ModelAndView memberUpt(Member member, ModelAndView modelAndView) throws Exception {
		
		int cnt = memberService.updateMember(member);
		
		modelAndView.addObject("cnt",cnt);
		modelAndView.setViewName("member/memberUptComplete");
		
		return modelAndView;
	}
}

