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
	
		public ArrayList<RentCarDto> selectCar_Data(Connection conn, String Date) {
		
		
		// Date 타입으로 디비에 보내야 한다. (String으로 되는지 확인)
		
		//RentCarDto ca = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		ArrayList<RentCarDto> list = null;
		
		String sql = "SELECT * FROM rentcar WHERE rentcar_date > ?";
		
		try {
			
			// 형식 : YYYY-mm-dd 형식
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Date);
			
			//4.쿼리문을 전송, 실행한 결과를 resultset으로 받기
			
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
			
			
			// Date 타입으로 디비에 보내야 한다. (String으로 되는지 확인)
			
			//RentCarDto ca = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;// SELECT 후 결과값 받아올객체
			ArrayList<RentCarDto> list = null;
			
			String sql = "SELECT * FROM rentcar WHERE rentcar_datetime >= ?";
			
			try {
				
				// 형식 : YYYY-mm-dd 형식
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Time);
				
				//4.쿼리문을 전송, 실행한 결과를 resultset으로 받기
				
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
			
			
			// Date 타입으로 디비에 보내야 한다. (String으로 되는지 확인)
			
			//RentCarDto ca = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;// SELECT 후 결과값 받아올객체
			ArrayList<RentCarDto> list = null;
			
			String sql = "SELECT * FROM rentcar WHERE rentcar_section = ?";
			
			try {
				
				// 형식 : YYYY-mm-dd 형식
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, inputCarSection);
				
				//4.쿼리문을 전송, 실행한 결과를 resultset으로 받기
				
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
		
		
		// Date 타입으로 디비에 보내야 한다. (String으로 되는지 확인)
		
		ArrayList<RentCarDto> list = null;
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		String sql = "SELECT * FROM rentcar";// 자동으로 세미콜론 붙여서 실행됨
		
		try {
			
			//3.쿼리문을 실행할 statement 객체 생성 
			
			stmt = conn.createStatement();
			
			//4.쿼리문을 전송, 실행한 결과를 resultset으로 받기
			
			rset = stmt.executeQuery(sql);
			
			
			//5. 받은 결과값을 객체에 옮겨서 저장하기 
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
		
		Statement stmt = null;// 쿼리문을 실행할 객체
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		String sql = "SELECT * FROM rentcar";// 자동으로 세미콜론 붙여서 실행됨
		
		try {
			
			//3.쿼리문을 실행할 statement 객체 생성 
			
			stmt = conn.createStatement();
			
			//4.쿼리문을 전송, 실행한 결과를 resultset으로 받기
			
			rset = stmt.executeQuery(sql);
			
			
			//5. 받은 결과값을 객체에 옮겨서 저장하기 
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
		ResultSet rset = null;// SELECT 후 결과값 받아올객체
		
		
		String sql = "SELECT * FROM rentcar WHERE car_no = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			//4.쿼리문을 전송, 실행한 결과를 resultset으로 받기
			
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
		PreparedStatement pstmt = null;// 실행할 쿼리
		ResultSet rset = null;// Select 한후 결과값 받아올 객체

		String sql = "SELECT * FROM rentcar WHERE rentcar_model LIKE ?";// 자동으로 세미콜론을 붙여 실행되므로 붙히지않는다

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
	
	// RentCar 반납 날짜, 시간 설정 
	public int UpdatereturnDate(Connection conn, String car_no, String udpatereturndate, String updatereturnsecond) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE rentcar SET rentcar_enddate = ?, rentcar_endtime = ? WHERE rentcar_no = ?";
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, udpatereturndate);
			pstmt.setString(2, updatereturnsecond);
			pstmt.setString(3, car_no);
			
			result = pstmt.executeUpdate();// 처리한 행의 갯수 리턴 (int) , 에러 -1

				
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
			
			result = pstmt.executeUpdate();// 처리한 행의 갯수 리턴 (int) , 에러 -1

				
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

			
			result = pstmt.executeUpdate();// 처리한 행의 갯수 리턴 (int) , 에러 -1

				
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
			

			
			result = pstmt.executeUpdate();// 처리한 행의 갯수 리턴 (int) , 에러 -1

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
