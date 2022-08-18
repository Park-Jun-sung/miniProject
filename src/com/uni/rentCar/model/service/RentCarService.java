package com.uni.rentCar.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.uni.rentCar.model.dao.RentCarDao;
import com.uni.rentCar.model.dto.RentCarDto;
import static com.uni.common.JDBCTemplate.*;

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
public class RentCarService {

	private RentCarDao rentcarDao = new RentCarDao();
	
	public int InsertReserTable(RentCarDto cardto) {
		
		Connection conn = getConnection();
		
		int ca = rentcarDao.InsertReserTable(conn, cardto);
		
		if(ca > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return ca;
		
	}
	
	
	
	
	public int UpdatereturnDate(String car_no, String udpatereturndate, String updatereturnsecond ) {
		
		Connection conn = getConnection();
		
		
		// int ca = rentcarDao.UpdatereturnDate(conn, car_no, udpatereturndate);
		int ca = rentcarDao.UpdatereturnDate(conn, "1001", udpatereturndate, updatereturnsecond);
		
		if(ca > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return ca;
	}
	
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public ArrayList<RentCarDto> selectDate(String str) {
		
		Connection conn = getConnection();
		ArrayList<RentCarDto> ca_list = rentcarDao.selectCar_Data(conn, str);
		
		return ca_list;
		
	}
	
	public ArrayList<RentCarDto> selectTime(String str) {
		
		Connection conn = getConnection();
		ArrayList<RentCarDto> ca_list = rentcarDao.selectCar_Time(conn, str);
		
		return ca_list;
		
	}
	
//	public ArrayList<RentCarDto> selectDate() {
//		
//		Connection conn = getConnection();
//		ArrayList<RentCarDto> list = rentcarDao.selectCar_Data(conn);
//		
//		return list;
//	}
	
	
	
	public  ArrayList<RentCarDto> selectAll() {
		
		Connection conn = getConnection();
		ArrayList<RentCarDto> list = rentcarDao.selectAll(conn);
		return list;
	}
	
	// �ڵ��� ���� ���� 
	public  ArrayList<RentCarDto> selectsection(String inputCarSection) {
		
		Connection conn = getConnection();
		 ArrayList<RentCarDto> list = rentcarDao.selectsection(conn, inputCarSection);
		return list;
		
	}

	public RentCarDto selectOne(String inputMemberId) {
		Connection conn = getConnection();
		RentCarDto c = rentcarDao.selectOne(conn, inputMemberId);
		return c;
	}

	public  List<RentCarDto> selectByName(String inputMemberName) {
		Connection conn = getConnection();
		List<RentCarDto> list = rentcarDao.selectByName(conn, inputMemberName);
		return list;
	}

	public  int insertMember(RentCarDto inputMember) {
		
		Connection conn = getConnection();
		int result = rentcarDao.insertMember(conn, inputMember);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public  int deleteMember(String inputMemberId) {
		
		Connection conn = getConnection();
		
		int result = rentcarDao.deleteMember(conn, inputMemberId);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public  int updateMember(RentCarDto updateMember) {
		Connection conn = getConnection();
		
		int result = rentcarDao.updateMember(conn, updateMember);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public void exitProgram() {
		close(getConnection());
		
	}
}
