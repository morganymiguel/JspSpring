package kr.or.ddit.zipcode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ZipVO;

@Mapper
public interface SearchZipDAO {
	public int selectZipCount(PagingVO<ZipVO> pagingVO);
	public List<ZipVO> selectZipList(PagingVO<ZipVO> pagingVO);
}
