	package kr.or.ddit.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.enumpkg.ServiceResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;

	@Inject
	public BoardServiceImpl(BoardDAO boardDAO) {
		super();
		this.boardDAO = boardDAO;
		log.info("주입된 객체 : {}", boardDAO);
	}
	
	@Override
	public ServiceResult createBoard(BoardVO board) {
		int rowcnt = boardDAO.insertBoard(board);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public BoardVO retrieveBoard(int boNo) {
		BoardVO board = boardDAO.selectBoard(boNo);
		if(board==null)
			throw new RuntimeException(String.format("%d 글번호의 글이 없음.", boNo));
		boardDAO.incrementBoHit(boNo);
		return board;
	}

	@Override
	public List<BoardVO> retrieveBoardList(PagingVO<BoardVO> pagingVO) {
		return boardDAO.selectBoardList(pagingVO)
				;
	}

	@Override
	public int retrieveBoardCount(PagingVO<BoardVO> pagingVO) {
		return boardDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public ServiceResult modifyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


















