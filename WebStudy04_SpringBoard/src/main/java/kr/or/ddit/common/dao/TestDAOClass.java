package kr.or.ddit.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TestDAOClass extends AbstractCommonDAO<MemberVO>{

	public TestDAOClass(SqlSessionTemplate session) {
		super(session);
		log.info("주입된 sqlSessionTemplate : {}", session);
	}
}
