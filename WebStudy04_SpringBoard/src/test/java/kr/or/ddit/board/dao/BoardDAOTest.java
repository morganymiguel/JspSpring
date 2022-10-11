package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;

	@Test
	public void testSelectBoard() {
		log.info("주입된 객체: {}", dao);
	}

}
