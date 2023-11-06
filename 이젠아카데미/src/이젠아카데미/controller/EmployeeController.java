package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.EmployeeDao;
import 이젠아카데미.model.dao.LessonDao;
import 이젠아카데미.model.dto.EmployeeDto;
import 이젠아카데미.model.dto.LessonDto;
import 이젠아카데미.view.EmployeeView;

public class EmployeeController {

	// 0. 싱글톤
	private static EmployeeController EmployeeController = new EmployeeController();
	public static EmployeeController getInstance() { return EmployeeController; }
	private EmployeeController() {}


	
//1. 직원등록-------------------------------------------------------------------
	
	public boolean employeewriteView(String era, String ename, int epay) {
		EmployeeDto employeeDto = new EmployeeDto(era, ename, epay);
		boolean result = EmployeeDao.getInstance().employeewriteView(employeeDto);
		if(result) {return true;}
		else {return false;}	
	}
	
//2. 직원조회-------------------------------------------------------------------
	public ArrayList<EmployeeDto> employeeprintView() {
			
		return EmployeeDao.getInstance().employeeprintView();

	}	
	
//3. 직원수정--------------------------------------------------------------------------

	public boolean employeeupdateView(int eno, String era, String ename, int epay) {
		EmployeeDto employeeDto = new EmployeeDto(eno, era, ename, epay);
		boolean result = EmployeeDao.getInstance().employeeupdateView(employeeDto);

		return result;
		
	}
	
//4. 직원삭제--------------------------------------------------------------------------
	
	public boolean employeedeleteView(int eno) {
			
				boolean result = EmployeeDao.getInstance().employeedeleteView(eno);
				return result;
		
	}	
	
	
}//class e
