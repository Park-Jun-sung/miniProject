package com.uni.rentCar.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.uni.rentCar.model.dao.RentCarDao;
import com.uni.rentCar.model.dto.RentCarDto;
import static com.uni.common.JDBCTemplate.*;

/**
 * <pre>
 * Class : RentCarService
 * Comment : Dao로 정보를 보내주는 class
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * @author 정인섭
 * @version 11.0.2
 * */
public class RentCarService {

	private RentCarDao rentcarDao = new RentCarDao();
	
	/**
	 * @param RentCarDto cardto 최종 cardto를 가져오는 매개변수
	 * @return ca 예약테이블에서 변경이 되면 정수가 변하게 되고 결과값 int로 받아오게 된다.
	 */
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
	
	// 반납 설정
	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
	public int UpdatereturnDate(int car_no, String udpatereturndate, String updatereturnsecond ) {
		
		Connection conn = getConnection();
		int ca = rentcarDao.UpdatereturnDate(conn, car_no, udpatereturndate, updatereturnsecond);
		
		if(ca > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return ca;
	}
	
	
	/**
	 * @param String str 날짜를 스트링으로 입력을 받는다.
	 * @return 해당 날짜에 DB의 정보를 갖고온다.
	 */
	public ArrayList<RentCarDto> selectDate(String str) {
		
		Connection conn = getConnection();
		ArrayList<RentCarDto> ca_list = rentcarDao.selectCar_Data(conn, str);
		
		return ca_list;
		
	}
	
	
	/**
	 * @param String str dto에서 time을 가져오는 매개변수
	 * @return db에 해당하는 시간의 데이터를 가져옴 
	 */
	public ArrayList<RentCarDto> selectTime(String str) {
		
		Connection conn = getConnection();
		ArrayList<RentCarDto> ca_list = rentcarDao.selectCar_Time(conn, str);
		
		return ca_list;
		
	}
		
	/**
	 * @return 렌트카 자동차에 모든 데이터를 가져옴 
	 */
	public  ArrayList<RentCarDto> selectAll() {
		
		Connection conn = getConnection();
		ArrayList<RentCarDto> list = rentcarDao.selectAll(conn);
		return list;
	}
	
	 
	/**
	 * @param String inputCarSection 렌트카 차종에 대한 정보를 입력
	 * @return 해당 db에 적합한 차종의 리스트를 가져온다.
	 */
	public  ArrayList<RentCarDto> selectsection(String inputCarSection) {
		
		Connection conn = getConnection();
		 ArrayList<RentCarDto> list = rentcarDao.selectsection(conn, inputCarSection);
		return list;
		
	}

	/**
	 * @param 매개변수명 매개변수에 대한 설명
	 * @param 매개변수명 매개변수에 대한 설명
	 * @return return값에 대한 설명
	 * @exception 예외 이유에 대한 설명
	 */
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

	
	public void exitProgram() {
		close(getConnection());
		
	}
}
