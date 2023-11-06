package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.BoardDao;
import 이젠아카데미.model.dao.StudentDao;
import 이젠아카데미.model.dto.BoardDto;
import 이젠아카데미.model.dto.StudentDto;

public class StudentController {
	
	private static StudentController c = new StudentController();
	public static StudentController getInstance() {return c;}
	private StudentController() {}
	
	

//1.학생등록(고연진)-----------------------------------------------
	public boolean studentJoin(String sname, String saddress, String sphone,int lno) {
		StudentDto dto = new StudentDto(sname, saddress,sphone,lno);
		
		boolean result=
				StudentDao.getInstance().studentJoin(dto);
		return true;
		
	}//studentJoin() 
	

	
	
//2-1 전체 학생 정보조회(이진형)-----------------------------------------------------	
	public ArrayList<StudentDto >studentAllSelect() {
		
		
		return StudentDao.getInstance().studentAllSelect();
	}

//2-2. 학생별 상세 조회(고연진)------------------------------
	public  StudentDto studentInfo(int sno) {
		return StudentDao.getInstance().studentInfo(sno);
		
	}
	
	
//3. 학생수정업데이트(고연진)---------------------------------------------------	
public boolean studentUpdate(int sno, String sname,String saddress, String sphone, int lno ) {
		StudentDto dto = new StudentDto(sno,sname, saddress, sphone, lno);
		boolean result= StudentDao.getInstance().studentUpdate(dto);
		
		return result;
		
}
	

	
//4. 학생삭제(이진형)-----------------------------------------------------	
	public boolean studentDelete(int sno) {
		
				  boolean result =StudentDao.getInstance().studentDelete(sno);
				  return result; 
	}
	
	
	
}//class
