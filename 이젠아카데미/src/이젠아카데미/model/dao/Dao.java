package 이젠아카데미.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	
	public Dao() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			this.conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezenacademy","root","1234");
			System.out.println("DB연결성공");
		} catch (Exception e) {System.out.println("연동실패: "+e);}
	}
		
	
}//class
