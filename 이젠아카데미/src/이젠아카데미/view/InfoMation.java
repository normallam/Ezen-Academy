package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.AttendanceController;
import 이젠아카데미.controller.BoardController;
import 이젠아카데미.model.dto.BoardDto;

public class InfoMation {
	private static InfoMation infoMtion = new InfoMation();
	public static  InfoMation getInstance() {return infoMtion;}
	private InfoMation() {}
	
	private Scanner sc = new Scanner(System.in);
	public void InfoMationMenu() {
		System.out.println("1.자유 게시판 2.후기 게시판 3.출석하기 4. 출석률 5. 훈련장려금 6.뒤로가기"); int ch =sc.nextInt();
		// 기준 수정

		if(ch==1) {board();}

		if(ch==2) {ReviewBoardView.getInstance().ReviewBoardMain();}
		if(ch==3) { 출석하기();}
		if(ch==4) {출석률();}
		//if(ch==5) {훈련장려금();}
		if(ch==6) {}
		
	}
	
	public void board() {
		BoardView.getInstance().boardPrint();
		System.out.println("1.내글보기 2. 글쓰기 3.다른사람글보기 4.뒤로가기"); int select = sc.nextInt();
		
		if(select==1) {myWriting();}
		if(select==2) {boardWrite();}
		if(select==3) {BoardView.getInstance().boardView2(); InfoMationMenu();}
		if(select==4) {InfoMationMenu();}
	}
	// 1. 내글보기 메소드
	public void myWriting() {
		System.out.println("---------------------------------------- MyWriting LIST -------------------------------------");
		try {
		
			ArrayList<BoardDto> result=
					BoardController.getInstance().myWriting();
			
			System.out.printf("%-10s %-5s %-20s %-50s %-15s %-10s\n", "글번호", "학생번호", "제목", "내용", "작성일", "조회수");
			for(int i =0; i<result.size(); i++) {
				BoardDto dto = result.get(i);
				
				System.out.printf("%-10s %-12s %-20s %-50s %-15s %-10s\n",
	                    dto.getBno(), dto.getSno(), dto.getBtitle(), dto.getBcontent(), dto.getBday(), dto.getBview());
				System.out.println("------------------------------------------------------------------------------------------");
				
			}
		
		
		System.out.println("1. 글수정 2. 글삭제 3. 뒤로가기"); int ch= sc.nextInt();
		if (ch == 1) {
		    System.out.println("게시물번호: ");
		    int bno = sc.nextInt();
		    int sno = BoardController.getInstance().getLoginSession(); // 
		    boardUpdate(bno, sno);
		}
		if(ch==2) {
			System.out.println("게시물번호: "); int bno = sc.nextInt();
			System.out.print("1. 삭제 2. 취소"); int select = sc.nextInt(); 
			if(select==1) {boardDelete(bno);}
			if(select==2) {System.out.println("안내] 취소완료."); board();}
		}
		
		
		if(ch==3) {board();}
		}catch (Exception e) {System.out.println("오류알려줘"+e);}
	}
		
	
	public void boardWrite() {
	      System.out.println("---------  글쓰기 ----------");
	      System.out.println("제목 >"); String title =sc.next();
	      System.out.println("내용 >"); String content =sc.next();
	      
	      BoardView.getInstance().boardPrint();
	      boolean result=
	      BoardController.getInstance().boardWrite(title, content);
	      if(result) {System.out.println("안내] 글쓰기 등록");InfoMationMenu();}
	      else {System.out.println("안내] 글쓰기 실패 : 제목 1~50 사이로 필수 입력");}   
	   }
	   
	 
	public void boardDelete(int bno) {
	
	try {		
		int result = 
				BoardController.getInstance().boardDelete(bno);
		
		if(result == 1) {System.out.println("안내] 글 삭제 성공"); InfoMationMenu();}
		else if(result==2) {System.err.println("경고] 글 삭제 실패 : 관리자 오류"); InfoMationMenu();}
		else if(result==3) {System.err.println("경고] 본인 글만 삭제 가능합니다."); InfoMationMenu();}
		else if(result==4) {System.err.println("경고] 없는 게시물 입니다. 게시물 번호를 확인해주세요!!"); InfoMationMenu();}
		
		}
		catch (Exception e) {System.out.println();
		}
	}
	public void boardUpdate(int bno, int sno) {
	
		System.out.println("수정할제목 >"); String title =sc.next();
		System.out.println("수정할내용 >"); String content =sc.next();
		
		try {
		int result =
				BoardController.getInstance().boardUpdate(bno, sno, title, content);
		
		if(result == 1) {System.out.println("안내] 글 수정 성공"); InfoMationMenu();}
		else if(result==2) {System.err.println("경고] 글 수정 실패 : 없는 게시물 번호 입니다."); InfoMationMenu();}
		else if(result==3) {System.err.println("경고] 본인 글만 수정 가능합니다."); InfoMationMenu();}
		else if(result==4) {System.err.println("경고] 수정할 제목을 1~50글자 사이로 입력해주세요."); InfoMationMenu();}	 
	
	} catch (Exception e){
		e.printStackTrace(); }
	}
	public void 출석하기() {
		boolean result = AttendanceController.getInstance().출석하기();
		if(result) {System.out.println(" 출석 완료 "); InfoMationMenu();}
		else {System.out.println("이미 출석 했습니다."); InfoMationMenu();}
	}
	public void 출석률() {
	      int 출석횟수 = AttendanceController.getInstance().출석횟수();
	      System.out.println("나의 출석 횟수 : " + 출석횟수);
	      int 총수강일 = AttendanceController.getInstance().총수강일();
	      System.out.println("나의 총수강일 : " + 총수강일);
	      System.out.println("--------- 출석률 확인 ----------");
	      System.out.printf(
	             BoardController.getInstance().getLoginSession() + "의 출석률 : %.2f%% \n",
	             ((double)출석횟수 / 총수강일 * 100)
	         );
	      System.out.print("1. 뒤로가기 2. 초기화면");
	      int ch = sc.nextInt();
	      
	      if(ch == 1) {InfoMationMenu();}
	      else if( ch == 2) {}
	   }
	
		/*
		 * public void 훈련장려금() { System.out.println("--------- 훈련 장려금 ----------");
		 * 
		 * int 출석횟수 = AttendanceController.getInstance().출석횟수();
		 * 
		 * 
		 * ArrayList<StudentDto> result= IncentivesController.getInstance().훈련장려금목록();
		 * if(출석횟수 >= 12) {System.out.println (result);}
		 * 
		 * IncentivesController.getInstance().훈련장려금지급(); }
		 */
}
