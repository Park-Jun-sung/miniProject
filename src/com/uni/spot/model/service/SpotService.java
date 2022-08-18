package com.uni.spot.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.uni.common.JDBCTemplate;
import com.uni.spot.model.dao.SpotDao;
import com.uni.spot.model.dto.SpotDto;


public class SpotService {

	private SpotDao spotDao = new SpotDao();
	
	


	public  ArrayList<SpotDto> selectBeach() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpotDto> list = spotDao.selectBeach(conn);
		return list;
	}
	
	public  ArrayList<SpotDto> selectMuseum() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpotDto> list = spotDao.selectMuseum(conn);
		return list;
	}
	
	public  ArrayList<SpotDto> selectPark() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpotDto> list = spotDao.selectPark(conn);
		return list;
	}
	
	public  ArrayList<SpotDto> selectMarket() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<SpotDto> list = spotDao.selectMarket(conn);
		return list;
	}
	
	public  List<SpotDto> selectByName(String spot) {
		Connection conn = JDBCTemplate.getConnection();
		List<SpotDto> list = spotDao.selectByName(conn, spot);
		return list;
	}
	
	public  int bookingSpot(int spotNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = spotDao.bookingSpot(conn, spotNo);
		
		
		return result;
	}
	
	
	
}




