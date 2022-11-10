package kr.or.ddit.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.or.ddit.board.vo.PagingVO;

public abstract class AbstractCommonDAO<D> {
	private SqlSessionTemplate session;
	public AbstractCommonDAO(SqlSessionTemplate session) {
		super();
		this.session = session;
	}
	
	public List<D> selectList(PagingVO<D> data) {
		return session.selectList(this.getClass().getName()+".selectList", data);
	}
	public int selectCount(PagingVO<D> data) {
		return session.selectOne(this.getClass().getName()+".selectCount", data);
	}
	public D selectOne(Object data) {
		return session.selectOne(this.getClass().getName()+".selectObject", data);
	}
	public int insert(D data) {
		return session.insert(this.getClass().getName()+".insert", data);
	}
	public int update(D data) {
		return session.insert(this.getClass().getName()+".update", data);
	}
	public int delete(D data) {
		return session.insert(this.getClass().getName()+".delete", data);
	}
}
