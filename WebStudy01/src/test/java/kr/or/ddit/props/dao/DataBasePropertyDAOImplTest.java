package kr.or.ddit.props.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.props.vo.PropertyVO;

public class DataBasePropertyDAOImplTest {
	PropertyDAO dao = new DataBasePropertyDAOImpl();

	@Test
	public void testSelectProperty() {
		PropertyVO vo = dao.selectProperty("1' or '1'='1");
		System.out.println(vo);
//		assertNull(vo);
	}

}
