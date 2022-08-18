package com.uni.rentCar.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.uni.common.JDBCTemplate.close;

import com.uni.main.view.MainMenu;
import com.uni.rentCar.model.dto.RentCarDto;


/**
 * <pre>
 * Class : RentCarDao
 * Comment : DB를 연결하기 위한 클래스
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * @author 정인섭
 * @version 11.0.2
 * */
public class RentCarDao {
	
	
	/**
	 * @param Connection conn Connection 연결하기 위한 매개변수
	 * @param RentCarDto cardto 조회된 차에 대한 정보를 갖고옴 
	 * @return result 바뀐행이 있으면 정수가 +가 되면서 양수로 변환
	 * @exception SQLException sql이 잘되지 않았을 경우 try-catch문을 사용 
	 */
	public int InsertReserTable(Connection conn, RentCarDto cardto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO booking VALUES (null, ?, null, null, null, ?, null, now(), 3, null)";
		
		try {
			
			// 멤버번호, 주문번호
			// booking_day = sysdate;
			// booking_section = 3;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());	// member_no
			pstmt.setInt(2, cardto.getRentcar_no());	// rentcar_no			
			result = pstmt.executeUpdate();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**
	 * @param Connection conn Connection을 하기 위한 매개변수
	 * @param String Date Date에 정보를 가져오기 위한 매개변수
	 * @return list 시간 정보를 조회하고 그 결과값을 list 데이터 대입 
	 * @exception sql문이 잘못되었을때의 try-catch문 
	 */
	public ArrayList<RentCarDto> selectCar_Data(Connection conn, String Date) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;// 
		ArrayList<RentCarDto> list = null;
		
		String sql = "SELECT * FROM rentcar WHERE rentcar_date >= ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Date);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<RentCarDto>();
			
			while(rset.next()) {
				
				RentCarDto ca = new RentCarDto();
				
				ca.setRentcar_no(rset.getInt("rentcar_no"));
				ca.setCar_no(rset.getString("car_no"));
				ca.setRentcar_model(rset.getString("rentcar_model"));
				ca.setRentcar_date(rset.getDate("rentcar_date"));
				ca.setRentcar_datetime(rset.getTime("rentcar_datetime"));
				ca.setRentcar_enddate(rset.getDate("rentcar_enddate"));
				ca.setRentcar_endtime(rset.getTime("rentcar_endtime"));
				ca.setRentcar_renttime(rset.getInt("rentcar_renttime"));
				ca.setRentcar_price(rset.getInt("rentcar_price"));
				ca.setRentcar_section(rset.getString("rentcar_section"));
				ca.setRentcar_fuel(rset.getString("rentcar_fuel"));
				ca.setRentcar_limit(rset.getInt("rentcar_limit"));
				ca.setRentcar_time(rset.getString("rentcar_time"));
				list.add(ca);
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
		 * @param Connection conn Connection을 하기 위한 매개변수
		 * @param String Time  정보를 가져오기 위한 매개변수
		 * @return list 시간에 대한 정보가 합당하면 그 데이터를 출력 
		 * @exception sql문이 잘못되었을때의 try-catch문
		 */
		public ArrayList<RentCarDto> selectCar_Time(Connection conn, String Time) {
		
			PreparedStatement pstmt = null;
			ResultSet rset = null;// SELECT 
			ArrayList<RentCarDto> list = null;
			
			String sql = "SELECT * FROM rentcar WHERE rentcar_datetime >= ?";
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Time);
				
				rset = pstmt.executeQuery();
				
				list = new ArrayList<RentCarDto>();
				
				while(rset.next()) {
					
					RentCarDto ca = new RentCarDto();
					
					ca.setRentcar_no(rset.getInt("rentcar_no"));
					ca.setCar_no(rset.getString("car_no"));
					ca.setRentcar_model(rset.getString("rentcar_model"));
					ca.setRentcar_date(rset.getDate("rentcar_date"));
					ca.setRentcar_datetime(rset.getTime("rentcar_datetime"));
					ca.setRentcar_enddate(rset.getDate("rentcar_enddate"));
					ca.setRentcar_endtime(rset.getTime("rentcar_endtime"));
					ca.setRentcar_renttime(rset.getInt("rentcar_renttime"));
					ca.setRentcar_price(rset.getInt("rentcar_price"));
					ca.setRentcar_section(rset.getString("rentcar_section"));
					ca.setRentcar_fuel(rset.getString("rentcar_fuel"));
					ca.setRentcar_limit(rset.getInt("rentcar_limit"));
					ca.setRentcar_time(rset.getString("rentcar_time"));
					list.add(ca);
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
		 * @param Connection conn Connection을 하기 위한 매개변수
		 * @param String inputCarSection 차종에 대한 정보를 가져오기 위한 매개변수
		 * @return 차종을 db에 적용했을때 조건에 맞는 데이터를 추출 
		 * @exception sql문이 잘못되었을때의 try-catch문
		 */
		public ArrayList<RentCarDto> selectsection (Connection conn, String inputCarSection) {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<RentCarDto> list = null;
			
			String sql = "SELECT * FROM rentcar WHERE rentcar_section = ?";
			
			try {
				
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, inputCarSection);
				
				rset = pstmt.executeQuery();
				
				list = new ArrayList<RentCarDto>();
				
				while(rset.next()) {
					
					RentCarDto ca = new RentCarDto();
					
					ca.setRentcar_no(rset.getInt("rentcar_no"));
					ca.setCar_no(rset.getString("car_no"));
					ca.setRentcar_model(rset.getString("rentcar_model"));
					ca.setRentcar_date(rset.getDate("rentcar_date"));
					ca.setRentcar_datetime(rset.getTime("rentcar_datetime"));
					ca.setRentcar_enddate(rset.getDate("rentcar_enddate"));
					ca.setRentcar_endtime(rset.getTime("rentcar_endtime"));
					ca.setRentcar_renttime(rset.getInt("rentcar_renttime"));
					ca.setRentcar_price(rset.getInt("rentcar_price"));
					ca.setRentcar_section(rset.getString("rentcar_section"));
					ca.setRentcar_fuel(rset.getString("rentcar_fuel"));
					ca.setRentcar_limit(rset.getInt("rentcar_limit"));
					ca.setRentcar_time(rset.getString("rentcar_time"));
					list.add(ca);
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
		 * @param Connection conn Connection을 하기 위한 매개변수
		 * @return 모든차에 대한 정보를 db에 적용했을때, 전체적인 차 정보 조회 
		 * @exception sql문이 잘못되었을때의 try-catch문
		 */
		public ArrayList<RentCarDto> selectAll(Connection conn) {
		
		ArrayList<RentCarDto> list = null;
		
		Statement stmt = null;//
		ResultSet rset = null;// 
		
		String sql = "SELECT * FROM rentcar";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<RentCarDto>();
			
			while(rset.next()) {
				
				RentCarDto ca = new RentCarDto();
				
				ca.setRentcar_no(rset.getInt("rentcar_no"));
				ca.setCar_no(rset.getString("car_no"));
				ca.setRentcar_model(rset.getString("rentcar_model"));
				ca.setRentcar_date(rset.getDate("rentcar_date"));
				ca.setRentcar_datetime(rset.getTime("rentcar_datetime"));
				ca.setRentcar_enddate(rset.getDate("rentcar_enddate"));
				ca.setRentcar_endtime(rset.getTime("rentcar_endtime"));
				ca.setRentcar_renttime(rset.getInt("rentcar_renttime"));
				ca.setRentcar_price(rset.getInt("rentcar_price"));
				ca.setRentcar_section(rset.getString("rentcar_section"));
				ca.setRentcar_fuel(rset.getString("rentcar_fuel"));
				ca.setRentcar_limit(rset.getInt("rentcar_limit"));
				ca.setRentcar_time(rset.getString("rentcar_time"));
				list.add(ca);
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
		 * @param Connection conn Connection을 하기 위한 매개변수
		 * @param String car_no car_no의 정보를 가져오기 위한 매개변수
		 * @param String udpatereturndate 자동차 반납 날짜를 설정하기 위한 매개변수 
		 * @param String updatereturnsecond 자동차 반납 시간을 설정하기 위한 매개변수 
		 * @return 반납 날짜,시간을 설정하고 디비에서 update를 시켜서 목록을 가져온다.
		 * @exception sql문이 잘못되었을때의 try-catch문
		 */
		public int UpdatereturnDate(Connection conn, int car_no, String udpatereturndate, String updatereturnsecond) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE rentcar SET rentcar_enddate = ?, rentcar_endtime = ? WHERE rentcar_no = ?";
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udpatereturndate);
			pstmt.setString(2, updatereturnsecond);
			pstmt.setInt(3, car_no);
			
			result = pstmt.executeUpdate();

				
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

	// 최종 예약 디비에서 디비에 있는 행에 있는 것들을 지운다.
	public int deleteMember(Connection conn, String memberId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM rentcar WHERE car_no = ?";
		
		
		try {
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
