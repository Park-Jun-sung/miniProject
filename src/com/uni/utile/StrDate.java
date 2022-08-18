package com.uni.utile;

/**
 * <pre>
 * Class : StrDate
 * Comment : 20200202 입력받은 데이터를 2020-02-02로 바꾸는 클래스
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * @author 정인섭
 * @version 1.0.0
 * */
public class StrDate {
	/**
	 * @param String temp 문자열 20200202를 받는 문자열
	 * @return result_str 2020-02-02로 바꿔주게 된다.
	 */
	public String strDate(String temp) {
		
		String[] str = new String[temp.length()];
		char[] ch = new char[temp.length()];
		
		
		char[] ch2 = new char[10];
		ch2[4] = '-';
		ch2[7] = '-';
		
		int temp_index = 0;
		boolean flag = false;
		
		
		for (int i = 0; i < temp.length(); ++i) {
			
			ch[i] = temp.charAt(i);
			
		}
		
		
		for (int j = 0; j < 10; ++j) {
			
			
			if (ch2[j] == '-' && j < 6) {
				
				temp_index = j + 1;
				
				ch2[temp_index] = ch[j];
				
				flag = true;
				
				continue;
			}
			
			if (flag == true) {
				
				if (ch2[temp_index] == '-' || j >= 6) {
					
					temp_index = j + 2;
					
					ch2[temp_index] = ch[j];
					
					if (temp_index == 9) {
						
						break;
					}
					
					continue;
				}
				
				temp_index = j + 1;
				
				ch2[temp_index] = ch[j];
				
				continue;
			}
			ch2[j] = ch[j];
		}
		
		String result_str = new String(ch2);
		
		return result_str;
	}
	
	
}
