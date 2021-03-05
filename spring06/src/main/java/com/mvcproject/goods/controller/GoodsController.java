package com.mvcproject.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.goods.controller.model.service.GoodsService;
import com.mvcproject.goods.controller.model.vo.Goods;

@Controller
public class GoodsController {

	@Autowired
	GoodsService goodsService; 
	
	@RequestMapping(value="goodsList.do",method=RequestMethod.GET)
	public ModelAndView searchGoosAll(ModelAndView modelAndView,HttpServletRequest reqeust) throws Exception {
		
		List<Goods> list = goodsService.searchGoodsAll();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("goods/goodsList");
		
		return modelAndView;
	}
	
	@RequestMapping(value="goodsView.do",method=RequestMethod.GET)
	public String serchGoods(@RequestParam("code")String code,Model model) throws Exception {
		
		Goods goods = goodsService.searchGoods(code);
		model.addAttribute("goods",goods);
		
		return "goods/goodsView";
	}
	
	@RequestMapping(value="goodsInsert.do",method=RequestMethod.GET)
	public ModelAndView insertGoodsForm(ModelAndView modelAndView) throws Exception {
		
		modelAndView.setViewName("goods/goodsInsertForm");
		return modelAndView;
	}
	
	@RequestMapping(value="goodsInsert.do",method=RequestMethod.POST)
	public ModelAndView insertGoods(ModelAndView modelAndView,Goods goods) throws Exception {
		
		int result = goodsService.insertGoods(goods);
		modelAndView.addObject("result",result);
		modelAndView.setViewName("goods/goodsInsertCom");
		
		return modelAndView;
	}
	
	@RequestMapping(value="goodsUpdate.do",method=RequestMethod.GET)
	public ModelAndView updateGoodsForm(@RequestParam("code")String code,ModelAndView modelAndView) throws Exception {
		
		Goods goods = goodsService.searchGoods(code);
		modelAndView.addObject("goods",goods);
		modelAndView.setViewName("goods/goodsUpdateForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value="goodsUpdate.do",method=RequestMethod.POST)
	public ModelAndView updateGoods(Goods goods,ModelAndView modelAndView) throws Exception {
		
		int result = goodsService.updateGoods(goods);
		modelAndView.addObject("result",result);
		modelAndView.setViewName("goods/goodsUpdateCom");
		
		return modelAndView;
	}
	
	@RequestMapping(value="goodsDelete.do",method=RequestMethod.GET)
	public ModelAndView deleteGoods(Goods goods,ModelAndView modelAndView) throws Exception {
		
		int result = goodsService.deleteGoods(goods);
		modelAndView.addObject("result",result);
		modelAndView.setViewName("goods/goodsDeleteCom");
		
		return modelAndView; 
	}
	
	
}

