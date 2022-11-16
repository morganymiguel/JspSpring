package kr.or.ddit.board.reply.service;

import java.util.List;

import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.enumpkg.ServiceResult;

public interface ReplyService {
	public List<ReplyVO> retrieveReplyList(PagingVO<ReplyVO> pagingVO);
	public ServiceResult createReply(ReplyVO reply);
}
