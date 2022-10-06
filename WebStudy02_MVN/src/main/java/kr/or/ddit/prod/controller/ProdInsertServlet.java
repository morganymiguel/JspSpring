package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.file.MultipartFile;
import kr.or.ddit.file.filter.StandardMultipartHttpServletRequest;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
@MultipartConfig
public class ProdInsertServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	private OthersDAO othersDAO = new OthersDAOImpl();
	
	String saveFolderURL = "/resources/prodImages";
	File saveFolder;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String saveFolderPath = getServletContext().getRealPath(saveFolderURL);
		saveFolder = new File(saveFolderPath);
		if(!saveFolder.exists()) saveFolder.mkdirs();
	}
	
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
		
		req.setAttribute("command", "INSERT");
		
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "prod/prodForm";
		viewResolve(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		try {
			BeanUtils.populate(prod, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		if(req instanceof StandardMultipartHttpServletRequest) {
			MultipartFile prodImage = ((StandardMultipartHttpServletRequest) req).getFile("prodImage");
			prod.setProdImage(prodImage);
			prod.saveTo(saveFolder);
		}
		
		Map<String, String> errors = new ValidateUtils<ProdVO>().validate(prod, InsertGroup.class);
		req.setAttribute("errors", errors);
		
		String logicalViewName = null;
		if(errors.isEmpty()) {
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
	
}












