package com.javalec.spring_pjt_baord.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_baord.dao.BDao;
import com.javalec.spring_pjt_baord.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bld = request.getParameter("bld");

		BDao dao = new BDao();
		//BDto dto = new BDto(bld);
		
		//model.addAttribute("content_view",dto);
		
	}

}
