package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.EmpVO;

public class EmpDAOImpl implements EmpDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	public List<EmpVO> selectEmpList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
			return mapper.selectEmpList();
		}
	}

	public EmpVO selectEmp(int empNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
			return mapper.selectEmp(empNo);
		}
	}

	public int insertEmp(EmpVO emp) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
			return mapper.insertEmp(emp);
		}
	}

	public int updateEmp(EmpVO emp) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
			return mapper.updateEmp(emp);
		}
	}

	public int deleteEmp(int empNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
			return mapper.deleteEmp(empNo);
		}
	}

}
