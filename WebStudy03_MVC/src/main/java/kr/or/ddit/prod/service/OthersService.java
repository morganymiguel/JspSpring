package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.BuyerVO;

public interface OthersService {
	public List<Map <String, Object>> selectLprodList();
	public List<BuyerVO> selectBuyerList(@Param("lprodGu") String lprodl);
}
