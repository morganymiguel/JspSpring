package kr.or.ddit.alba.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;

@Mapper
public interface LicenseDAO {
	public int insertLicenses(AlbaVO alba);
	public int deleteLicenses(AlbaVO alba);
	public LicenseVO selectLicense(LicenseVO licAlba);
}
