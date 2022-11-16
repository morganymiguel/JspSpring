package kr.or.ddit.etc.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dynamic")
public class DynamicUIGeneratController {
	private Map<String, List<Object>> savedCssAttr = new LinkedHashMap<>();
	
	@PostConstruct
	public void init() {
		savedCssAttr.put("case1", Arrays.asList(0, 0, "blue"));
		savedCssAttr.put("case2", Arrays.asList(0, 1, "red"));
		savedCssAttr.put("case3", Arrays.asList(1, 0, "yellow"));
		savedCssAttr.put("case4", Arrays.asList(1, 1, "green"));
	}
	
	@RequestMapping("uiGen.do")
	public String viewController(Model model) {
		model.addAttribute("caseIds", savedCssAttr.keySet());
		return "etc/dynamic";
	}
	
	@RequestMapping(value="genStyle.css", produces="text/css")
	@ResponseBody
	public String cssController(@RequestParam(required=true) String caseId) {
		List<Object> styleAttribute = savedCssAttr.get(caseId);
		String target = String.format("row%d_col%d"
									, styleAttribute.get(0), styleAttribute.get(1));
		return String.format(pattern, target, styleAttribute.get(2));
	}
	
	String pattern = "#%s { background-color:%s; }";
}
