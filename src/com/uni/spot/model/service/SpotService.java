package com.uni.spot.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.uni.common.JDBCTemplate;
import com.uni.spot.model.dao.SpotDao;
import com.uni.spot.model.dto.SpotDto;


/**
 * <pre>
 * Class : SpotService
 * Comment : DB와 자바클래스간의 연결을 해주며 DB에서 불러온 값을 리스트로 전달
 * History
 * 2022.08.18 (백승민) 처음 작성함
 * </pre>
 * @author 백승민
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
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




