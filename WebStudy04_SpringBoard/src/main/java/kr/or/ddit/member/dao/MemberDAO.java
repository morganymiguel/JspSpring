package kr.or.ddit.member.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.MemberVO;

@Mapper
public interface MemberDAO {
	public MemberVO findByPK(String username);
}
