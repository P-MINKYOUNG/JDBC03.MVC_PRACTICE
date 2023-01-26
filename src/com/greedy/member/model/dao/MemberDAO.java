package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {
	
	List<MemberDTO> memberList = null;
	Properties prop = new Properties();
	
	public MemberDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*전체 멤버 조회하는 메소드*/
	public List<MemberDTO> selectAllMembers(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try {
			String query = prop.getProperty("selectAllMember");

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			memberList = new ArrayList<>();
			
			while (rset.next()) {
				member = new MemberDTO();

				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));

				memberList.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return memberList;
	}


	/*ID로 멤버 조회하는 메소드*/
	public MemberDTO searchMemberById(Connection conn , String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
	
		try {
			
			String query = prop.getProperty("selectedById");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			rset = pstmt.executeQuery();
		
			
			if (rset.next()) {
				
				member = new MemberDTO();
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
		}
		
		return null;
		
	}
	
	/*성별로 멤버 조회하는 메소드*/
	public List<MemberDTO> searchMemberByGender(Connection conn, String gender) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		MemberDTO member = null;
		
		try {
						
			String query = prop.getProperty("selectedByGender");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gender);
			
			rset = pstmt.executeQuery();
			
			memberList = new ArrayList<>();
			
			while(rset.next()) {
				member = new MemberDTO();
				
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				memberList.add(member);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return memberList; 

	}
	
	/*멤버 등록 메소드*/
	public int registNewMember(Connection conn, MemberDTO memberDTO) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String query = prop.getProperty("insertMember");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberDTO.getMemberId());
			pstmt.setString(2, memberDTO.getMemberPwd());
			pstmt.setString(3, memberDTO.getMemberName());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail());
			pstmt.setString(6, memberDTO.getPhone());
			pstmt.setString(7, memberDTO.getAddress());
			pstmt.setInt(8, memberDTO.getAge());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updatePassword(Connection conn, String memberId, String password) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePassword");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateEmail(Connection conn, String memberId, String email) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateEmail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePhone(Connection conn, String memberId, String phone) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePhone");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateAddress(Connection conn, String memberId, String address) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateAddress");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, address);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


}
