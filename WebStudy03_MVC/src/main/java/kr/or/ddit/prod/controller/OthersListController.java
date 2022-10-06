package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.AbstractCommandHandler;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.vo.BuyerVO;

//@WebServlet({"/prod/getLprodList.do", "/prod/getBuyerList.do"})
public class OthersListController extends AbstractCommandHandler{
	private OthersDAO othersDAO = new OthersDAOImpl();
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		if("/prod/getLprodList.do".equals(servletPath)) {
			List<Map<String, Object>> lprodList = othersDAO.selectLprodList();
			req.setAttribute("model", lprodList);
		}else if("/prod/getBuyerList.do".equals(servletPath)) {
			String lprodGu = req.getParameter("lprodGu");
			List<BuyerVO> buyerList = othersDAO.selectBuyerList(lprodGu);
			req.setAttribute("model", buyerList);
		}
		return "forward:/jsonView.do";
	}
	

}













