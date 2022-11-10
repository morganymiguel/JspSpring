package kr.or.ddit.alba.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.alba.dao.CodeDAO;
import kr.or.ddit.vo.LicenseVO;

@Controller
public class CodeRetrieveController {

	@Inject
	CodeDAO codeDAO;
	
	@RequestMapping("/alba/getLicenseList.do")
	@ResponseBody
	public List<LicenseVO> getLicenseList(HttpServletResponse resp){
		return codeDAO.selectLicenseList();
	}
	
	@RequestMapping("/alba/getGradeList.do")
	@ResponseBody
	public List<Map<String, String>> getGradeList(HttpServletResponse resp){
		return codeDAO.selectGradeList();
	}
}
