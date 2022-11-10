package kr.or.ddit.alba.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.enumpkg.ServiceResult;

@Controller
public class AlbaDeleteController{
	@Inject
	AlbaService service;
	@RequestMapping("/alba/albaDelete.do")
	public String doGet(@RequestParam("who") String who, RedirectAttributes redirectAttributes){
		String viewName = null;
		ServiceResult result = service.removeAlba(who);
		if(ServiceResult.OK.equals(result)){
			viewName = "redirect:/alba/albaList.do";
		}else{
			redirectAttributes.addFlashAttribute("message", "서버 오류로 인해 삭제 실패");
			viewName = "redirect:/alba/albaView.do?who="+who;
		}
		
		return viewName;
	}
}
