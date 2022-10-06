package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.vo.BuyerVO;

public class OthersServiceImpl implements OthersService {
	private OthersDAO dao = new OthersDAOImpl();
	@Override
	public List<Map<String, Object>> selectLprodList() {
		
		return null;
	}

	@Override
	public List<BuyerVO> selectBuyerList(String lprodl) {
		
		return null;
	}

}
