package kr.or.ddit.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardViewController {
	private final BoardService service;
	
	@RequestMapping("/board/boardView.do")
	public ModelAndView boardView(@RequestParam(name="what", required=true) int boNo) {
		BoardVO board = service.retrieveBoard(boNo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("board/boardView");
		return mav;
	}
}
