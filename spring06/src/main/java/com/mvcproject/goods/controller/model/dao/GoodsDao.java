package com.mvcproject.goods.controller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.goods.controller.model.vo.Goods;

@Repository
public class GoodsDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public GoodsDao() {
		
	}

	public List<Goods> searchGoodsAll() throws Exception {
		
		List<Goods> list = sqlSession.selectList("Goods.searchGoosAll");
		return list;
	}
	
	public Goods searchGoods(String code) throws Exception {
		Goods goods = sqlSession.selectOne("Goods.searchGoods",code);
		return goods;
	}
	
	public int insertGoods(Goods goods) throws Exception {
		int result = sqlSession.insert("Goods.insertGoods",goods);
		return result;
	}
	
	public int updateGoods(Goods goods) throws Exception {
		int result = sqlSession.update("Goods.updateGoods",goods);
		return result;
	}
	
	public int deleteGoods(Goods goods) throws Exception {
		int result = sqlSession.delete("Goods.deleteGoods",goods);
		return result;
	}
}
