package com.uni.stay.service;


import java.sql.Connection;
import java.util.List;

import com.uni.common.JDBCTemplate;
import com.uni.stay.model.dao.StayDao;
import com.uni.stay.model.dto.Booking;
import com.uni.stay.model.dto.Stay;

/**
 * <pre>
 * Class : StayService
 * Comment : DB와 자바클래스간의 연결을 해주며 DB에서 불러온 값을 리스트로 전달
 * History
 * 2022/08/16 (김성환) 처음 작성함
 * </pre>
 * @author 김성환
 * @version 1.0.0
 * @see 참고할 class나 외부 url
 * */
public class StayService {
	private StayDao stayDao = new StayDao();
	
	
	/**
	 * @param stayArea ui에서 입력받은 String값(지역명)을 DAO로 전달
	 * @param stayCode ui에서 입력받은 int값(숙소 구분)을 DAO로 전달
	 */
	public List<Stay> selectByNameList(String stayArea, int stayCode) {
		Connection con = JDBCTemplate.getConnection();
		List<Stay> list = stayDao.selectByNameList(con, stayArea, stayCode);
		
		return list;
	}

	/**
	 * @param stayName ui에서 입력받은 String값(숙소명)을 DAO로 전달
	 */
	public List<String> selectByStayInfo(String stayName) {
		Connection con = JDBCTemplate.getConnection();
		List<String> list = stayDao.selectByStayInfo(con, stayName);
		
		return list;
	}

	/**
	 * @param booking 예약테이블에 입력될 객체데이터
	 */
	public int insertBookingStay(Booking booking) {
		Connection con = JDBCTemplate.getConnection();
		int result = StayDao.insertBookingStay(con, booking);
		
		if(result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		return result;
	}
}
