package kr.or.ddit.alba.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
import kr.or.ddit.vo.PagingVO;

public interface AlbaService {
	public ServiceResult createAlba(AlbaVO alba);
	public List<AlbaVO> retrieveAlbaList(PagingVO<AlbaVO> pagingVO);
	public AlbaVO retrieveAlba(String al_id);
	public ServiceResult modifyAlba(AlbaVO alba);
	public ServiceResult removeAlba(String al_id);
	
	public LicenseVO retrieveLicense(LicenseVO licAlba);
}
