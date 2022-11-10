package kr.or.ddit.alba.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.PagingVO;

@Controller
public class AlbaRetrieveController {
	
	@Inject
	AlbaService service;

	@RequestMapping({"/index.do", "/alba/albaList.do"})
	public String index(){
		return "alba/albaList";
	}
	
	@RequestMapping(value="/alba/albaList.do", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<AlbaVO> list( @ModelAttribute("searchDetail") AlbaVO detailSearch 
		, @RequestParam(value="page", required=false, defaultValue="1") int currentPage
		, @RequestParam(value="searchType", required=false) String searchType
		, @RequestParam(value="searchWord", required=false) String searchWord
	){

		PagingVO<AlbaVO> pagingVO = new PagingVO<>();
		// 검색 조건
		if(StringUtils.isNotBlank(searchWord) && StringUtils.isNotBlank(searchType)) {
			switch (searchType) {
				case "name":
					detailSearch.setAlName(searchWord.trim());
					break;
				case "address":
					detailSearch.setAlAdd1(searchWord.trim());
					break;
				case "career":
					detailSearch.setAlCareer(searchWord.trim());
					break;
			}
		}
		pagingVO.setDetailCondition(detailSearch);
		
		pagingVO.setCurrentPage(currentPage); 
		
		List<AlbaVO> AlbaList = service.retrieveAlbaList(pagingVO);
		pagingVO.setDataList(AlbaList);
		
		return pagingVO;
	}
	
	@RequestMapping("/alba/albaView.do")
	public String view(@RequestParam("who") String alId, HttpServletRequest req) {
		AlbaVO alba = service.retrieveAlba(alId);
		req.setAttribute("alba", alba);
		return "alba/albaView";
	}
}
