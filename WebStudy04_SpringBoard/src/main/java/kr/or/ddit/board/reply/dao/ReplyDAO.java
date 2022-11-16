package kr.or.ddit.board.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.board.vo.ReplyVO;

@Mapper
public interface ReplyDAO {
	public int selectTotalRecord(PagingVO<ReplyVO> pagingVO);
	public List<ReplyVO> selectReplyList(PagingVO<ReplyVO> pagingVO);
	public int insertReply(ReplyVO reply);
}
