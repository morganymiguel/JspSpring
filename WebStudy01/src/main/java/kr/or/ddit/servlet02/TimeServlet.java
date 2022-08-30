package kr.or.ddit.servlet02;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Model1 vs Model2
 * 
 * Model1: 서블릿이나 JSP 객체 하나로 요청과 응답이 모두 처리되는 구조.
 * Model2: 요청을 전담하는 controller(Servlet)와 응답을 전담하는 View(JSP) 레어어가 하나의 명령을 처리하는 과정에서 사용되는 구조.
 * Controller의 역할: 요청을 전담.
 * 1. 요청 받고
 * 2. 요청 분석
 * 3. 데이터 생성.(응답에 필요한 데이터를 생성해서 담는다.) -> setAttribute
 * 4. 뷰 레이어 선택, 이동(응답을 생성하는 뷰 레이어를 선택하여 이동) 
 * 
 * View 역할(TMPL)
 * 1. 데이터 확보 -> getAttribute(Controller에서 전달한 데이터를 확보)
 * 2. UI 구성 -> HTML source
 * 
 * 
 * 
 * 
 * 
 * 
 */
@WebServlet("/time.do")
//3.대 방식
public class TimeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timeText = String.format("%tc",Calendar.getInstance()); //formatting한다.
		req.setAttribute("timeText", timeText);
		String viewLayer = "";
		
		req.getRequestDispatcher("/WEB-INF/views/tmpl/time.tmpl").forward(req,resp);
//		req.getRequestDispatcher(viewLayer).forward(req,resp);
	}
}
