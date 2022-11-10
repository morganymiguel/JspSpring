package kr.or.ddit;

import java.util.Date;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.security.annotation.AuthMember;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@RequestMapping("/index.do")
	public String index(Model model) {
		Date now = new Date();
		model.addAttribute("now", now);
		return "index";
	}
	
	@RequestMapping("/after/index.do")
	public String indexLogin(
		@AuthenticationPrincipal MemberVOWrapper wrapper	
		, @AuthenticationPrincipal(expression="realUser") MemberVO authMember1	
		, @AuthMember MemberVO authMember2	
		, @SessionAttribute("authMember") MemberVO authMember3
		, Model model
	) {
		log.info("현재 사용자 wrapper : {}", wrapper);
		log.info("현재 사용자 authMember1 : {}", authMember1);
		log.info("현재 사용자 authMember2 : {}", authMember2);
		log.info("현재 사용자 authMember3 : {}", authMember3);
		Date now = new Date();
		model.addAttribute("now", now);
		return "index";
	}
}
