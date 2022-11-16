package kr.or.ddit.etc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.etc.vo.InnerVO;
import kr.or.ddit.etc.vo.OuterVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/etc/hasAgg2")
@SessionAttributes({"inner", "outer"})
public class HasAggregationController2 {
	@ModelAttribute("outer")
	public OuterVO inner (@ModelAttribute("inner") InnerVO inner) {
		OuterVO outer = new OuterVO();
		outer.setInner(inner);
		return outer;
	}
	
	@GetMapping
	public String form(){
		return "etc/outerForm";
	}
	
	@PostMapping
	public String process(
		@Valid	@ModelAttribute("outer")OuterVO outer
		, BindingResult errors
		, RedirectAttributes redirectAttributes
		, SessionStatus sessionStatus){
		log.info("outer vo : {}", outer);
		if(errors.hasErrors()){
			String errorsName = BindingResult.MODEL_KEY_PREFIX+"outer";
			redirectAttributes.addFlashAttribute(errorsName, errors);
			return "redirect:/etc/hasAgg2";
		}else {
			sessionStatus.setComplete();
			redirectAttributes.addFlashAttribute("message", "Has 바인드 데이터 사용 완료(SessionStatus.setComplete)");
			return "redirect:/etc/hasAgg1";
		}
	}
}
