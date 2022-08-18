package com.uni.rentCar.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.uni.rentCar.model.dao.RentCarDao;
import com.uni.rentCar.model.dto.RentCarDto;
import static com.uni.common.JDBCTemplate.*;

public class RentCarService {

	private RentCarDao rentcarDao = new RentCarDao();
	
	public int UpdatereturnDate(String car_no, String udpatereturndate, String updatereturnsecond ) {
		
		Connection conn = getConnection();
		
		// 차 번호, 반납 날짜 매개변수로
		// int ca = rentcarDao.UpdatereturnDate(conn, car_no, udpatereturndate);
		int ca = rentcarDao.UpdatereturnDate(conn, "1001", udpatereturndate, updatereturnsecond);
		
		if(ca > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return ca;
	}
	
	
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
	
	// 자동차 차종 선택 
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
