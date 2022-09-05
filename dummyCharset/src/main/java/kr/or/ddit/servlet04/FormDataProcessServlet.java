package kr.or.ddit.servlet04;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/formDataProcess")
public class FormDataProcessServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		paramIpt1: value
//		String paramIpt1 = req.getParameter("paramIpt1");
		req.setCharacterEncoding("UTF-8");
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		for(Entry<String, String[]> entry: parameterMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s \n", paramName, Arrays.toString(paramValues));
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8"); doGet방식에서는 작동이 안됨. body는 post방식에서만
		//데이터를 꺼내기 전에 encoding방식을 설정해야한다.
		req.setCharacterEncoding("UTF-8");
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		for(Entry<String, String[]> entry: parameterMap.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			System.out.printf("%s : %s \n", paramName, Arrays.toString(paramValues));
		}
		
		
	
	}
}
