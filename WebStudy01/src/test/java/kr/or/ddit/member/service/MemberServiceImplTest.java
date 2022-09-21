package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberServiceImplTest {
	MemberService service = new MemberServiceImpl();
	@Test
	public void testCreateMember() {
		fail("Not yet implemented");
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
