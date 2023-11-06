package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.LessonController;
import 이젠아카데미.model.dto.LessonDto;

public class LessonView {
	// 0. 싱글톤
	private static LessonView LessonView = new LessonView();
	public static LessonView getInstance() { return LessonView; }
	private LessonView() {}
	
	private Scanner sc = new Scanner(System.in);
	
	public void LessonMain(){	
	while(true) {
		System.out.println("================수업관리===============");
		System.out.println("1.수업 등록 2.수업 조회 3.수업 수정 4.수업 삭제");
		System.out.println("선택>>>");
		int ch = sc.nextInt();
		

		if(ch==1) {lessonwriteView();}//수업등록
		if(ch==2) {lessonprintView();}//수업조회
		if(ch==3) {lessonupdateView();}//수업수정
		if(ch==4) {lessondeleteView();}//수업삭제


		}// while e
	}
//1. 수업등록-----------------------------------------------------------------	

	public void lessonwriteView() {
		sc.nextLine();
		System.out.println("수업명 : ");		String lname = sc.nextLine();
		System.out.println("강사명 : ");		String ltname = sc.nextLine(); 
		System.out.println("총수강일 : ");		String ltdate = sc.nextLine();
		System.out.println("개강일 : ");		String lopenday = sc.nextLine();

		boolean result = LessonController.getInstance().lessonWriteView(lname,ltname,ltdate,lopenday);

		if(result) {System.out.println("수업등록 성공");}

		else {System.out.println("수업등록 실패");}



	
	}
	

	

//2. 수업조회-----------------------------------------------------------------	
public void lessonprintView() {
		ArrayList<LessonDto> result = LessonController.getInstance().lessonprintView();		
		System.out.println("\n\n================수업조회================");
		
		System.out.printf("%3s %1s %1s %3s %5s \n","수업코드", "수업명", "선생님이름","총수강일","개강일");
			for(int i = 0; i<result.size(); i++) {
				LessonDto dto = result.get(i);	
				
				System.out.printf("%3s %5s %5s %6s %13s \n", dto.getLno(), dto.getLname(),dto.getLtname(),dto.getLtotalday(),dto.getLopenday());
			}
		
		
	}

//3. 수업수정--------------------------------------------------------------	
	public void lessonupdateView() {
	
		lessonprintView();
		System.out.println("수업코드 : "); 	int lno = sc.nextInt();
		sc.nextLine();
		System.out.println("수업명 : ");		String lname = sc.nextLine();
		System.out.println("강사명 : ");		String ltname = sc.nextLine(); 
		System.out.println("총수강일 : ");	String ltdate = sc.nextLine();
		System.out.println("개강일 : ");		String lopenday = sc.nextLine();
		
		boolean result = 
				LessonController.getInstance().lessonupdateView(lno,lname,ltname,ltdate,lopenday);
		
		if(result) {System.out.println("수업정보 수정 성공");}
		
		lessonprintView();
	}


//4. 수업삭제------------------------------------------------------------------
	
	public void lessondeleteView() {
	
		lessonprintView();
		System.out.println("\n\n================수업삭제================");
		System.out.println("삭제할 수업을 선택하세요."); int lno = sc.nextInt();
		
		sc.nextLine();
		System.out.println("해당 수업을 삭제하시겠습니까? 1.예 2.아니요 :"); int ch = sc.nextInt();
		if(ch==1) {
			boolean result = LessonController.getInstance().lessondeleteView(lno);
			if(result) {
				System.out.println(" 안내] 수업 삭제성공");
			} else {
				System.out.println(" 안내] 수업 삭제실패");
			}
			
		}

	
	}
	
}// class e
