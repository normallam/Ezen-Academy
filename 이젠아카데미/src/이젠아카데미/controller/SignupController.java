package 이젠아카데미.controller;

import java.util.Scanner;

import 이젠아카데미.model.dao.SignupDao;
import 이젠아카데미.model.dto.SignupDto;

public class SignupController {

	private static SignupController sign = new SignupController();
	public static SignupController getInstance() {return sign;}
	private SignupController() {}
	
	Scanner sc= new Scanner(System.in);
	
// 1.강사회원가입-----------------------------------------------
	public boolean signup(int eno, String jid, String jpw) {
		SignupDto dto = new SignupDto(eno, jid, jpw);
		
		boolean result =SignupDao.getInstance().signup(dto);
		
		if(result) {return true;}
		else {return false;}
		
	}//f()	
	
	
//2. 로그인---------------------------------------------
	
	
	private int loginSession=0;
	public int getLoginSession() {return loginSession;}
	
	public boolean login(String jid, String jpw) {
		SignupDto dto=new SignupDto(jid, jpw);
		
		int result= SignupDao.getInstance().login(dto);
		if(result>=1) {this.loginSession=result; return true;}
		else {return false;}
		
	}//f()
	
//3. 로그아웃-----------------------------------------
	public void logOut() {this.loginSession=0;}
	
	
	
	
	
	
}//c
