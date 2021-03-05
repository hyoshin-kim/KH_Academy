package com.mvcproject.goods.controller.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcproject.goods.controller.model.dao.GoodsDao;
import com.mvcproject.goods.controller.model.vo.Goods;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsDao goodsDao;
	
	@Override
	public List<Goods> searchGoodsAll() throws Exception {
		List<Goods> list = goodsDao.searchGoodsAll();
		return list;
	}

	@Override
	public Goods searchGoods(String code) throws Exception {
		Goods goods = goodsDao.searchGoods(code);
		return goods;
	}
	
	@Override
	public int insertGoods(Goods goods) throws Exception {
		int result = goodsDao.insertGoods(goods);
		return result;
	}
	
	@Override
	public int updateGoods(Goods goods) throws Exception {
		int result = goodsDao.updateGoods(goods);
		return result;
	}
	
	@Override
	public int deleteGoods(Goods goods) throws Exception {
		int result = goodsDao.deleteGoods(goods);
		return result;
	}
}
