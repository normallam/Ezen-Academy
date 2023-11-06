package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.model.dto.StudentDto;

public class AttendanceDao extends Dao{
	private static AttendanceDao attendanceDao = new AttendanceDao();
	public static AttendanceDao getInstance() {return attendanceDao;}
	private AttendanceDao () {}
	
	public boolean 출석하기(int loginSession) {
		if( 오늘출석여부확인(  loginSession ) ) return false;
		// 만약에 오늘날짜 이면서 회원번호 가 일치하면 이미 출석 완료된 상태 
		String sql = "insert into attendance (sno) values(?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginSession);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean 오늘출석여부확인( int loginSession ) {
		try {
			String sql = "select * from attendance where sno = ? and date_format(aday , '%Y-%m-%d') = curdate()";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , loginSession);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return true;
			}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public int 출석횟수(int loginSession) {
		try {
			String sql = "select count(*) from attendance where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginSession);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public int 총수강일(int loginSession) {
		try {
			String sql = "select ltotalday from student s natural join lesson l where s.sno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loginSession);
			rs = ps.executeQuery();
			if( rs.next() ) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	public ArrayList<StudentDto> attendancePrint() {
		
		 ArrayList<StudentDto> list = new ArrayList<>();
		 try {
			 String sql = "select * from student natural join attendance where DATE(aday) = CURDATE()";
			 ps = conn.prepareStatement(sql);
			
			 rs=ps.executeQuery();
			 
			 while(rs.next()) {
				 StudentDto dto = new StudentDto(
						 rs.getInt(1),rs.getString(2),rs.getString(3),
						 rs.getString(4),rs.getInt(5));
						 list.add(dto);
			 }
			 
		 }catch (Exception e) {System.out.println(e);}
		 return list;
	}

}





















