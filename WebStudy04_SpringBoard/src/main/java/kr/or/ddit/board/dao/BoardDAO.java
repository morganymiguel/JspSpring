package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.BoardVO;

/**
 *  게시판 관리(CRUD)용 Persistence Layer
 *
 */

@Mapper
public interface BoardDAO {
//	insertBoard
	public BoardVO selectBoard(int boNo);
	public List<BoardVO> selectBoardList();
	public BoardVO selectTotalRecord();
//	updateBoard
//	deleteBoard
	
}
