package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
public class ProdInsertServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	private OthersDAO othersDAO = new OthersDAOImpl();
	
	private void viewResolve(
			String logicalViewName, 
			HttpServletRequest req, 
			HttpServletResponse resp
	) throws ServletException, IOException{
		if(logicalViewName.startsWith("redirect:")) {
			logicalViewName = logicalViewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + logicalViewName);
		}else {
			String viewName = "/"+logicalViewName+".tiles";
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map<String, Object>> lprodList = othersDAO.selectLprodList();
		List<BuyerVO> buyerList = othersDAO.selectBuyerList(null);
		req.setAttribute("lprodList", lprodList);
		req.setAttribute("buyerList", buyerList);
		
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "prod/prodForm";
		viewResolve(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		try {
			BeanUtils.populate(prod, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		Map<String, String> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = validate(prod, errors);
		
		String logicalViewName = null;
		if(valid) {
			ServiceResult result = service.createProd(prod);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId();
				break;

			default:
				req.setAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "prod/prodForm";
				break;
			}
		}else {
			logicalViewName = "prod/prodForm";
		}
		viewResolve(logicalViewName, req, resp);
	}
	
	// Hibernate validator 
	private boolean validate(ProdVO prod, Map<String, String> errors) {
		boolean valid = true;
//		if (StringUtils.isBlank(prod.getProdId())) {
//			errors.put("prodId", "상품코드누락");
//			valid = false;
//		}
		if (StringUtils.isBlank(prod.getProdName())) {
			errors.put("prodName", "상품명누락");
			valid = false;
		}
		if (StringUtils.isBlank(prod.getProdLgu())) {
			errors.put("prodLgu", "분류코드누락");
			valid = false;
		}
		if (StringUtils.isBlank(prod.getProdBuyer())) {
			errors.put("prodBuyer", "거래처코드누락");
			valid = false;
		}
		if (prod.getProdCost()<0) {
			errors.put("prodCost", "구매가누락");
			valid = false;
		}
		if (prod.getProdPrice()<0) {
			errors.put("prodPrice", "판매가누락");
			valid = false;
		}
		if (prod.getProdSale()<0) {
			errors.put("prodSale", "세일가누락");
			valid = false;
		}
		if (StringUtils.isBlank(prod.getProdOutline())) {
			errors.put("prodOutline", "개요누락");
			valid = false;
		}
		if (StringUtils.isBlank(prod.getProdImg())) {
			errors.put("prodImg", "상품이미지누락");
			valid = false;
		}
		if (prod.getProdTotalstock()<0) {
			errors.put("prodTotalstock", "총재고누락");
			valid = false;
		}
		if (prod.getProdProperstock()<0) {
			errors.put("prodProperstock", "적정재고누락");
			valid = false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotBlank(prod.getProdInsdate())) {
			try {
				sdf.parse(prod.getProdInsdate());
			} catch (ParseException e) {
				errors.put("ProdInsdate", "날짜 형식 확인");
				valid = false;
			}			
		}
		return valid;
		
	}
}












