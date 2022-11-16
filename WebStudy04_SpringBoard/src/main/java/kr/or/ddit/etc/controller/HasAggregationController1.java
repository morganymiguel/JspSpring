package kr.or.ddit.etc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.etc.vo.InnerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/etc/hasAgg1")
@SessionAttributes("inner")
public class HasAggregationController1 {
	@ModelAttribute("inner")
	public InnerVO inner () {
		return new InnerVO();
	}
	
	@GetMapping
	public String form(){
		return "etc/innerForm";
	}
	
	@PostMapping
	public String process(
		@Valid @ModelAttribute("inner")InnerVO inner
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	){
		log.info("inner vo : {}", inner);
		if(errors.hasErrors()) {
			String errorsName = BindingResult.MODEL_KEY_PREFIX+"inner";
			redirectAttributes.addFlashAttribute(errorsName, errors);
			return "redirect:/etc/hasAgg1";
		}else {
			return "redirect:/etc/hasAgg2";
		}
	}
}
