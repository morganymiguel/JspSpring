package kr.or.ddit.zipcode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.ZipVO;
import kr.or.ddit.zipcode.service.SearchZipService;

@Controller
public class SearchZipController{
	@Inject
	private SearchZipService service;
	
	@RequestMapping("/commons/searchZip.do")
	public String doGet(
			@RequestParam(value="draw", required=false, defaultValue="1") String draw
			, @RequestParam(value="length", required=false, defaultValue="7") int screenSize
			, @RequestParam(value="start", required=false, defaultValue="0") String start
			, @RequestParam(value="search[value]", required=false) String searchWord
			, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int currentPage = StringUtils.isNumeric(start)?Integer.parseInt(start)/screenSize + 1 : 1;
			
		PagingVO<ZipVO> pagingVO = new PagingVO<>(screenSize, 5);
		// 검색 전 레코드 수
		int recordsTotal = service.retrieveZipCount(pagingVO);
		
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(new SearchVO(null, searchWord));
		// 검색 후 레코드 수
		int recordsFiltered = service.retrieveZipCount(pagingVO);
		
		List<ZipVO> zipList = service.retrieveZipList(pagingVO);
		
		Map<String, Object> respMap = new HashMap<>();
		
		respMap.put("draw", draw);
		respMap.put("recordsTotal", recordsTotal);
		respMap.put("recordsFiltered", recordsFiltered);
		respMap.put("data", zipList);
		
		
		resp.setContentType("application/json;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		try(
			PrintWriter out = resp.getWriter();	
		){
			mapper.writeValue(out, respMap);
		}
		
		return null;	
	}
}













