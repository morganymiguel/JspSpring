package kr.or.ddit.alba.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.vo.LicenseVO;

@Controller
public class LicenseImageViewController {
	@Inject
	AlbaService service;
	
	@RequestMapping("/alba/licenseImage.do")
	public String licenseImage(
			@RequestParam("alId") String alId
			, @RequestParam("licCode") String licCode
			, Model model
	){
		LicenseVO licAlba = LicenseVO.builder()
									.alId(alId)
									.licCode(licCode)
									.build();
		LicenseVO license = service.retrieveLicense(licAlba);
		model.addAttribute("license", license);
		return "licenseImageView";
	}
	
}
