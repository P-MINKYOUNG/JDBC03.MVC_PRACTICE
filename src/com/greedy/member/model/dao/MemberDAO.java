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
	
	MemberDTO member = null;
	Properties prop = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	List<MemberDTO> memberList = null;
	
	/*전체 멤버 조회하는 메소드*/
	public List<MemberDTO> selectAllMembers(Connection conn) {

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));

			String query = prop.getProperty("selectAllMember");

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			memberList = new ArrayList<>();
			
			while (rset.next()) {
				MemberDTO member = new MemberDTO();

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

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return memberList;
	}


	/*ID로 멤버 조회하는 메소드*/
	public MemberDTO searchMemberById(Connection conn , String id) {
	
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));

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

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
		}
		
		
		return member; 
		
	}
	
	/*성별로 멤버 조회하는 메소드*/
	public List<MemberDTO> searchMemberByGender(Connection conn, String gender) {
		
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			
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
			
		} catch (IOException | SQLException e1) {
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
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			
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
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


}
