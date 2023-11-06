package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.AttendanceDao;
import 이젠아카데미.model.dto.StudentDto;

public class AttendanceController {
 
	private static AttendanceController attendanceController = new AttendanceController();
	public static AttendanceController getInstance() {return attendanceController;}
	private AttendanceController () {}
	
	public boolean 출석하기() {
		return AttendanceDao.getInstance().출석하기(BoardController.getInstance().getLoginSession());
	}
	
	
	public int 출석횟수() {
			return AttendanceDao.getInstance().출석횟수(BoardController.getInstance().getLoginSession());
		}
	
	public int 총수강일() {
		return AttendanceDao.getInstance().총수강일(BoardController.getInstance().getLoginSession());
	}
	
	public ArrayList<StudentDto> attendancePrint() {
		return AttendanceDao.getInstance().attendancePrint();
		
	}
}
