package kr.or.ddit.board.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.reply.dao.ReplyDAO;
import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.enumpkg.ServiceResult;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;
	
	@Inject
	private PasswordEncoder passwordEncoder;

	@Override
	public List<ReplyVO> retrieveReplyList(PagingVO<ReplyVO> pagingVO) {
		// 페이징 처리시 필요
//		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(dao.selectReplyList(pagingVO));
		return pagingVO.getDataList();
	}

	@Override
	public ServiceResult createReply(ReplyVO reply) {
		String encoded = passwordEncoder.encode(reply.getRepPass());
		reply.setRepPass(encoded);
		return dao.insertReply(reply)>0 ? ServiceResult.OK : ServiceResult.FAIL; 
	}

}
