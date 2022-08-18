package com.uni.booking.model.dao;

import static com.uni.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.booking.model.dto.BookingDTO;
import com.uni.flight.model.dto.FlightDTO;
import com.uni.main.view.MainMenu;
import com.uni.rentCar.model.dto.RentCarDto;
import com.uni.spot.model.dto.SpotDto;
import com.uni.stay.model.dto.Stay;

/**
 * <pre>
 * Class : 클래스의 이름
 * Comment : 클래스에 대한 설명
 * History
 * 2020/09/08 (작성자) 처음 작성함
 * </pre>
 * @author 작성자
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class BookingListDAO {

	/**
	 * <pre>
	 * 항공기 예약 정보 조회 결과 리스트 리턴하는 메소드
	 * </pre>
	 * @param conn : DB connection
	 * @return 항공기 예약 정보 조회 결과 리스트
	 * @exception SQL 예외 처리
	 */
	public ArrayList<BookingDTO> selectFlightBookingList(Connection conn) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		
		ArrayList<BookingDTO> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM booking WHERE member_no = ? AND booking_section = ? AND pay_no is null";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());
			pstmt.setInt(2, 1);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BookingDTO booking = new BookingDTO();
				booking.setBookingNo(rset.getInt("booking_no"));
				booking.setMemberNo(rset.getInt("member_no"));
				booking.setPayNo(rset.getInt("pay_no"));
				booking.setFlightNo(rset.getInt("flight_no"));
				booking.setSpotNo(rset.getInt("spot_no"));
				booking.setRentcarNo(rset.getInt("rentcar_no"));
				booking.setStayNo(rset.getInt("stay_no"));
				booking.setBookingDay(rset.getString("booking_day"));
				booking.setBookingSection(rset.getInt("booking_section"));
				booking.setBookingPeople(rset.getInt("booking_people"));
				
				String sql2 = "SELECT * FROM flight WHERE flight_no = ?";
				
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, rset.getInt("flight_no"));
				
				rset2 = pstmt2.executeQuery();
				
				if(rset2.next()) {
					FlightDTO dto = new FlightDTO();
					dto.setFlightNo(rset2.getInt("flight_no"));
					dto.setAirNo(rset2.getInt("air_no"));
					dto.setFlightCompany(rset2.getString("flight_company"));
					dto.setFlightDeparture(rset2.getString("flight_departure"));
					dto.setFlightAirportDeparture(rset2.getString("flight_airport_departure"));
					dto.setFlightAirportReturn(rset2.getString("flight_airport_return"));
					dto.setFlightTime(rset2.getString("flight_time"));
					dto.setFlightPrice(rset2.getInt("flight_price"));
					
					booking.setFlight(dto);
				}
				
				list.add(booking);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(rset2);
			close(pstmt);
			close(pstmt2);
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 관광지 예약 정보 조회 결과 리스트 리턴하는 메소드
	 *</pre>
	 * @param conn : DB connection
	 * @return 관광지 예약 정보 조회 결과 리스트
	 * @exception SQL 예외 처리
	 */
	public ArrayList<BookingDTO> selectSpotBookingList(Connection conn) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		
		ArrayList<BookingDTO> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM booking WHERE member_no = ? AND booking_section = ? AND pay_no is null";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());
			pstmt.setInt(2, 2);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BookingDTO booking = new BookingDTO();
				booking.setBookingNo(rset.getInt("booking_no"));
				booking.setMemberNo(rset.getInt("member_no"));
				booking.setPayNo(rset.getInt("pay_no"));
				booking.setFlightNo(rset.getInt("flight_no"));
				booking.setSpotNo(rset.getInt("spot_no"));
				booking.setRentcarNo(rset.getInt("rentcar_no"));
				booking.setStayNo(rset.getInt("stay_no"));
				booking.setBookingDay(rset.getString("booking_day"));
				booking.setBookingSection(rset.getInt("booking_section"));
				booking.setBookingPeople(rset.getInt("booking_people"));
				
				String sql2 = "SELECT * FROM spot WHERE spot_no = ?";
				
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, rset.getInt("spot_no"));
				
				rset2 = pstmt2.executeQuery();
				
				if(rset2.next()) {
					SpotDto dto = new SpotDto();
					dto.setSpotNo(rset2.getInt("spot_no"));
					dto.setSpotCode(rset2.getInt("spot_code"));
					dto.setSpotName(rset2.getString("spot_name"));
					dto.setSpotArea(rset2.getString("spot_address"));
					dto.setSpotTime(rset2.getString("spot_time"));
					dto.setPrice(rset2.getInt("spot_price"));
					booking.setSpot(dto);
				}
				
				list.add(booking);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(rset2);
			close(pstmt);
			close(pstmt2);
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 렌트카 예약 정보 조회 결과 리스트 리턴하는 메소드
	 * </pre>
	 * @param conn : DB connection 
	 * @return 렌트카 예약 정보 조회 결과 리스트
	 * @exception SQL 예외 처리
	 */
	public ArrayList<BookingDTO> selectRentCarBookingList(Connection conn) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		
		ArrayList<BookingDTO> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM booking WHERE member_no = ? AND booking_section = ? AND pay_no is null";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());
			pstmt.setInt(2, 3);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BookingDTO booking = new BookingDTO();
				booking.setBookingNo(rset.getInt("booking_no"));
				booking.setMemberNo(rset.getInt("member_no"));
				booking.setPayNo(rset.getInt("pay_no"));
				booking.setFlightNo(rset.getInt("flight_no"));
				booking.setSpotNo(rset.getInt("spot_no"));
				booking.setRentcarNo(rset.getInt("rentcar_no"));
				booking.setStayNo(rset.getInt("stay_no"));
				booking.setBookingDay(rset.getString("booking_day"));
				booking.setBookingSection(rset.getInt("booking_section"));
				booking.setBookingPeople(rset.getInt("booking_people"));
				
				String sql2 = "SELECT * FROM rentcar WHERE rentcar_no = ?";
				
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, rset.getInt("rentcar_no"));
				
				rset2 = pstmt2.executeQuery();
				
				if(rset2.next()) {
					RentCarDto dto = new RentCarDto();
					dto.setRentcar_no(rset2.getInt("rentcar_no"));
					dto.setCar_no(rset2.getString("car_no"));
					dto.setRentcar_model(rset2.getString("rentcar_model"));
					dto.setRentcar_date(rset2.getDate("rentcar_date"));
					dto.setRentcar_datetime(rset2.getTime("rentcar_datetime"));
					dto.setRentcar_enddate(rset2.getDate("rentcar_enddate"));
					dto.setRentcar_endtime(rset2.getTime("rentcar_endtime"));
					dto.setRentcar_renttime(rset2.getInt("rentcar_renttime"));
					dto.setRentcar_price(rset2.getInt("rentcar_price"));
					dto.setRentcar_section(rset2.getString("rentcar_section"));
					dto.setRentcar_fuel(rset2.getString("rentcar_fuel"));
					dto.setRentcar_limit(rset2.getInt("rentcar_limit"));
					dto.setRentcar_time(rset2.getString("rentcar_time"));
					
					booking.setRentcar(dto);
				}
				
				list.add(booking);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(rset2);
			close(pstmt);
			close(pstmt2);
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 숙박 예약 정보 조회 결과 리스트 리턴하는 메소드
	 * </pre>
	 * @param conn : DB connection 
	 * @return 숙박 예약 정보 조회 결과 리스트
	 * @exception SQL 예외 처리
	 */
	public ArrayList<BookingDTO> selectStayBookingList(Connection conn) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		
		ArrayList<BookingDTO> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM booking WHERE member_no = ? AND booking_section = ? AND pay_no is null";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());
			pstmt.setInt(2, 4);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BookingDTO booking = new BookingDTO();
				booking.setBookingNo(rset.getInt("booking_no"));
				booking.setMemberNo(rset.getInt("member_no"));
				booking.setPayNo(rset.getInt("pay_no"));
				booking.setFlightNo(rset.getInt("flight_no"));
				booking.setSpotNo(rset.getInt("spot_no"));
				booking.setRentcarNo(rset.getInt("rentcar_no"));
				booking.setStayNo(rset.getInt("stay_no"));
				booking.setBookingDay(rset.getString("booking_day"));
				booking.setBookingSection(rset.getInt("booking_section"));
				booking.setBookingPeople(rset.getInt("booking_people"));
				
				String sql2 = "SELECT * FROM stay WHERE stay_no = ?";
				
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, rset.getInt("stay_no"));
				
				rset2 = pstmt2.executeQuery();
				
				if(rset2.next()) {
					Stay dto = new Stay();
					dto.setStayNo(rset2.getInt("stay_no"));
					dto.setStayCode(rset2.getInt("stay_code"));
					dto.setStayArea(rset2.getString("stay_area"));
					dto.setStayName(rset2.getString("stay_name"));
					dto.setStayDay(rset2.getDate("stay_day"));
					dto.setPrice(rset2.getInt("price"));
					booking.setStay(dto);
				}
				
				list.add(booking);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(rset2);
			close(pstmt);
			close(pstmt2);
		}
		
		return list;
	}

	/**
	 * <pre>
	 * 결제 데이터를 생성하고 결제 코드를 발퀘하여 리턴하는 메소드
	 * </pre>
	 * @param conn : DB connection
	 * @param payCode : 결제 종류(1:현금, 2:카드, 3:무통장)
	 * @param totalPrice : 예약 총 합계 금액
	 * @return payNo : 결제 코드
	 * @exception SQL 예외 처리
	 */
	public int createPayNo(Connection conn, int payCode, int totalPrice) {
		int payNo = 0;
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		
		String sql = "INSERT INTO payment VALUES (null, ?, now(), ?, ?, null)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MainMenu.member.getMember_no());
			pstmt.setInt(2, payCode);
			pstmt.setInt(3, totalPrice);
			
			int createResult = pstmt.executeUpdate();
			
			if(createResult == 1) {
				String sql2 = "SELECT MAX(pay_no) as pay_no FROM payment WHERE member_no = ?";
				
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, MainMenu.member.getMember_no());
				
				rset = pstmt2.executeQuery();
				
				if(rset.next()) {
					payNo = rset.getInt("pay_no");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(pstmt2);
		}
		
		return payNo;
	}

	/**
	 * <pre>
	 * 일괄 결제 시 예약 정보에 결제 코드 업데이트하는 메소드
	 * </pre>
	 * @param conn : DB connection
	 * @param list : 예약 정보 리스트
	 * @param payNo : 결제 코드
	 * @return result : UPDATE 처리 여부 리턴
	 * @exception SQL 예외 처리
	 */
	public boolean updateBooking(Connection conn, ArrayList<BookingDTO> list, int payNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		boolean result = false;
		int count1 = 0;
		int count2 = 0;
		
		for(BookingDTO booking : list) {
			try {
				count1++;
				String sql = "UPDATE booking SET pay_no = ? WHERE booking_no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, payNo);
				pstmt.setInt(2, booking.getBookingNo());
				
				count2 += pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		System.out.println(this.getClass());
		System.out.println("count1 : " + count1);
		System.out.println("count2 : " + count2);
		if(count1 == count2) {
			result = true;
		}
		
		return result;
	}

	/**
	 * <pre>
	 * 예약 번호를 전달 받아 예약을 취소하는 메소드
	 * </pre>
	 * @param conn : DB connection
	 * @param bookingNo : 예약 번호
	 * @return result : UPDATE 처리 여부 리턴
	 * @exception SQL 예외 처리
	 */
	public int setCancelBooking(Connection conn, int bookingNo) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		int result = 0;
		
		try {
			String sql = "SELECT * FROM booking WHERE booking_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookingNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String payNo = rset.getString("pay_no");
				if(payNo != null) {
					return result = 8;//결제된 건
				}
				
				String sql2 = "DELETE FROM booking WHERE booking_no = ?";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, bookingNo);
				
				result = pstmt2.executeUpdate();
				
			}else {
				result = 9;//해당 예약 정보 없음
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(pstmt2);
		}
		
		return result;
	}

}
