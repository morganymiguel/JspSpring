package kr.or.ddit.alba.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LicenseVO;

@Mapper
public interface CodeDAO {
	public List<LicenseVO> selectLicenseList();
	public List<Map<String, String>> selectGradeList();
}
