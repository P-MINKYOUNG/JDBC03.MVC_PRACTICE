package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {
	
	MemberDTO member = null;
	Properties prop = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	Connection conn = getConnection();
	List<MemberDTO> memberList = null;
	
	/*전체 멤버 조회하는 메소드*/
	public void selectAllMembers() {

		Connection conn = getConnection();

		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));

			String query = prop.getProperty("selectAllMember");

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

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

			for (MemberDTO member : memberList) {
				System.out.println(member.toString());
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}


	/*ID로 멤버 조회하는 메소드*/
	public void searchMemberById(String id) {

		
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
				
				System.out.println(member.toString());
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	/*성별로 멤버 조회하는 메소드*/
	public void searchMemberByGender(String gender) {
		
		
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
			
			for(MemberDTO member : memberList) {
				System.out.println(member.toString());
			}
			
		} catch (IOException | SQLException e1) {
			e1.printStackTrace();
		} 

	}


}
