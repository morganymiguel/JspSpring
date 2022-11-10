package kr.or.ddit.common.service;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
@WebAppConfiguration
@Transactional
public class TestServiceTest {

	@Inject
	private TestService service;
	
	@Test
	public void testRetrieveMember() {
		MemberVO one = service.retrieveMember("a001");
		log.info("member : {}", one);
	}
	
	@Test
	public void testRetrieveList() {
		List<MemberVO> list = service.retrieveList1();
		log.info("list : {}", list);
	}

	@Test
	public void testRetrieveList2() {
		List<MemberVO> list = service.retrieveList2();
		log.info("list : {}", list);
	}

}
