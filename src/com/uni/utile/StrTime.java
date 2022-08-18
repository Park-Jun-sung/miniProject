package com.uni.utile;

/**
 * <pre>
 * Class : StrTime
 * Comment : 8을 치게 되면 08:00으로 바꿔주는 클래스
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * @author 정인섭
 * @version 11.0.2
 * */
public class StrTime {

	/**
	 * @param String temp 스트링으로 문자 1개를 받음
	 * @return result_str 문자열 00:00을 리턴함
	 */
	public String str_time(String temp) {
		
		char[] ch = new char[5];
		
		ch[2] = ':';
		ch[3] = '0';
		ch[4] = '0';
		
		
		if (temp.length() == 1) {
			
			ch[0] = '0';
			ch[1] = temp.charAt(0);
			
		} else {
			for (int i = 0; i < 2; ++i) {
				
				ch[i] = temp.charAt(i);
			}
		}
		
		String result_str = new String(ch);
		
		return result_str;
	}
	
}
