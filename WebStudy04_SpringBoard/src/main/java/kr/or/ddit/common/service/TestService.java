package kr.or.ddit.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.vo.PagingVO;
import kr.or.ddit.common.dao.CommonDAOImpl;
import kr.or.ddit.common.dao.TestDAOInterface;
import kr.or.ddit.common.dao.TestDAOClass;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	// case1
	private final TestDAOInterface dao1;
	// case2
	private final TestDAOClass dao2;
	// case3
	private final CommonDAOImpl dao3;
	
	public MemberVO retrieveMember(String username) {
		return dao1.selectMember(username);		
	}
	public List<MemberVO> retrieveList1() {
		return dao2.selectList(new PagingVO<MemberVO>());		
	}
	public List<MemberVO> retrieveList2() {
		return dao3.selectList(TestDAOClass.class, new PagingVO<MemberVO>());		
	}
}
