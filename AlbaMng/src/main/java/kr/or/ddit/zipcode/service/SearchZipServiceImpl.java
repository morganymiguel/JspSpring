package kr.or.ddit.zipcode.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ZipVO;
import kr.or.ddit.zipcode.dao.SearchZipDAO;

@Service
public class SearchZipServiceImpl implements SearchZipService {
	@Inject
	private SearchZipDAO dao;
	
	@Override
	public int retrieveZipCount(PagingVO<ZipVO> pagingVO) {
		return dao.selectZipCount(pagingVO);
	}
	
	@Override
	public List<ZipVO> retrieveZipList(PagingVO<ZipVO> pagingVO) {
		return dao.selectZipList(pagingVO);
	}

}
