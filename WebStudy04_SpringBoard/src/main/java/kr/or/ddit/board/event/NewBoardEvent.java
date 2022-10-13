package kr.or.ddit.board.event;

import kr.or.ddit.board.vo.BoardVO;

public class NewBoardEvent {
	private BoardVO source;
	
	public NewBoardEvent(BoardVO source){
		this.source = source;
	}
	
	public BoardVO getSource() {
		return source;
	}
}
