package com.uni.RentCar.member.view;

import java.util.Scanner;

import com.uni.RentCar.member.controller.Car_Controller;

public class RentCar_Menu {

	
	Scanner sc = new Scanner(System.in);
	
	Car_Controller car_con = new Car_Controller();
	
	// 일단 예약 전체 메인 화면 만들겠습니다.
	public void CarMenu() {
		
		int car_classification = 0;
		
		while(true) {
			
			System.out.println("=======렌트 일자========");
			System.out.println("인수 일자와 인수 시간을 고르세요.");
			
			{
				// DB에서 인수일자와 시간, 반납일자와 반납 시간을 받는다.
				// 총 4개의 매개변수가 출력 
				
				// 인수 일자를 고른다.
				System.out.println("인수 일자를 고르시오 :" );
				// 인수 시간을 고른다.
				System.out.println("인수 시간을 고르시오 : ");
				
				// 반납 일자를 고른다
				System.out.println("반납 일자를 고르시오 : ");
				// 반납 시간을 고른다.
				System.out.println("반남 시간을 고르시오 : ");	
				
				// 예약 일자 함수 
				Car_Reservation(/*인수 일자, 인수 시간, 반납 일자, 반납 시간 */);
			}
			
			
			
			{
				
				// 차 분류를 고른다.
				System.out.println("============ 렌터카 차종 목록 ===========");
				System.out.println("1. 소형");
				System.out.println("2. 중형");
				System.out.println("3. SUV");
				
				car_classification = sc.nextInt();
				sc.nextLine();
				
				switch(car_classification) {
				
				case 1:
					// 소형
					Car_Select(car_classification);
					break;
				case 2:
					// 중형
					Car_Select(car_classification);
					break;
				case 3:
					// SUV
					Car_Select(car_classification);
					break;
				
				default:
					System.out.println("잘못 입력하셨습니다.");
					System.out.println("다시 고르시오");
				}
				
				
				
			}
			
		}
		
	}
	
	public void Car_Reservation(/*인수 일자, 인수 시간, 반납 일자, 반납 시간 */) {
		
		car_con.Car_SelectTime(/*인수 일자, 인수 시간, 반납 일자, 반납 시간 */);
		
		//return => 리턴이 필요한가?
		
	}
	
	public void Car_Select(int select) {
		
		car_con.Car_Select(select);
	}
}
