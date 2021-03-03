package com.mvcproject.member.controller.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcproject.member.controller.model.dao.MemberDao;
import com.mvcproject.member.controller.model.vo.Member;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	
	public List<Member> selectMemberAll() throws Exception{
		List<Member> memberList = memberDao.selectMemberAll();
		return memberList;
	}
	
	@Override
	public Member selectMember(String userid) throws Exception{
		Member member = memberDao.selectMember(userid);
		return member;
	}
	
	@Override
	public int insertMember(Member member) throws Exception{
		int cnt = memberDao.insertMember(member);
		return cnt;
	}
	
	@Override
	public int updateMember(Member member) throws Exception{
		int cnt = memberDao.updateMember(member);
		return cnt;
	}
	
	@Override
	public int deleteMember(Member member) throws Exception{
		int cnt = memberDao.deleteMember(member);
		return cnt;
	}

}


