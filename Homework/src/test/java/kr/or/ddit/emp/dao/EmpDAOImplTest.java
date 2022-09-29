package kr.or.ddit.emp.dao;


import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EmpDAOImplTest {
	
	EmpDAO dao = new EmpDAOImpl();
	EmpVO emp;	
	
	@Before
	public void setUp() {
		emp = new EmpVO();
		
		
	}
	

	
	@Test
	public void testSelectEmp() {
		emp = dao.selectEmp(7369);
		System.out.println(emp);
	}

	@Test
	public void testInsertEmp() {
		int rowcnt = dao.insertEmp(emp);
//		int rowcnt = dao.insertProd(prod);
//		assertEquals(1, rowcnt);
		
	}

}
