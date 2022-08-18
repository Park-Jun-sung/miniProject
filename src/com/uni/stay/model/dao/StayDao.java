package com.uni.stay.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.uni.stay.model.dto.Booking;
import com.uni.stay.model.dto.Stay;

/**
 * <pre>
 * Class : StayDao
 * Comment : DB에 쿼리를 날리고 데이터를 입력하는 클래스
 * History
 * 2022/08/16 (김성환) 처음 작성함
 * </pre>
 * @author 김성환
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class StayDao {
	public List<Stay> selectByNameList(Connection con, String stayArea, int stayCode) {
		ArrayList<Stay> list = null;
		PreparedStatement pstmt = null;
	    ResultSet rset = null;
		
		String sql = "SELECT * FROM stay WHERE stay_area LIKE ? AND stay_code = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+stayArea+"%");
			pstmt.setInt(2, stayCode);
			rset = pstmt.executeQuery();
			list = new ArrayList<Stay>();
			
			while (rset.next()) {
	            Stay s = new Stay();
	            s.setStayNo(rset.getInt("stay_no"));
	            s.setStayCode(rset.getInt("stay_code"));
	            s.setStayArea(rset.getString("stay_area"));
	            s.setStayName(rset.getString("stay_name"));
	            s.setStayDay(rset.getDate("stay_day"));
	            s.setPrice(rset.getInt("price"));
	            
	            list.add(s);
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<String> selectByStayInfo(Connection con, String stayName) {
		ArrayList<String> list = null;
		PreparedStatement pstmt = null;
	    ResultSet rset = null;
		
		String sql = "SELECT * FROM stay WHERE stay_name LIKE ?";
		
		Stay s = new Stay();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stayName);
			rset = pstmt.executeQuery();
			list = new ArrayList<String>();
			
			while (rset.next()) {
//	            s.setStayNo(rset.getInt("stay_no"));
//	            s.setStayCode(rset.getInt("stay_code"));
//	            s.setStayArea(rset.getString("stay_area"));
//	            s.setStayName(rset.getString("stay_name"));
//	            s.setStayDay(rset.getDate("stay_day"));
//	            s.setPrice(rset.getInt("price"));
	            int no = rset.getInt("stay_no");
	            String temp = Integer.toString(no);
	            list.add(temp);
	            String name = rset.getString("stay_name");
	            list.add(name);
	            String area = rset.getString("stay_area");
	            list.add(area);		
	            int price = rset.getInt("price");
	            String temp2 = Integer.toString(price);
	            list.add(temp2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public static int insertBookingStay(Connection con, Booking b) {
		int result = 0;
	      PreparedStatement pstmt = null;
	      
	      String sql = "INSERT INTO booking VALUES (null, ?, null, null, null, null, ?, now(), ?, null)";
	      
	      try {
	         con.setAutoCommit(false);
	         pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, b.getMemberNo());
	         pstmt.setInt(2, b.getStayNo());
	         pstmt.setInt(3, b.getBookingSection());
	         
	         result = pstmt.executeUpdate();// 처리한 행의 갯수 리턴 (int) , 에러 -1

	         if(result > 0) {
	        	 con.commit();// 적용
	         }
	         else {
	        	 con.rollback();   // 되돌리기
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	          close(pstmt);
	          close(con);
	      }
	      return result;
	}
}
