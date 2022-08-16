package com.uni.rentCar.view;

import java.util.List;
import java.util.Scanner;

import com.uni.rentCar.controller.RentCarController;
import com.uni.rentCar.model.dto.RentCarDto;

public class RentCar_Menu {

	private static Scanner sc = new Scanner(System.in);
	private RentCarController memberController = new RentCarController();
	
	public void RentCarMenu() {
		
		int choice;

		do {
			System.out.println("\n******memberService*회원관리프로그램********");
			System.out.println("1.회원 전체 조회");// SELECT
			System.out.println("2.회원 아이디 조회");// SELECT
			System.out.println("3.회원 이름 조회");// SELECT
			System.out.println("4.회원 가입");// INSERT
			System.out.println("5.회원 정보 변경");// UPDATE
			System.out.println("6.회원 탈퇴");// DELETE
			System.out.println("9.프로그램 끝내기");// 종료
			System.out.println("번호선택 : ");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				memberController.selectAll();
				break;
			case 2:
				memberController.selectOne(inputMemberId());
				break;
			case 3:
				memberController.selectByName(inputMemberName());
				break;
			case 4:
				//memberController.insertMember(inputMember());
				break;
			case 5:
				//memberController.updateMember(updateMember());
				break;
			case 6:
				memberController.deleteMember(inputMemberId());
				break;
			case 9:
				System.out.println("정말로 끝내시겠습니까??(y/n)");
				if ('y' == sc.next().toLowerCase().charAt(0)) {
					memberController.exitProgram();
					return;
				}

				break;

			default:
				System.out.println("번호를 잘못입력하였습니다.");
			}

		} while (true);
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

	// 리턴된 리스트 출력용 메소드
	public void displayMemberList(List<RentCarDto> list) {
		System.out.println("\n조회된 전체 회원정보는 다음과 같습니다.");
		System.out.println("\n아이디\t이름\t성별\t나이\t이메일\t전화번호\t주소\t취미\t가입일");
		System.out.println("----------------------------------------------------------");

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
		System.out.println("\n조회된 전체 회원정보는 다음과 같습니다.");
		System.out.println("\n아이디\t이름\t성별\t나이\t이메일\t전화번호\t주소\t취미\t가입일");
		System.out.println("----------------------------------------------------------");
		
		System.out.println(m);
	}
	//성공 메세지 출력
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 결과 : "+message)  ;
	}
		
	
}
