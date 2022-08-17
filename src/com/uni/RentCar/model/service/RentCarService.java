package com.uni.rentCar.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.uni.rentCar.model.dao.RentCarDao;
import com.uni.rentCar.model.dto.RentCarDto;
import static com.uni.common.JDBCTemplate.*;

public class RentCarService {

	private RentCarDao rentcarDao = new RentCarDao();
	
	
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
