package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.BoardController;
import 이젠아카데미.model.dto.BoardDto;



public class BoardView {
	private static BoardView boardView = new BoardView();
	public static BoardView getInstance() {return boardView;}
	private BoardView() {}
	
	private Scanner sc = new Scanner(System.in);
	
	public void BoardMain() {
		while(true) {
			
			
			// 내정보,쓴글 페이지에서 다음으로 안 넘어가서 주석처리해봄
			boardPrint(); 
			System.out.println("1.글조회 2. 뒤로가기");int ch = sc.nextInt();
			if(ch==1) {boardView();}
			if(ch==2) {MainPage.getInstance().mainPage();}
		}
	}
	
	// 글 조회
	public void boardPrint() {
		
		ArrayList<BoardDto> result=
				BoardController.getInstance().boardPrint();
		System.out.println("---------------------------------------- POST LIST -------------------------------------");
		System.out.printf("%13s %13s %10s %26s %32s \n","bno","sno","title","day","view");
		for(int i =0; i<result.size(); i++) {
			BoardDto dto = result.get(i);
			
			System.out.printf("%13s %13s %10s %30s %17s\n",
					dto.getBno(),dto.getSno(),dto.getBtitle(),dto.getBday(),dto.getBview());
			System.out.println("------------------------------------------------------------------------------------------");
			
		}
	}
	public void boardView() {
		try {
		System.out.println("----- POST VIEW -------");
		// 1. 보고자하는 게시물의 게시물번호를 입력받기[식별번호]
		System.out.println("게시물번호: "); int bno = sc.nextInt();
		
		BoardDto result = BoardController.getInstance().boardView(bno);
		
		System.out.printf("bno : %-3s view : %-3s day : %-19s \n" , 	result.getBno() , result.getBview() , result.getBday() );
		
		System.out.printf("title : %s \n",result.getBtitle());
		System.out.printf("content : %s \n ",result.getBcontent());
		System.out.println("--------------------------------------");
		System.out.print("1.글삭제 2.뒤로가기"); 
		
	
		int ch= sc.nextInt();
		
		
		if(ch==1) {boardDelete(bno); }
		if(ch==2) {boardPrint();}
		}catch (Exception e) {System.out.println("오류나는이유: "+e);}
	}
	public void boardDelete(int bno) {
			try {
			System.out.print("1. 글삭제 2. 취소"); int ch = sc.nextInt();
			
			if( ch == 1) {
			int result = BoardController.getInstance().boardDelete(bno);
			
				if(result==1) System.out.println("글삭제 성공");
				else {System.out.println("글삭제 실패");}
			} else if ( ch == 2) {}	
			} catch (Exception e) {
				System.out.println("오류나는이유: "+e);
			}
		}
	
	public void boardView2() {
		try {
		System.out.println("----- POST VIEW -------");
		// 1. 보고자하는 게시물의 게시물번호를 입력받기[식별번호]
		System.out.println("게시물번호: "); int bno = sc.nextInt();
		
		BoardDto result = BoardController.getInstance().boardView(bno);
		
		System.out.printf("bno : %-3s view : %-3s day : %-19s \n" , 	result.getBno() , result.getBview() , result.getBday() );
		 
		System.out.printf("title : %s \n",result.getBtitle());
		System.out.printf("content : %s \n ",result.getBcontent());
		System.out.println("--------------------------------------");
		}catch (Exception e) {System.out.println("오류나는이유: "+e);}
	}
	
}
