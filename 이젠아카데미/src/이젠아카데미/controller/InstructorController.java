package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.InstructorDao;
import 이젠아카데미.model.dto.InstructorDto;

public class InstructorController {

	private static InstructorController instructor = new InstructorController();
	public static InstructorController getInstance() {return instructor;}
	private InstructorController() {}
	
	

// 1. 강사vs행정을 구분하는 함수(고연진)----------------------------	
	public boolean instructorMain(int jno) {
		// MAINPAGE에서 받아온 값이
		//아이디,비밀번호 일치하는 것(jno) 중에  era 직급이 "강사"이면 true;
		boolean result=InstructorDao.getInstance().instructorMain(jno);
		if(result) {return true;}
		else {return false;}
	
	}//f()
	

//2.강사면 수업을 듣는 학생 전체를 보여주는 view(고연진)---------------------------

	public ArrayList<InstructorDto> SManagement(int jno) {
			return InstructorDao.getInstance().SManagement(jno);
		}	
	
	
	
}//c
