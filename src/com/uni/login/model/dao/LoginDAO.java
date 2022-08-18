package com.uni.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uni.member.model.dto.Member;

import static com.uni.common.JDBCTemplate.*;

public class LoginDAO {

	public Member checkUser(Connection conn, Member member) {
		Member m = member;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT member_no, member_id, member_pwd, member_name FROM member WHERE member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMember_id());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m.setMember_no(rset.getInt("member_no"));
				m.setMember_id(rset.getString("member_id"));
				m.setMember_pwd(rset.getString("member_pwd"));
				m.setMember_name(rset.getString("member_name"));
			}else {
				m = new Member();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
}
