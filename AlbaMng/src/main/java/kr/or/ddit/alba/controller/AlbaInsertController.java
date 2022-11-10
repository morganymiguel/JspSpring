package kr.or.ddit.alba.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.AlbaVO;

@Controller
public class AlbaInsertController {
	
	@Inject
	AlbaService service;
	
	@ModelAttribute("alba")
	public AlbaVO alba() {
		return new AlbaVO();
	}
	
	@RequestMapping("/alba/albaInsert.do")
	public String form() {
		return "alba/albaForm";
	}
	
	@RequestMapping(value="/alba/albaInsert.do", method=RequestMethod.POST)
	public String insert( 
		@Validated(InsertGroup.class) AlbaVO alba
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	){
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createAlba(alba);
			if(ServiceResult.OK.equals(result)) {
				viewName = "redirect:/alba/albaView.do?who="+alba.getAlId();
			}else {
				redirectAttributes.addFlashAttribute("message", "서버 오류로 등록 실패.");
				redirectAttributes.addFlashAttribute("alba", alba);
			}
		}else {
			viewName = "redirect:/alba/albaInsert.do";
			redirectAttributes.addFlashAttribute("alba", alba);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"alba", errors);
		}
		return viewName;
	}
}
