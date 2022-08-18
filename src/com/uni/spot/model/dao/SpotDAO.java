package com.uni.spot.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni.spot.model.dto.SpotDto;



public class SpotDao {
	

	public List<SpotDto> selectByName(Connection conn, String spot) {
		ArrayList<SpotDto> list = null;
		PreparedStatement pstmt = null;// 실행할 쿼리
		ResultSet rset = null;// Select 한후 결과값 받아올 객체

		String sql = "SELECT * FROM spot WHERE spot_name LIKE ?";// 자동으로 세미콜론을 붙여 실행되므로 붙히지않는다

		try {

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+spot+"%");
			rset = pstmt.executeQuery();

			list = new ArrayList<SpotDto>();

			while (rset.next()) {

				SpotDto s = new SpotDto();
	            
	            s.setSpotNo(rset.getInt("spot_no"));
	            s.setSpotCode(rset.getInt("spot_code"));
	            s.setSpotArea(rset.getString("spot_address"));
	            s.setSpotName(rset.getString("spot_name"));
	            s.setSpotTime(rset.getString("spot_time"));
	            s.setPrice(rset.getInt("spot_price"));

				list.add(s);
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
	
	
	public int bookingSpot(Connection conn, Int spotNo) {
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

	       

				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public ArrayList<SpotDto> selectBeach(Connection conn) {
		ArrayList<SpotDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		String sql = "SELECT * FROM spot WHERE spot_code = 1";// 자동으로 세미콜론 붙여서 실행됨
		
		try {
	
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<SpotDto>();
			
			while (rset.next()) {

				SpotDto s = new SpotDto();
	            
	            s.setSpotNo(rset.getInt("spot_no"));
	            s.setSpotCode(rset.getInt("spot_code"));
	            s.setSpotArea(rset.getString("spot_address"));
	            s.setSpotName(rset.getString("spot_name"));
	            s.setSpotTime(rset.getString("spot_time"));
	            s.setPrice(rset.getInt("spot_price"));
	            
	            list.add(s);
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	
	public ArrayList<SpotDto> selectMuseum(Connection conn) {
		ArrayList<SpotDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		String sql = "SELECT * FROM spot WHERE spot_code = 2";// 자동으로 세미콜론 붙여서 실행됨
		
		try {
	
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<SpotDto>();
			
			while (rset.next()) {

				SpotDto s = new SpotDto();
	            
	            s.setSpotNo(rset.getInt("spot_no"));
	            s.setSpotCode(rset.getInt("spot_code"));
	            s.setSpotArea(rset.getString("spot_address"));
	            s.setSpotName(rset.getString("spot_name"));
	            s.setSpotTime(rset.getString("spot_time"));
	            s.setPrice(rset.getInt("spot_price"));
	            
	            list.add(s);
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	
	
	public ArrayList<SpotDto> selectPark(Connection conn) {
		ArrayList<SpotDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		String sql = "SELECT * FROM spot WHERE spot_code = 3";// 자동으로 세미콜론 붙여서 실행됨
		
		try {
	
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<SpotDto>();
			
			while (rset.next()) {

				SpotDto s = new SpotDto();
	            
	            s.setSpotNo(rset.getInt("spot_no"));
	            s.setSpotCode(rset.getInt("spot_code"));
	            s.setSpotArea(rset.getString("spot_address"));
	            s.setSpotName(rset.getString("spot_name"));
	            s.setSpotTime(rset.getString("spot_time"));
	            s.setPrice(rset.getInt("spot_price"));
	            
	            list.add(s);
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	
	
	
	public ArrayList<SpotDto> selectMarket(Connection conn) {
		ArrayList<SpotDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		String sql = "SELECT * FROM spot WHERE spot_code = 4";// 자동으로 세미콜론 붙여서 실행됨
		
		try {
	
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<SpotDto>();
			
			while (rset.next()) {

				SpotDto s = new SpotDto();
	            
	            s.setSpotNo(rset.getInt("spot_no"));
	            s.setSpotCode(rset.getInt("spot_code"));
	            s.setSpotArea(rset.getString("spot_address"));
	            s.setSpotName(rset.getString("spot_name"));
	            s.setSpotTime(rset.getString("spot_time"));
	            s.setPrice(rset.getInt("spot_price"));
	            
	            list.add(s);
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(rset);
			close(stmt);
		}
		return list;
	}

	
	
	
}