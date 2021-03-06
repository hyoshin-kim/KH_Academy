package com.mvcproject.board.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcproject.board.controller.model.dao.BoardDao;
import com.mvcproject.board.controller.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;

	@Override
	public int totalCount() {
		return boardDao.listCount();
	}

	@Override
	public List<Board> selectList(int startPage, int limit) {
		return boardDao.selectList(startPage, limit);
	}

	@Override
	public List<Board> selectSearch(String keyword) {
		return boardDao.searchList(keyword);

	}
}
