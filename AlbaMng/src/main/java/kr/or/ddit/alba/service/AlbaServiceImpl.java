package kr.or.ddit.alba.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.alba.dao.AlbaDAO;
import kr.or.ddit.alba.dao.LicenseDAO;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class AlbaServiceImpl implements AlbaService {
	@Inject
	private AlbaDAO albaDAO;
	@Inject
	private LicenseDAO licDAO;
	
//	=============== File process===================================================================
	@Value("#{appInfo['profile.image']}")
	private Resource profileRes;
	private File profileFolder;
	
	@PostConstruct
	public void init() throws IOException {
		this.profileFolder = profileRes.getFile();
		if(!profileFolder.exists())
			profileFolder.mkdirs();
	}
	
	private void deleteProfile(AlbaVO alba) {
		String savedImg = alba.getAlImg();
		if(StringUtils.isNotBlank(savedImg)) {
			(new File(profileFolder, savedImg)).delete();
		}
	}
	private void processProfile(AlbaVO alba) {
		MultipartFile profile = alba.getAlImage();
		try {
			if(profile!=null)
				profile.transferTo(new File(profileFolder, alba.getAlImg()));
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
//	===============================================================================================

	@Override
	public ServiceResult createAlba(AlbaVO alba) {
		int rowcnt = albaDAO.insertAlba(alba);
		ServiceResult result = ServiceResult.FAIL;
		if(alba.getLicCodes()!=null) {
			rowcnt += licDAO.insertLicenses(alba);
		}
		if(rowcnt>0) {
			processProfile(alba);
			result = ServiceResult.OK;
		}
		return result;
	}


	@Override
	public List<AlbaVO> retrieveAlbaList(PagingVO<AlbaVO> pagingVO) {
		pagingVO.setTotalRecord(albaDAO.selectAlbaCount(pagingVO)); // totalPage
		List<AlbaVO> albaList =  albaDAO.selectAlbaList(pagingVO);
		pagingVO.setDataList(albaList);
		return albaList;
	}
	
	@Override
	public AlbaVO retrieveAlba(String al_id) {
		AlbaVO alba = albaDAO.selectAlba(al_id);
		if(alba==null)
			throw new PKNotFoundException(String.format("PK-'%s' 로 식별되는 데이터가 없음.", al_id));
		return alba;
	}

	@Override
	public ServiceResult modifyAlba(AlbaVO alba) {
		AlbaVO saved = albaDAO.selectAlba(alba.getAlId());
		int rowcnt = albaDAO.updateAlba(alba);
		ServiceResult result = ServiceResult.FAIL;
		String[] deleteLicCodes = alba.getDeleteLicCodes();
		if(deleteLicCodes!=null && deleteLicCodes.length>0) {
			rowcnt += licDAO.deleteLicenses(alba);
		}
		if(alba.getLicenseList()!=null) {
			rowcnt += licDAO.insertLicenses(alba);
		}
		if(rowcnt>0) {
			if(alba.getAlImage()!=null) {
				deleteProfile(saved);
				processProfile(alba);
			}
			result = ServiceResult.OK;
		}
		return result;
	}

	@Override
	public ServiceResult removeAlba(String al_id) {
		AlbaVO saved = albaDAO.selectAlba(al_id);
		int rowcnt = albaDAO.deleteAlba(al_id);
		ServiceResult result = ServiceResult.FAIL;
		if(rowcnt>0) {
			deleteProfile(saved);
			result = ServiceResult.OK;
		}
		return result;
	}
	
	@Override
	public LicenseVO retrieveLicense(LicenseVO licAlba) {
		return licDAO.selectLicense(licAlba);
	}
}
