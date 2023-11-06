package 이젠아카데미.view;

import java.util.ArrayList;
import java.util.Scanner;

import 이젠아카데미.controller.MessageController;
import 이젠아카데미.controller.SignupController;
import 이젠아카데미.model.dto.MessageDto;

public class MessageView {

	private static MessageView M = new MessageView();
	public static MessageView getInstance() {return M;}
	private MessageView() {}
	
	private Scanner sc = new Scanner(System.in);

//1. 메세지 보내기(고연진)-----------------------------------------------------------
	public void messageSend() {
		int eno=SignupController.getInstance().getLoginSession();
		
		System.out.println("-------------쪽지보내기--------------");
	
		System.out.print("학번을 입력: ");	 int sno = sc.nextInt(); 
		sc.nextLine();
		System.out.print("메세지 내용 입력: "); String mcontent =sc.nextLine();
		
		MessageDto dto= new MessageDto(eno, sno, mcontent);
		boolean result=MessageController.getInstance().messageSend(dto);
		if(result) {System.out.println("쪽지 보내기 성공");}
		else {System.out.println("[관리자문의]쪽지보내기실패 ");}
		messageAllView();
	}
	

//2. 메세지 보기(고연진) 출력----------------------------------------------------
	public void messageView() {
		System.out.print("번호 선택>>"); int mno=sc.nextInt();
		MessageDto result= MessageController.getInstance().messageView(mno);
		System.out.println("<받는사람>\n"+result.getSname());
		System.out.println("<메세지내용>\n"+result.getMcontent());
		
		
	}
	
	
//3. 전체 메세지 보기(보낸쪽지함)
	public void messageAllView() {
		int eno=SignupController.getInstance().getLoginSession();
		ArrayList<MessageDto> result= MessageController.getInstance().messageAllView(eno);
		System.out.printf("%-5s %-10s%-15s\n","번호","받는학생","내용");
		for(int i=0; i<result.size();i++) {
			MessageDto dto=result.get(i);
			System.out.printf(" %-5s %-10s%-15s\n",dto.getMon(),dto.getSname(),dto.getMcontent());
		}
		messageView();
	}
	



}//c
