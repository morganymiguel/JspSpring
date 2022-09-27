package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ProdVO;

public interface ProdService {
	public ServiceResult createProd(ProdVO prod);
	public ProdVO retrieveProd(String prodId);
	public List<ProdVO>retrieveProdList();
	public ServiceResult modifyProd(ProdVO prod);
}
