package kr.or.ddit.props.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.props.vo.PropertyVO;

public class FileSystemPropertyDAOImplTest {

	PropertyDAO dao = new FileSystemPropertyDAOImpl();
	
//	@Test
	public void testSelectProperty() {
		PropertyVO propertyVO = dao.selectProperty("prop1");
		assertNotNull(propertyVO);
	}

	@Test
	public void testSelectProperties() {
		List<PropertyVO> dataList = dao.selectProperties();
		assertNotNull(dataList);
		assertNotEquals(0, dataList.size());
		assertEquals(3, dataList.size());
	}

//	@Test
	public void testInsertProperty() {
		PropertyVO vo = new PropertyVO();
		vo.setPropertyName("prop3");
		vo.setPropertyValue("value3");
		dao.insertProperty(vo);
	}

}




























