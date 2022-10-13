package kr.or.ddit.board.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.enumpkg.ServiceResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/boardInsert.do")
public class BoardInsertController {
	private final BoardService service;
	
	@GetMapping
	public String boardForm(@ModelAttribute("board") BoardVO board) {
		return "board/boardForm";
	}
	
	@PostMapping
	public String boardInsert(
		@Valid @ModelAttribute("board") BoardVO board
		, Errors errors
		, Model model
	) {
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createBoard(board);
			if(ServiceResult.OK.equals(result)) {
				viewName = "redirect:/board/boardView.do?what="+board.getBoNo();
			}else {
				String message = "등록 실패";
				model.addAttribute("message", message);
				viewName = "board/boardForm";
			}
		}else {
			viewName = "board/boardForm";
		}
		
		
		return viewName;
	}
}




















