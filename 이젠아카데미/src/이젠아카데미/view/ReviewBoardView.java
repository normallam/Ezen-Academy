package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.BoardController;
import 이젠아카데미.controller.ReviewBoardController;
import 이젠아카데미.model.dto.BoardDto;
import 이젠아카데미.model.dto.ReviewBoardDto;

public class ReviewBoardView {
	private static ReviewBoardView ReviewBoardView= new ReviewBoardView();
	public static ReviewBoardView getInstance() { return ReviewBoardView; }
	private ReviewBoardView() {}
	
	private Scanner sc = new Scanner(System.in);
	
	public void ReviewBoardMain() {
		
		while(true) {
			System.out.println("================후기게시판===============");
			System.out.println("1.글쓰기 2.글 전체조회 3.내글 조회 4.글 수정 5.글  삭제 6. 뒤로가기");
			System.out.println("선택 >>>");
			int ch = sc.nextInt();
			
			if(ch==1) {reviewWrite();} // 1.글쓰기
			if(ch==2) {reviewTotalView();} // 2. 글 전체조회
			if(ch==3) {reviewIndividualView();} // 3. 내 글 조회
			//if(ch==4) {reviewUpdate();} // 4. 글 수정
			//if(ch==5) {reviewDelete();} // 5. 글 삭제
			//if(ch==6) {InfoMation.getInstance().InfoMationMenu();} // 5. 글 삭제
	
		}// while e
		
	}// main e
	
// 1. 글쓰기-----------------------------------------------------------------

	public void reviewWrite() {
		System.out.println("--------- Review Write ----------");
		System.out.println("제목 : "); String rtitle = sc.next();
		System.out.println("내용 : "); String rcontent = sc.next();
		System.out.println("평점 : "); int rgrade = sc.nextInt();
		// 여기에 수업코드를 넣는건가.
		
		reviewTotalView(); // 글 전체조회 보여주기
		
		boolean result = ReviewBoardController.getInstance().reviewWrite(rtitle,rcontent,rgrade);
		if(result) {System.out.println("안내] 글쓰기 등록 성공");InfoMation.getInstance().InfoMationMenu();}
		else {System.out.println("안내] 글쓰기 실패 : 제목 1~50 사이로 필수 입력");}
		
		

		
	}

	
// 2. 글 전체조회-----------------------------------------------------------------	

	public void reviewTotalView() {
		
		ArrayList<ReviewBoardDto> result =
				ReviewBoardController.getInstance().reviewTotalView();

		System.out.println("--------------- Review List -------------");
		System.out.printf("%-3s %-4s %-13s %-10s \n","rno","sno","rtitle","rgrade");
		for(int i=0;i<result.size();i++) {
			ReviewBoardDto dto = result.get(i);
			
			System.out.printf("%-3s %-4s %-13s %-10s \n",
					dto.getRno(), dto.getSno(), dto.getRtitle(), dto.getRgrade());
			System.out.println("-----------------------------------------");
		}
	
	}
	
	
// 3. 내글 조회-----------------------------------------------------------------

	public void reviewIndividualView() {
		
		try {	
			System.out.println("-------------------My Review--------------------");
		
				ArrayList<ReviewBoardDto> result = 
						ReviewBoardController.getInstance().reviewIndividualView();
				
				System.out.printf("%-3% %-3s %-13s %-25s %-10s \n","게시물 번호","회원코드","제목","내용","평점");
				for(int i=0;i<result.size();i++) {
					ReviewBoardDto dto = result.get(i);
					
					
					System.out.printf("%-3% %-3s %-13s %-25s %-10s \n", dto.getRno(),dto.getSno(), dto.getRtitle(), dto.getRcontent(), dto.getRgrade());
					System.out.println("------------------------------------------------------------------------------------------");
			
				}
		
			System.out.println("1. 후기글 수정 2. 후기글 삭제 3. 뒤로가기 "); int ch =sc.nextInt();
				if(ch==1) {
					System.out.println("게시물 번호");
					int rno = sc.nextInt();
					int sno = ReviewBoardController.getInstance().getLoginSession();
				//	reviewUpdate(rno,sno);
				}
				if(ch==2) {
					System.out.println("게시물 번호"); int rno = sc.nextInt();
					System.out.println("1.삭제 2.취소"); int select = sc.nextInt();
				//	reviewDelete(rno);
				}
				if(ch==3) {ReviewBoardMain();}
			
		}catch(Exception e) {System.out.println("후기글 수정/삭제 선택오류 내용"+e);}
		

		
		
	}
	
	
// 4. 글 수정-----------------------------------------------------------------
/*
	public void reviewUpdate(int rno, int sno) {
		
		System.out.println("수정할제목 >"); String title = sc.next();
		System.out.println("수정할내용 >"); String content = sc.next();
		
		
		try {
			int result = 
					ReviewBoardController.getInstance().reviewUpdate(rno,sno,rtitle,rcontent);
			
			if(result==1) {System.out.println("안내] 글 수정 성공"); InfoMation.getInstance().InfoMationMenu(); }
			else if(result==2) {System.out.println("경고] 글 수정 실패 : 관리자 오류"); InfoMation.getInstance().InfoMationMenu();}
			else if(result==3) {System.out.println("경고] 본인 글만 수정 가능합니다."); InfoMation.getInstance().InfoMationMenu();}
			else if(result==4) {System.out.println("경고] 수정할 제목을 1~50글자 사이로 입력해주세요."); InfoMation.getInstance().InfoMationMenu();}
		}catch(Exception e) {System.out.println("후기글 수정 오류 내용"+e);
			
		}	
*/
/*		public void boardUpdate(int bno, int sno) {
			
			System.out.println("수정할제목 >"); String title =sc.next();
			System.out.println("수정할내용 >"); String content =sc.next();
			
			try {
			int result =
					BoardController.getInstance().boardUpdate(bno, sno, title, content);
			
			if(result == 1) {System.out.println("안내] 글 수정 성공"); InfoMationMenu();}
			else if(result==2) {System.out.println("경고] 글 수정 실패 : 관리자 오류"); InfoMationMenu();}
			else if(result==3) {System.out.println("경고] 본인 글만 수정 가능합니다."); InfoMationMenu();}
			else if(result==4) {System.out.println("경고] 수정할 제목을 1~50글자 사이로 입력해주세요."); InfoMationMenu();}	 
		
		} catch (Exception e){
			e.printStackTrace(); }
		}
		
		
*/
		
//	}
	
	
// 5. 글 삭제 -----------------------------------------------------------------
	
	public void reviewDelete() {
		
		
	}
	
	
	
}// class e
