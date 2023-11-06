package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.MessageDao;
import 이젠아카데미.model.dto.MessageDto;

public class MessageController {

	private static MessageController M = new MessageController();
	public static MessageController getInstance() {return M;}
	private MessageController() {}

//1. 메세지 보내기(고연진)-----------------------------------------------
	public boolean messageSend(MessageDto dto) {
		
	boolean result=
			MessageDao.getInstance().messageSend(dto);
	
		if(result) {return true;}
		else {return false;}
	}
	

//2. 메세지 보기(고연진)--------------------------------------
	public MessageDto messageView(int mno) {
		MessageDto result=
				MessageDao.getInstance().messageView(mno);
		return result;
		
	}
	
	
//3. 전체 메세지 보기---------------------------------------
	public ArrayList<MessageDto> messageAllView(int eno) {
		ArrayList<MessageDto> result=
				MessageDao.getInstance().messageAllView(eno);
		return result;
	}
	
	
//4. 메세지 수정----------------------------------------------
	public void messageUpdate() {
		
	}
	
//5. 메세지 삭제 ---------------------------------------------
	public void messageDelete() {
		
	}


	
}//c

