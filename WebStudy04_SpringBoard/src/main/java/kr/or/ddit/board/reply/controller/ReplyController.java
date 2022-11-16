package kr.or.ddit.board.reply.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.board.reply.service.ReplyService;
import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.validate.InsertGroup;

@RestController
@RequestMapping(value="/board/{boNo}/reply", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReplyController {
	@Inject
	private ReplyService service;
	
	@GetMapping
	public PagingVO<ReplyVO> replyList(
		ReplyVO detailCondition
		, @RequestParam(name="page", required=false, defaultValue="1") int currentPage
	) {
		PagingVO<ReplyVO> pagingVO = new PagingVO<>();
		pagingVO.setDetailCondition(detailCondition);
		pagingVO.setCurrentPage(currentPage);

		service.retrieveReplyList(pagingVO);
		
		return pagingVO;
	}
	
	@PostMapping
	public Map<String, Object> replyList(
		@Validated(InsertGroup.class) @ModelAttribute ReplyVO reply
		, Errors errors
	) {
		Map<String, Object> result = new HashMap<>();
		if(!errors.hasErrors()) {
			result.put("result", service.createReply(reply));
		}else {
			result.put("errors", errors.getFieldErrorCount());
		}
		return result;
	}
}
