package com.uni.stay.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uni.common.JDBCTemplate;
import com.uni.stay.model.dao.StayDao;
import com.uni.stay.model.dto.Stay;

public class StayService {
	
	private StayDao stayDao = new StayDao();
	
	public List<Stay> selectByNameList(String stayArea, int stayCode) {
		Connection con = JDBCTemplate.getConnection();
		List<Stay> list = stayDao.selectByNameList(con, stayArea, stayCode);
		
		return list;
	}

	public List<String> selectByStayInfo(String stayName) {
		Connection con = JDBCTemplate.getConnection();
		List<String> list = stayDao.selectByStayInfo(con, stayName);
		
		return list;
	}
}
