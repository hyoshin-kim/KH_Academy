package com.mvcproject.board.controller.service;

import java.util.List;

import com.mvcproject.board.controller.model.vo.Board;

public interface BoardService {
	
	 public int totalCount();
	 public List<Board> selectList(int startPage, int limit);
	 public List<Board> selectSearch(String keyword);
}
