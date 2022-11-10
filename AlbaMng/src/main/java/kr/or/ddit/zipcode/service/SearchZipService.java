package kr.or.ddit.zipcode.service;

import java.util.List;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ZipVO;

public interface SearchZipService {
	public int retrieveZipCount(PagingVO<ZipVO> pagingVO);
	public List<ZipVO> retrieveZipList(PagingVO<ZipVO> pagingVO);
}
