package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dto.MemberDTO;

public class MemberService {
	
	Properties prop = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	
	public List<MemberDTO> selectAllMember(){
		
		List<MemberDTO> memberList = null;
		
		return memberList;
		
	}
	
	
}
