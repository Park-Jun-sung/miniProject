package com.uni.spot.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uni.login.view.LoginMenu;
import com.uni.main.view.MainMenu;
import com.uni.spot.model.dto.SpotDto;



/**
 * <pre>
 * Class : SpotDao
 * Comment : DB에 쿼리를 날리고 데이터를 입력하는 클래스
 * History
 * 2022/08/18 (백승민) 처음 작성함
 * </pre>
 * @author 백승민
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class SpotDao {
	

	
	/**
	 * @param conn : 데이터베이스 커넥션
	 * @param spot : 입력받은 관광지명
	 */
	public List<SpotDto> selectByName(Connection conn, String spot) { 
		ArrayList<SpotDto> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 관광지명 이름을 통해 관광지의 모든 정보를 들고옴
		String sql = "SELECT * FROM spot WHERE spot_name LIKE ?";

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
	
	/**
	 * @param conn : 데이터베이스 커넥션
	 * @param spot : 입력받은 지역명
	 */
	public int bookingSpot(Connection conn, int spotNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		//로그인 아이디 정보, 관광지 고유번호 정보를 예약 테이블에 입력함.
		String sql = "INSERT INTO booking VALUES (null, ?, null, null, ?, null, null, now(), 2, null)";
		
		
		try {
					
			 conn.setAutoCommit(false);
	         pstmt = conn.prepareStatement(sql); 
			 pstmt.setInt(1, MainMenu.member.getMember_no());
	         pstmt.setInt(2, spotNo);
	         result = pstmt.executeUpdate();

	         if(result > 0) {
	        	 conn.commit();  // 적용
	         }
	         else {
	        	 conn.rollback();   // 되돌리기
	         }

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * @param conn : 데이터베이스 커넥션
	 */
	public ArrayList<SpotDto> selectBeach(Connection conn) {
		ArrayList<SpotDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		// 관광지 유형이 해수욕장인 데이터를 요청함
		String sql = "SELECT * FROM spot WHERE spot_code = 1";
		
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
	
	/**
	 * @param conn : 데이터베이스 커넥션
	 */
	public ArrayList<SpotDto> selectMuseum(Connection conn) {
		ArrayList<SpotDto> list = null;
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		// 관광지 유형이 박물관인 데이터를 요청함
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
	
	
	/**
	 * @param conn : 데이터베이스 커넥션
	 */
	public ArrayList<SpotDto> selectPark(Connection conn) {
		ArrayList<SpotDto> list = null;
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		// 관광지 유형이 공원인 데이터를 요청함
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
	
	
	
	/**
	 * @param conn : 데이터베이스 커넥션
	 */
	public ArrayList<SpotDto> selectMarket(Connection conn) {
		ArrayList<SpotDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		// 관광지 유형이 전통시장인 데이터를 요청함
		String sql = "SELECT * FROM spot WHERE spot_code = 4";
		
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