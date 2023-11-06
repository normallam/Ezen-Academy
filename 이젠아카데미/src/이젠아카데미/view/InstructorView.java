package 이젠아카데미.view;
//강사, 행정 나눠서 학생 정보 볼 수 있는 페이지


import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.IncentivesController;
import 이젠아카데미.controller.InstructorController;
import 이젠아카데미.controller.SignupController;
import 이젠아카데미.model.dto.InstructorDto;


public class InstructorView {
	private static InstructorView instructor = new InstructorView();
	public static InstructorView getInstance() {return instructor;}
	private InstructorView() {}
	
	private Scanner sc = new Scanner(System.in);
	

//1. mainpage 직원(강사,행정) 인지 확인 보여주는 페이지(고연진)---------------------------------------------------------	
	//강사면 수업 듣는 학생의 전체보기 
	public void instructorMain() {
/*
 	loginSession 값의 jno의 분류 필드에서 강사와 일치한걸 가져옴
 */
		int jno = SignupController.getInstance().getLoginSession();
		
		boolean result= InstructorController.getInstance().instructorMain(jno);
		

			
		if(result) {//만약 강사로 들어왔으면 수강 중인 학생 정보만 보여주기
			System.out.println("강사로 로그인 성공");
			//수강생 조회
			SManagement(jno);
		
			System.out.println("--------------------------------");
			System.out.println("1.학생조회  2.쪽지보내기");
			System.out.println("--------------------------------");
			System.out.print(">>선택: "); int ch=sc.nextInt();
			
			if(ch==1) {// 개별학생조회
				StudentView.getStudentView().studentInfo();}
			else if(ch==2) {
				MessageView.getInstance().messageSend();}
		
	
	
		}
		else {// 행정으로 로그인하면 학생 전체 출력
			/*
			 * System.out.println("행정 로그인 성공");
			 * IncentivesController.getInstance().훈련장려금목록();
			 * IncentivesController.getInstance().훈련장려금지급();
			 */
			}
		
			
	}//f()

	

//2.강사면 수업을 듣는 학생 전체를 보여주는 view(고연진)---------------------------

	public void SManagement(int jno) {
		//jno= SignupController.getInstance().getLoginSession();
		
		ArrayList<InstructorDto> result = 
				InstructorController.getInstance().SManagement(jno);
		System.out.println("==============수강생==============");
		System.out.printf("%-3s%-7s%-6s%-10s\n","학번","이름","주소","번호");
		for(int i=0; i<result.size();i++) {
			InstructorDto dto =result.get(i); 
			System.out.printf("%-3s%-7s%-6s%-10s\n" ,dto.getSno(),dto.getSname(),dto.getSaddress(),dto.getSphone());
		}
		System.out.println("================================");
	}
	

	
	

}//c
