package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionFactory sqlSessionFactory = 
				CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//			int rowcnt = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapper.insertMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			return mapper.selectMember(memId);
		}
	}

	@Override
	public int selectTotalRecord(PagingVO pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//				return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}
	
	@Override
	public List<MemberVO> selectMemberList(PagingVO pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//			return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			return mapper.selectMemberList(pagingVO);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//			int rowcnt = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.updateMember", member);
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapper.updateMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
//			int rowcnt = sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.deleteMember", memId);
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapper.deleteMember(memId);
			sqlSession.commit();
			return rowcnt;
		}
	}

}
