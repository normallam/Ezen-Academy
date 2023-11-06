package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.EmployeeController;
import 이젠아카데미.controller.LessonController;
import 이젠아카데미.model.dto.EmployeeDto;
import 이젠아카데미.model.dto.LessonDto;

public class EmployeeView {

	// 0. 싱글톤
	private static EmployeeView EmployeeView = new EmployeeView();
	public static EmployeeView getInstance() { return EmployeeView; }
	private EmployeeView() {}
	
	private Scanner sc = new Scanner(System.in);
	
	public void EmployeeMain() {
	
		while(true) {
			System.out.println("================직원관리===============");
			System.out.println("1.직원 등록 2.직원 조회 3.직원 수정 4.직원 삭제");
			System.out.println(">>> 선택");
			int ch = sc.nextInt();
			
			if(ch==1) {employeewriteView();}//직원등록
			if(ch==2) {employeeprintView();}//직원조회
			if(ch==3) {employeeupdateView();}//직원수정
			if(ch==4) {employeedeleteView();}//직원삭제
			
			
		}// while e	
	}
	
//1. 직원등록-----------------------------------------------------------------	

	public void employeewriteView() {
		sc.nextLine();
		System.out.println("직급 : ");		String era = sc.nextLine(); 
		System.out.println("이름 : ");		String ename = sc.nextLine();
		System.out.println("급여 : ");		int epay = sc.nextInt();

		boolean result = EmployeeController.getInstance().employeewriteView(era,ename,epay);

		if(result) {System.out.println("직원등록 성공");}

		else {System.out.println("직원등록 실패");}

	}
		
//2. 직원조회-----------------------------------------------------------------	
	
	public void employeeprintView() {
		ArrayList<EmployeeDto> result = EmployeeController.getInstance().employeeprintView();		
			System.out.println("\n\n================직원조회================");
			
		System.out.printf("%3s %1s %5s %13s \n","직원코드", "직급", "이름","급여");
			for(int i = 0; i<result.size(); i++) {
				EmployeeDto dto = result.get(i);	
				
				System.out.printf("%3s %5s %5s %13s \n", dto.getEno(), dto.getEra(),dto.getEname(),dto.getEpay());
			}
			
			
	}

//3. 직원수정--------------------------------------------------------------	
	public void employeeupdateView() {
		
		employeeprintView();
		System.out.println("직원코드 : ");		int eno = sc.nextInt();
		sc.nextLine();
		System.out.println("직급 : ");		String era = sc.nextLine(); 
		System.out.println("이름 : ");		String ename = sc.nextLine();
		System.out.println("급여 : ");		int epay = sc.nextInt();
	
		boolean result = 
				EmployeeController.getInstance().employeeupdateView(eno,era,ename,epay);
			
		if(result) {System.out.println("직원정보 수정 성공");}
			
		employeeprintView();
	}

//4. 직원삭제--------------------------------------------------------------
	public void employeedeleteView() {
		employeeprintView();
		System.out.println("\n\n================수업삭제================");
		System.out.println("삭제할 직원을 선택하세요."); int eno = sc.nextInt();
		
		sc.nextLine();
		System.out.println("해당 직원항목을 삭제하시겠습니까? 1.예 2.아니요 :"); int ch = sc.nextInt();
		if(ch==1) {
			boolean result = EmployeeController.getInstance().employeedeleteView(eno);
			if(result) {
				System.out.println(" 안내] 직원 삭제성공");
			}else {
				System.out.println(" 안내] 직원 삭제실패");
				
			}
				
		}		
		
	}
	
	
	
	
	
	
	
	
}// class e
