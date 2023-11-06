package 이젠아카데미.view;

import java.util.Scanner;

import 이젠아카데미.controller.BoardController;
import 이젠아카데미.controller.SignupController;

public class MainPage {

   private static MainPage mainpage= new MainPage();
   public static MainPage getInstance() {return mainpage;}
   private MainPage() {}
   
   private Scanner sc= new Scanner(System.in);
// 메인페이지-------------------------------------------------------------------
   	


		public void mainPage() {
			while(true) {
				System.out.println();
				System.out.println("======================");
				System.out.println("1. 직원 2. 학생");
				System.out.println("======================");

				try {
					System.out.print("선택:  "); int ch= sc.nextInt();
			
					if( ch == 1) {manager();} 
					else if(ch ==2) {student();}
					else {System.out.println("1번과 2번 중에 고르세요"); 
							sc=new Scanner(System.in);}
				} catch (Exception e) {
					System.out.println("숫자로 입력하세요\n오류사유: "+e);
					sc = new Scanner(System.in);}
					
			}//while
			
		}//MainPage()

		
	// 학생 눌렀을 때 선택되는 창 (고연진)--------------------------------------------------------	
		public void student() {
			information();
		}//f()
		
	// 직원 선택했을 때 띄워지는 창 (고연진) ------------------------------------------------------
		public void manager() {//직원 (원장, 강사, 행정)
		
			
			SignupView.getInstance().login();
			if(SignupController.getInstance().getLoginSession()==1) {//직원이 원장일때만 수정 가능
				System.out.println("관리자 로그인 성공");
				System.out.println("-----------------------------------------------------");
				System.out.println("1. 학생관리 2. 수업관리 3. 게시판관리 4.출결관리 5.직원관리");
				System.out.println("------------------------------------------------------");
				try {
					System.out.print("선택: "); int select=sc.nextInt();
					if(select==1) {StudentView.getStudentView().studentMain();}
					else if(select==2){LessonView.getInstance().LessonMain();}
					else if(select==3){BoardView.getInstance().BoardMain();}
					else if(select==4){AttendanceView.getInstance().attendancePrint();}
					else if(select==5) {EmployeeView.getInstance().EmployeeMain();}
				}catch (Exception e) {
					System.out.println("오류발생: "+e);
					sc = new Scanner(System.in);
					}//catch
			}//if
			else if(SignupController.getInstance().getLoginSession()>1) {
						System.out.println("직원 로그인성공");
						//직원들 (행정 , 강사) 로그인 시 이동
						InstructorView.getInstance().instructorMain();}
		
		}//f()

	// 처음 학생 선택했을 때 (박상빈)	
		public void information() {
			System.out.println("회원이름 : "); String name = sc.next();
			System.out.println("회원전화번호 : "); String phone = sc.next();
			boolean result=BoardController.getInstance().information(name,phone);
			
			if(result) {
				System.out.println("안내] 로그인 성공했습니다. 감사합니다!!");
				InfoMation.getInstance().InfoMationMenu();
				}
			else {System.err.println("경고] 로그인실패. 다시확인해주세요!!");}
		}//f()

   

   }

		
	//class