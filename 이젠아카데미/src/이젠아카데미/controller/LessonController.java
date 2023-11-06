package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.LessonDao;
import 이젠아카데미.model.dto.LessonDto;

public class LessonController {
	// 0.싱글톤
	private static LessonController LessonController = new LessonController();
	public static LessonController getInstance() { return LessonController; }
	private LessonController() {}



//1. 수업등록---------------------------------------------------------------------------	
	public boolean lessonWriteView(String lname,String ltname,String ltdate,String lopenday) {
		LessonDto lessonDto = new LessonDto(0,lname, ltname, ltdate, lopenday);
		boolean result = LessonDao.getInstance().lessonWriteView(lessonDto);
		if(result) {return true;}
		else{return false;}

	}
	
//2. 수업 조회-------------------------------------------------------------------
	public ArrayList<LessonDto> lessonprintView() {
		
		return LessonDao.getInstance().lessonprintView();

	}
	
//3. 수업수정--------------------------------------------------------------------------
	
	public boolean lessonupdateView(int lno,String lname,String ltname,String ltdate,String lopenday) {
		
		LessonDto lessonDto = new LessonDto(lno, lname, ltname, ltdate, lopenday);
		boolean result = LessonDao.getInstance().lessonupdateView(lessonDto);
		
		return result;
	}
	
	
//4. 수업삭제--------------------------------------------------------------------------
	
	public boolean lessondeleteView(int lno) {
		
				boolean result = LessonDao.getInstance().lessondeleteView(lno);
				return result;
		
	}
	
	


	
	
	
}//class
