package com.mvcproject.member.controller.model.service;

import java.util.List;

import com.mvcproject.member.controller.model.vo.Member;

public interface MemberService {
	
	public List<Member> selectMemberAll() throws Exception;
	
	public Member selectMember(String userid) throws Exception;
	
	public int insertMember(Member member) throws Exception;
	
	public int updateMember(Member member) throws Exception;
	
	public int deleteMember(Member member) throws Exception;
	
}


