package kr.or.ddit.alba.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.AlbaVO;

@Controller
public class AlbaUpdateController{
	@Inject
	AlbaService service;
	
	@RequestMapping("/alba/albaUpdate.do")
	public String doGet(@RequestParam("who") String who, Model model){
		AlbaVO alba = service.retrieveAlba(who);
		model.addAttribute("alba", alba);
		return "alba/albaForm";
	}

	@RequestMapping(value="/alba/albaUpdate.do", method=RequestMethod.POST)
	public String update( 
			@Validated(UpdateGroup.class) AlbaVO alba
			, Errors errors
			, RedirectAttributes redirectAttributes
	){
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyAlba(alba);
			if(ServiceResult.OK.equals(result)) {
				viewName = "redirect:/alba/albaView.do?who="+alba.getAlId();
			}else {
				redirectAttributes.addFlashAttribute("message", "서버 오류로 등록 실패.");
				redirectAttributes.addFlashAttribute("alba", alba);
			}
		}else {
			viewName = "redirect:/alba/albaUpdate.do?who="+alba.getAlId();
			redirectAttributes.addFlashAttribute("alba", alba);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "alba", errors);
		}
		return viewName;
	}
}
