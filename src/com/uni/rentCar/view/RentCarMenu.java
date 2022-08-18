package com.uni.rentCar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.uni.rentCar.controller.RentCarController;
import com.uni.rentCar.fin_List.fin_List;
import com.uni.rentCar.model.dto.RentCarDto;

public class RentCarMenu {

	private static Scanner sc = new Scanner(System.in);
	private RentCarController RentCarController = new RentCarController();
	
	public RentCarDto dto = new RentCarDto();
	
	public void RentCarMenu() {
		
		int choice;
		
		while(true) {
			
			System.out.println("\n=========== 렌터카 예약 프로그램 =============");
			System.out.println("1. 전체 렌트카 조회 ");
			System.out.println("2. 렌트카 인수 일자 ");
			System.out.println("3. 렌트카 인수 시간 ");
			System.out.println("4. 렌트카 반납 일자 시간 ");
			System.out.println("5. 렌트카 차종 조회 (소형,중형,대형) ");
			System.out.println("6. 최종 예약 조회 ");
			System.out.println("7. 예약 결정 ");
			System.out.println("9. 프로그램 종료");
			
			System.out.println("메뉴 번호를 입력하세요 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				RentCarController.selectAll();
				break;
			case 2:
				RentCarController.selectDate();
				break;
			case 3:
				RentCarController.selectTime();
				break;
			case 4:
				RentCarController.UpdatereturnDate();
				break;
			case 5:
				RentCarController.selectCarSection();
				break;
			case 6:
				RentCarController.ReservationCar();
				break;
			case 7:
				RentCarController.InsertReserTable();
				break;
			case 9:
				
				System.out.println("정말로 끝내시겠습니까??(y/n)");
				if ('y' == sc.next().toLowerCase().charAt(0)) {
					
					// DB에 연결을 끊고 while문을 빠져나간다.
					RentCarController.exitProgram();
					return;
				}

				break;
			}
			
			
		}
	}

	private RentCarDto updateMember() {
		
		RentCarDto rent = new RentCarDto();
		
//		m.setUserId(inputMemberId());
//		System.out.println("암호 : ");
//		m.setPassword(sc.next());
//		System.out.println("이메일 : ");
//		m.setEmail(sc.next());
//		System.out.println("전화번호(-빼고입력) : ");
//		m.setPhone(sc.next());
//		System.out.println("주소 : ");
//		sc.nextLine();//입력버퍼의 enter 키 제거
//		m.setAddress(sc.nextLine());

		return rent;
	}

	private RentCarDto inputMember() {
		
		RentCarDto rent = new RentCarDto();
		
//		System.out.println("새로운 회원정보를 입력하세요 >>");
//		System.out.println("아이디 : ");
//		m.setUserId(sc.next());
//		System.out.println("암호 : ");
//		m.setPassword(sc.next());
//		System.out.println("이름 : ");
//		m.setUserName(sc.next());
//		System.out.println("나이 : ");
//		m.setAge(sc.nextInt());
//		System.out.println("성별(M/F) : ");
//		m.setGender(sc.next().toUpperCase());
//		System.out.println("이메일 : ");
//		m.setEmail(sc.next());
//		System.out.println("전화번호(-빼고입력) : ");
//		m.setPhone(sc.next());
//		System.out.println("주소 : ");
//		sc.nextLine();//입력버퍼의 enter 키 제거
//		m.setAddress(sc.nextLine());
//		System.out.println("취미(, 로 공백없이 입력) : ");
//		m.setHobby(sc.next());
		
		
		return rent;
	}

	private String inputMemberName() {
		System.out.println("조회할 회원이름 입력 : ");
		return sc.next();
	}

	private String inputMemberId() {
		System.out.println("아이디입력 : ");
		return sc.next();
	}

	// 렌터카 조회된 리스트 리턴
	public void displayRentCarList(List<RentCarDto> list) {
		//System.out.println("\n조회된 전체 회원정보는 다음과 같습니다.");
		System.out.println("\n조회된 전체 렌터카 정보는 다음과 같습니다.");
		System.out.println("\n렌트번호\t차량번호\t차종\t  인수일자\t\t인수시간"
				+ "\t\t반납일자\t\t반납시간\t    대여기간\t가격\t 분류\t 연료\t 정원\t 연식");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		for (RentCarDto m : list) {
			System.out.println(m);
		}

	}

	// 에러메시지 출력용 메소드
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);

	}
	
	//아이디로 조회된 회원 한명 정보를 출력할 메소드
	public void displayMember(RentCarDto m) {
		System.out.println("\n조회된 전체 렌터카 정보는 다음과 같습니다.");
		System.out.println("\n렌트번호\t차량번호\t차종\t  인수일자\t\t인수시간"
				+ "\t\t반납일자\t\t반납시간\t    대여기간\t가격\t 분류\t 연료\t 정원\t 연식");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(m);
	}
	//성공 메세지 출력
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 결과 : "+message)  ;
	}
		
	
	
	// ======================= 마지막 리스트 출력하기 ====================
	
	public void displayfinRentCar(RentCarDto rentcar) {
		
		
		System.out.println("\n렌트번호\t차량번호\t차종\t  인수일자\t\t인수시간"
				+ "\t\t반납일자\t\t반납시간\t    대여기간\t가격\t 분류\t 연료\t 정원\t 연식");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(rentcar.getRentcar_no()
						 + "    " + rentcar.getCar_no()
						 + "    " + rentcar.getRentcar_model()
						 + "    " + rentcar.getRentcar_date()
						 + "    " + rentcar.getRentcar_datetime()
						 + "    " + rentcar.getRentcar_enddate()
						 + "    " + rentcar.getRentcar_endtime()
						 + "    " + rentcar.getRentcar_renttime()
						 + "    " + rentcar.getRentcar_price()
						 + "    " + rentcar.getRentcar_section()
						 + "    " + rentcar.getRentcar_fuel()
						 + "    " + rentcar.getRentcar_limit()
						 + "    " + rentcar.getRentcar_time()
						 );
		
	}
	
}