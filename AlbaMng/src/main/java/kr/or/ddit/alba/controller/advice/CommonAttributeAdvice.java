package kr.or.ddit.alba.controller.advice;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.or.ddit.alba.dao.CodeDAO;
import kr.or.ddit.vo.LicenseVO;

@ControllerAdvice
public class CommonAttributeAdvice {
	@Inject
	CodeDAO codeDAO;
	
	@ModelAttribute("licenses")
	public List<LicenseVO> licenses(){
		return codeDAO.selectLicenseList();
	}
	
	@ModelAttribute("grades")
	public List<Map<String, String>> grades() {
		return codeDAO.selectGradeList();
	}
}
