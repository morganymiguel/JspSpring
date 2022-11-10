package kr.or.ddit.alba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface AlbaDAO {
	public int insertAlba(AlbaVO alba);
	public int selectAlbaCount(PagingVO<AlbaVO> pagingVO);
	public List<AlbaVO> selectAlbaList(PagingVO<AlbaVO> pagingVO);
	public AlbaVO selectAlba(String al_id);
	public int updateAlba(AlbaVO alba);
	public int deleteAlba(String al_id);
}
