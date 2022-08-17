package com.uni.utile;

public class StrTime {

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
