package kr.or.ddit.emp.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import kr.or.ddit.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EmpServiceImplTest {
	
	EmpService service = new EmpServiceImpl();
	
	@Test
	public void testRetrieveEmp() {
		
		EmpVO emp = service.retrieveEmp(7369);
		assertNotNull(emp);
		log.info("emp : \n{}", emp);
	
	}

	@Test
	public void testCreateEmp() {
		fail("Not yet implemented");
	}

}
