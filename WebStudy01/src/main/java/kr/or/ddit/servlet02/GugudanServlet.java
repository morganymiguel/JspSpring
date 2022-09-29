package kr.or.ddit.servlet02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan.do")
public class GugudanServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StringBuffer gugudan = new StringBuffer();
		StringBuffer options = new StringBuffer();
		
		String strMin = req.getParameter("minDan");
		String strMax = req.getParameter("maxDan");
		
		if(strMin == null) {
			strMin = "2";
		}
		if(strMax == null) {
			strMax = "9";
		}
		
		if(!strMin.matches("[2-9]") || !strMax.matches("[2-9]")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "2단부터 9단까지 범위내 파라미터만 가능.");
			return;
		}
		
		int min = Integer.parseInt(strMin);
		int max = Integer.parseInt(strMax);
		
		for(int i=2;i<10;i++) {
			options.append(String.format("<option value='%d'>%d</option>", i,i));
		}
		
		for(int i = min ; i <= max ; i++) {
			gugudan.append("<tr>") ;
			for(int j = 1 ; j < 10 ; j++) {
				gugudan.append(String.format("<td> %d * %d = %d </td>", i, j, i*j));
			}
			gugudan.append("</tr>") ;
		}
		
		
//		X-Requested-With: XMLHttpRequest , AJAX (Async Javascript And XMLHttpRequest)
		
		String header = req.getHeader("X-Requested-With");
		
		if("XMLHttpRequest".equals(header)) {
			try(
				PrintWriter out = resp.getWriter();
			){
				out.println(gugudan);
			}
		}else {
			req.setAttribute("gugudan", gugudan);
			req.setAttribute("options", options);
			req.setAttribute("minDan", min);
			req.setAttribute("maxDan", max);
			String viewLayer = "/WEB-INF/views/tmpl/gugudan.tmpl";
			req.getRequestDispatcher(viewLayer).forward(req, resp);
		}
		
		
	}
}







