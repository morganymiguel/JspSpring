package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO selectMember(String memId) {
		StringBuffer sql = new StringBuffer();
		
		
		sql.append("SELECT                                                  ");
	    sql.append("mem_id,   mem_pass,   mem_name,                         ");
	    sql.append("mem_regno1,   mem_regno2,                               ");
	    sql.append("TO_CHAR(mem_bir, 'YYYY-MM-DD') mem_bir,                 ");
	    sql.append("mem_zip,   mem_add1,   mem_add2,                        ");
	    sql.append("mem_hometel,   mem_comtel,   mem_hp,                    ");
	    sql.append("mem_mail,   mem_job,   mem_like,                        ");
	    sql.append("mem_memorial,                                           ");
	    sql.append("TO_CHAR(mem_memorialday,'YYYY-MM-DD') mem_memorialday,	");	
	    sql.append("mem_mileage,   mem_delete                               ");
	    sql.append("FROM member                                             ");
	    sql.append("WHERE MEM_ID = ?                                      ");
		
		try (
				Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setString(1, memId);

			ResultSet rs = pstmt.executeQuery();
			MemberVO member = null;
			if(rs.next()) {
				
				member = new MemberVO();
				member.setMemId(rs.getString("MEM_ID"));
				member.setMemName(rs.getString("MEM_NAME"));
				member.setMemAdd1(rs.getString("MEM_ADD1"));
				member.setMemHp(rs.getString("MEM_HP"));
				member.setMemMail(rs.getString("MEM_MAIL"));
				member.setMemMileage(rs.getInt("MEM_MILEAGE"));
			}
			return member;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		StringBuffer sql = new StringBuffer();
		// 반복되지 않는 파트1
		sql.append("SELECT ");
		sql.append("MEM_ID, MEM_NAME, MEM_ADD1, ");
		sql.append("MEM_HP, MEM_MAIL, MEM_MILEAGE ");
		sql.append("FROM MEMBER ");

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			ResultSet rs = pstmt.executeQuery();
			// 반복되지 않는 파트2
			List<MemberVO> memberList = new ArrayList<>();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				memberList.add(member);
				member.setMemId(rs.getString("MEM_ID"));
				member.setMemName(rs.getString("MEM_NAME"));
				member.setMemAdd1(rs.getString("MEM_ADD1"));
				member.setMemHp(rs.getString("MEM_HP"));
				member.setMemMail(rs.getString("MEM_MAIL"));
				member.setMemMileage(rs.getInt("MEM_MILEAGE"));
			}
			return memberList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int updateMember(MemberVO member) {

		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
