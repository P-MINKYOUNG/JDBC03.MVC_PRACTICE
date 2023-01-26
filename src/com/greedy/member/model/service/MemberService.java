package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;

public class MemberService {
	
	Properties prop = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	MemberDAO memberDAO = new MemberDAO();
	
	/*회원 등록*/
	public int registNewMember(MemberDTO memberDTO) {
		
		Connection conn = getConnection();
		
		int result = memberDAO.registNewMember(conn, memberDTO);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
		
	}

	/*모든 멤버 조회*/
	public List<MemberDTO> selectAllMembers() {
		
		Connection conn = getConnection();
		
		List<MemberDTO> memberList = new ArrayList<>();
				
		memberList = memberDAO.selectAllMembers(conn);
		
		close(conn);
		
		return memberList;
	}

	/*ID로 멤버 조회*/
	public MemberDTO searchMemberById(String id) {
		
		Connection conn = getConnection();
		
		MemberDTO memberDTO = memberDAO.searchMemberById(conn, id);
		
		close(conn);
		
		return memberDTO;
	}

	/*성별로 멤버 조회*/
	public List<MemberDTO> searchMemberByGender(String gender) {
		
		Connection conn = getConnection();
		
		List<MemberDTO> memberList = new ArrayList<>();
		
		memberList = memberDAO.searchMemberByGender(conn, gender);
		
		close(conn);

		return memberList;
	}

	
	

	
	
	
}
