package kr.or.ddit.common.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.MemberVO;

@Mapper
public interface TestDAOInterface {
	public MemberVO selectMember(String memId);
}
