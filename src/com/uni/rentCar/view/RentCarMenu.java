package com.uni.rentCar.view;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.uni.rentCar.controller.RentCarController;
import com.uni.rentCar.fin_List.fin_List;
import com.uni.rentCar.model.dto.RentCarDto;


/**
 * <pre>
 * Class : RentCarMenu
 * Comment : RentCarMenu에 대한 전체 Menu
 * History
 * 2022/08/18 정인섭 처음 작성함
 * </pre>
 * @author 작성자
 * @version 1.0.0
 * */
public class RentCarMenu {

	private static Scanner sc = new Scanner(System.in);
	private RentCarController RentCarController = new RentCarController();
	public static RentCarDto dto = new RentCarDto();
	
	/**
		RentCarMenu 전체 메뉴
	 */
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
			System.out.println("8. 예약이 된 렌트카 ");
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
				RentCarController.UpdatereturnDate(dto);
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
			case 8:
				System.out.print("예약된 테이블에서 가지고 오는것은 구현이 아직 안됨");
				RentCarController.ReservedCarDisplay(dto);
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
	
	/**
	 * @param List<RentCarDto> list db에 조회된 리스트를 받고 출력
	 */
	public void displayRentCarList(List<RentCarDto> list) {
		System.out.println("\n조회된 전체 렌터카 정보는 다음과 같습니다.");
		System.out.println("\n렌트번호\t차량번호\t차종\t  인수일자\t\t인수시간"
				+ "\t\t반납일자\t\t반납시간\t    대여기간\t가격\t 분류\t 연료\t 정원\t 연식");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		for (RentCarDto m : list) {
			System.out.println(m);
		}

	}


	/**
	 * @param String message 에러메시지 출력용 메소드
	 */
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);

	}
	
	
	/**
	 * @param RentCarDto car 차 하나에 대한 정보를 출력할 메소드
	 */
	public void displayMember(RentCarDto car) {
		System.out.println("\n조회된 전체 렌터카 정보는 다음과 같습니다.");
		System.out.println("\n렌트번호\t차량번호\t차종\t  인수일자\t\t인수시간"
				+ "\t\t반납일자\t\t반납시간\t    대여기간\t가격\t 분류\t 연료\t 정원\t 연식");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(car);
	}
	
	
	/**
	 * @param String message 성공 메세지 출력
	 */
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 결과 : "+message)  ;
	}
	
	/**
	 * @param RentCarDto rentcar 최종 마지막 예약을 할 렌트카 리스트 데이터 출력
	 */
	public void displayfinRentCar(RentCarDto rentcar) {
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sim2 = new SimpleDateFormat("HH:mm:ss");
		
		String enddate = " ";
		String endtime = " ";
		
		if (rentcar.getRentcar_enddate() != null) {
			
			 enddate = sim.format(rentcar.getRentcar_enddate());
	         endtime = sim2.format(rentcar.getRentcar_endtime());
	        
		} else {
			
			 enddate = " ";
			 endtime = " ";	
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.print("\t렌트번호");
		System.out.print("\t\t\t차량번호");
		System.out.println("\t\t\t차종");
		System.out.println("\t" + rentcar.getRentcar_no() + "\t\t\t" + rentcar.getCar_no() + "\t\t\t" + rentcar.getRentcar_model());
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.print("\t인수일자");
		System.out.print("\t\t\t인수시간");
		System.out.print("\t\t\t반납일자");
		System.out.println("\t\t\t반납시간");
		System.out.print("\t" + rentcar.getRentcar_date());
		System.out.print("\t\t" + rentcar.getRentcar_datetime());
		System.out.print("\t\t" + enddate);
		System.out.println("\t\t\t" + endtime);
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.print("\t대여기간");
		System.out.print("\t가격");
		System.out.print("\t분류");
		System.out.print("\t연료");
		System.out.print("\t정원");
		System.out.println("\t연식");
		
		System.out.print("\t" + rentcar.getRentcar_renttime());
		System.out.print("\t" + rentcar.getRentcar_price());
		System.out.print("\t" + rentcar.getRentcar_section());
		System.out.print("\t" + rentcar.getRentcar_fuel());
		System.out.print("\t" + rentcar.getRentcar_limit());
		System.out.println("\t" + rentcar.getRentcar_time());
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		
		
	}
	
}