package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;

public class MemberService {
	
	Properties prop = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	MemberDAO memberDAO = new MemberDAO();
	
	/*회원 등록*/
	
	/*모든 멤버 조회*/
	public void selectAllMembers() {
		
		Connection conn = getConnection();
		
		memberDAO.selectAllMembers(conn);
		
		close(conn);
		close(pstmt);
		close(rset);
	}

	/*ID로 멤버 조회*/
	public void searchMemberById(String id) {
		
		Connection conn = getConnection();
		
		memberDAO.searchMemberById(conn, id);
		
		close(conn);
		close(pstmt);
		close(rset);
	}

	/*성별로 멤버 조회*/
	public void searchMemberByGender(String gender) {
		
		Connection conn = getConnection();
		
		memberDAO.searchMemberByGender(conn, gender);
		
		close(conn);
		close(pstmt);
		close(rset);
	}

	public void registNewMember(MemberDTO memberDTO) {
		
		Connection conn = getConnection();
		
		memberDAO.registNewMember(conn, memberDTO);
		
	}
	

	
	
	
}
