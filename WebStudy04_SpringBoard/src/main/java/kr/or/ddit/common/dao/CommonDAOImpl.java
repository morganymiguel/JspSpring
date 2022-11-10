package kr.or.ddit.common.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.vo.PagingVO;

@Repository
public class CommonDAOImpl {
	@Inject
	private SqlSessionTemplate session;
	
	public <T,P> List<P> selectList(Class<T> type, PagingVO<P> data) {
		return session.selectList(type.getName()+".selectList", data);
	}
	public <T,P> int selectCount(Class<T> type, PagingVO<P> data) {
		return session.selectOne(type.getName()+".selectCount", data);
	}
	public <T,P,R> R selectOne(Class<T> type, P data) {
		return session.selectOne(type.getName()+".selectObject", data);
	}
	public <T,P> int insert(Class<T> type, P data) {
		return session.insert(type.getName()+".insert", data);
	}
	public <T,P> int update(Class<T> type, P data) {
		return session.insert(type.getName()+".update", data);
	}
	public <T,P> int delete(Class<T> type, P data) {
		return session.insert(type.getName()+".delete", data);
	}
}
