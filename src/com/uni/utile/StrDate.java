package com.uni.utile;

public class StrDate {

	public String strDate(String temp) {
		
		String[] str = new String[temp.length()];
		char[] ch = new char[temp.length()];
		
		// 날짜 char 배열 
		char[] ch2 = new char[10];
		ch2[4] = '-';
		ch2[7] = '-';
		
		int temp_index = 0;
		boolean flag = false;
		
		// 예를 들어서 20190923 입력 -> date로 2019-02-03으로 변환해야 한다. 
		
		// String 배열에 넣는다.
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
