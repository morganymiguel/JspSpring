package kr.or.ddit.emp.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.request.Request;

import kr.or.ddit.vo.MenuVO;

public class EmpViewPreparer {
	@Override
	public void execute(Request req, AttributeContext context) {
		MenuVO menu1 = new MenuVO("/emp/empList.do", "사원조회");
		MenuVO menu2 = new MenuVO("/emp/empInsert.do", "신입사원등록");
		List<MenuVO> menuList = Arrays.asList(menu1, menu2);
		Map<String, Object> requestScope = req.getContext(Request.REQUEST_SCOPE);
		requestScope.put("menuList", menuList);
	}

}
