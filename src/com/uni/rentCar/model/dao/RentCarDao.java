package com.uni.rentCar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.uni.common.JDBCTemplate.close;
import com.uni.rentCar.model.dto.RentCarDto;

public class RentCarDao {
	
	
	public int InsertReserTable(Connection conn, RentCarDto cardto) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
//		String sql = "UPDATE booking SET "
//				+ "booking_no = ?"
//				+ "member_no = ?,"
//				+ "pay_no = ?,"
//				+ "flight_no = ?,"
//				+ "spot_no = ?,"
//				+ "rentcar_no = ?,"
//				+ "stay_no = ?,"
////				+ "booking_day = ?,"
//				+ "booking_section = ?"
//				+ "booking_people = ?";
		
		String sql = "INSERT INTO MEMBER VALUES (null, ?, null, null, null, ?, null, now(), 3, null)";
		
		try {
			
			// 멤버번호, 주문번호
			// booking_day = sysdate;
			// booking_section = 3;
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, 1);	// member_no
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
	
	public ArrayList<RentCarDto> selectCar_Data(Connection conn, String Date) {
		
		//RentCarDto ca = null;
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
		
	
		public ArrayList<RentCarDto> selectCar_Time(Connection conn, String Time) {
			
			
			
			
			//RentCarDto ca = null;
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
		
		
		public ArrayList<RentCarDto> selectsection (Connection conn, String inputCarSection) {
			
			
			
			
			//RentCarDto ca = null;
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
		
	
	
	public ArrayList<RentCarDto> selectCar_Data(Connection conn) {
		
		ArrayList<RentCarDto> list = null;
		
		Statement stmt = null;// 
		ResultSet rset = null;// SELECT 
		
		String sql = "SELECT * FROM rentcar";
		
		try {
			
			
			
			stmt = conn.createStatement();
			
			
			
			rset = stmt.executeQuery(sql);
			
			
			
			list = new ArrayList<RentCarDto>();
			/*
			 * USERID
				PASSWORD
				USERNAME
				GENDER
				AGE
				EMAIL
				PHONE
				ADDRESS
				HOBBY
				ENROLLDATE
			 * 
			 * 
			 * */
			while(rset.next()) {
				//https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm
				//Member m = new Member();
				
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
	
	
	public RentCarDto selectOne(Connection conn, String memberId) {
		RentCarDto ca = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = "SELECT * FROM rentcar WHERE car_no = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				ca = new RentCarDto();
				
				ca.setRentcar_no(rset.getInt("rentcar_no"));
				ca.setCar_no(rset.getString("car_no"));
				ca.setRentcar_model(rset.getString("rentcar_model"));
				ca.setRentcar_date(rset.getDate("rentcar_date"));
				ca.setRentcar_datetime(rset.getDate("rentcar_datetime"));
				ca.setRentcar_enddate(rset.getDate("rentcar_enddate"));
				ca.setRentcar_endtime(rset.getDate("rentcar_endtime"));
				ca.setRentcar_renttime(rset.getInt("rentcar_renttime"));
				ca.setRentcar_price(rset.getInt("rentcar_price"));
				ca.setRentcar_section(rset.getString("rentcar_section"));
				ca.setRentcar_fuel(rset.getString("rentcar_fuel"));
				ca.setRentcar_limit(rset.getInt("rentcar_limit"));
				ca.setRentcar_time(rset.getString("rentcar_time"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				close(rset);
				close(pstmt);
		}
		
		return ca;
	}	


	public List<RentCarDto> selectByName(Connection conn, String memberName) {
		ArrayList<RentCarDto> list = null;
		PreparedStatement pstmt = null;// 
		ResultSet rset = null;// Select 

		String sql = "SELECT * FROM rentcar WHERE rentcar_model LIKE ?";// �ڵ����� �����ݷ��� �ٿ� ����ǹǷ� �������ʴ´�

		try {

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+memberName+"%");
			rset = pstmt.executeQuery();

			list = new ArrayList<RentCarDto>();

			while (rset.next()) {

				RentCarDto ca = new RentCarDto();
				
				ca.setRentcar_no(rset.getInt("rentcar_no"));
				ca.setCar_no(rset.getString("car_no"));
				ca.setRentcar_model(rset.getString("rentcar_model"));
				ca.setRentcar_date(rset.getDate("rentcar_date"));
				ca.setRentcar_datetime(rset.getDate("rentcar_datetime"));
				ca.setRentcar_enddate(rset.getDate("rentcar_enddate"));
				ca.setRentcar_endtime(rset.getDate("rentcar_endtime"));
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
	
	// RentCar 
	public int UpdatereturnDate(Connection conn, String car_no, String udpatereturndate, String updatereturnsecond) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE rentcar SET rentcar_enddate = ?, rentcar_endtime = ? WHERE rentcar_no = ?";
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udpatereturndate);
			pstmt.setString(2, updatereturnsecond);
			pstmt.setString(3, car_no);
			
			result = pstmt.executeUpdate();

				
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertMember(Connection conn, RentCarDto m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		
		try {
					
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, m.getUserId());
//			pstmt.setString(2, m.getPassword());
//			pstmt.setString(3, m.getUserName());
//			pstmt.setString(4, m.getGender());
//			pstmt.setInt(5, m.getAge());
//			pstmt.setString(6, m.getEmail());
//			pstmt.setString(7, m.getPhone());
//			pstmt.setString(8, m.getAddress());
//			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();

				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection conn, RentCarDto m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET PASSWORD = ? , EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID=?";
		
		
		try {
			
			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, m.getPassword());
//			pstmt.setString(2, m.getEmail());
//			pstmt.setString(3, m.getPhone());
//			pstmt.setString(4, m.getAddress());
//			pstmt.setString(5, m.getUserId());

			
			result = pstmt.executeUpdate();

				
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

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
