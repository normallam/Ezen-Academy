package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.StudentController;
import 이젠아카데미.model.dto.StudentDto;

public class StudentView {
	
	private Scanner sc = new Scanner(System.in);

	private static StudentView v= new StudentView();
	public static StudentView getStudentView() {return v;}
	private StudentView() {}

// 0. 메인페이지--------------------------------------------------------------------	
	public void studentMain() {
		while(true) {
			try {

			System.out.println("1.학생등록 2.학생정보조회 3.학생정보수정 4.학생삭제 5.훈련장려금 6.초기화면");

			System.out.print("선택: "); int ch= sc.nextInt();
			if(ch==1) {studentJoin();}//학생등록
			else if (ch==2) {studentAllSelect();}//학생조회
			else if(ch==3) {studentUpdate();}//학생수정
			else if(ch==4) {studentDelete();}//학생삭제
			//else if(ch==5) {InfoMation.getInstance().훈련장려금();}//학생삭제
			else if(ch==6) {MainPage.getInstance().mainPage();}
			
			} catch (Exception e) {
				System.out.println("숫자로 입력해주세요");
				sc= new Scanner(System.in);}
		}//while
	}
	
	
//1. 학생등록(고연진)---------------------------------------------------------------------	
	public void studentJoin() {
		System.out.print("이름: "); String sname =sc.next();
		System.out.print("주소: "); String saddress =sc.next();
		System.out.print("번호: "); String sphone =sc.next();
		System.out.print("수업코드: "); int lno =sc.nextInt();

		
		boolean result= 
				StudentController.getInstance().studentJoin(sname,saddress,sphone,lno);
		
		if(result) {
			System.out.println("학생 등록");}
		else {System.out.println("학생등록 실패");}	
	}//studentJoin()

	
//2-1 전체 학생 정보조회(이진형)-------------------------------------------	
	public void studentAllSelect() {
		ArrayList<StudentDto> result = StudentController.getInstance().studentAllSelect();
		
		System.out.println("\n\n ===== 학생 조회 =====");
		
		System.out.printf("%-3s %-4s %-15s %-10s %s \n","학생번호", "이름","주소","전화번호","수업코드");
		   for(int i = 0; i<result.size(); i++) {
			   StudentDto dto = result.get(i);	// i번째 객체를 호출
			   
			   System.out.printf("%-3s %-4s %-15s %-10s %s \n", dto.getSno(), dto.getSname() , dto.getSaddress(), dto.getSphone(),dto.getLno());
		  
		   }//f
	
		   return;
		
	}//f()
	
//2-2. 학생별 상세 조회(고연진)------------------------------
	public void studentInfo() {
		try {
			System.out.println("상세 조회를 원하는 학생의 코드: "); int sno=sc.nextInt();
			StudentDto result=StudentController.getInstance().studentInfo(sno);
			
			System.out.println("이름: "+result.getSname());
			System.out.println("수업: "+result.getLname());
			System.out.println("전화번호: "+result.getSphone());
			System.out.println("주소: "+ result.getSaddress());
			
			
			System.out.print("1. 뒤로가기 ");
			int ch = sc.nextInt(); 
			if(ch ==1) {InstructorView.getInstance().instructorMain();}
			return;
			
		}catch (Exception e) {
			System.out.println("숫자로 입력해주세요: ");
			sc=new Scanner(System.in);
			}//c
		
	}//f()	

	
//3. 학생정보수정(고연진)-----------------------------------------------------
	public void studentUpdate() {
	
		studentAllSelect();
		 
		System.out.println("학생번호: "); int sno=sc.nextInt();
		System.out.println("이름: "); String sname=sc.next();
		System.out.println("주소: "); String saddress=sc.next();
		System.out.println("전화번호: "); String sphone=sc.next();
		System.out.println("수업코드: "); int lno=sc.nextInt();
			
		boolean result = 
				StudentController.getInstance().studentUpdate(sno,sname,saddress,sphone,lno);
		
		if(result) {System.out.println("학생정보수정성공");}
		
		studentAllSelect();
	}//f()
	
	
	
//4. 학생삭제(이진형)----------------------------------------------------------------------
	public void studentDelete() {
		
			studentAllSelect();
			System.out.println("\n\n ===== 학생 삭제 =====");
			System.out.print("삭제할 학생을 선택하세요. >"); int sno = sc.nextInt();
		   
		   System.out.print("해당 학생을 삭제하시겠습니까? 1.예 2.아니요 :"); int ch = sc.nextInt();
		   if(ch ==1) {
			   boolean result = StudentController.getInstance().studentDelete(sno);
			   	if(result) { System.out.println("안내] 학생삭제성공");} 
			   	else { System.out.println("경고] 학생삭제취소");}
		   }//if
	}//f()
	
	
	
}//class
