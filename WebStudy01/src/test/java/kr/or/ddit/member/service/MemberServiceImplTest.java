package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImplTest {
	MemberService service = new MemberServiceImpl();
	@Test
	public void testCreateMember() {
		MemberVO member = new MemberVO();
		member.setMemId("a002");
		member.setMemPass("java");
		member.setMemName("신규");
		member.setMemZip("000");
		member.setMemAdd1("대전");
		member.setMemAdd2("오류");
		member.setMemMail("aa@naver.com");
		ServiceResult result = service.createMember(member);
		assertEquals(ServiceResult.PKDUPLICATED, result);
		member.setMemId("a003");
		result = service.createMember(member);
		assertEquals(ServiceResult.OK, result);
		
	}

	@Test
	public void testRetrieveMember() {
		
	}

	@Test
	public void testRetrieveMemberList() {
		assertNotNull(service.retrieveMemberList());
	}

	@Test
	public void testModifyMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveMember() {
		fail("Not yet implemented");
	}

}
