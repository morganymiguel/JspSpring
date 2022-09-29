package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.EmpVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/emp/empList.do")
public class EmpListServlet extends HttpServlet {
	private EmpService service = new EmpServiceImpl();

	private void viewResolve(String logicalViewName, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (logicalViewName.startsWith("redirect:")) {
			logicalViewName = logicalViewName.substring("redirect:".length());
			resp.sendRedirect(req.getContextPath() + logicalViewName);
		} else {
			String viewName = "/" + logicalViewName + ".tiles";
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

//		String prodLgu = req.getParameter("prodLgu");
		EmpVO detailCondition = new EmpVO();
//		detailCondition.setProdLgu(prodLgu);
		try {
			BeanUtils.populate(detailCondition, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}


		List<ProdVO> prodList = service.retrieveEmpList();

//		req.setAttribute("prodList", prodList);
		req.setAttribute("pagingVO", pagingVO);
		String logicalViewName = "prod/prodList";
		viewResolve(logicalViewName, req, resp);
	}
}
