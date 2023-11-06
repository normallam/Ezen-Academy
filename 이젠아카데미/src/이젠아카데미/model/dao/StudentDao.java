package 이젠아카데미.model.dao;

import java.util.ArrayList;


import 이젠아카데미.model.dto.StudentDto;

public class StudentDao extends Dao {
	
	private static StudentDao d = new StudentDao();
	public static StudentDao getInstance() {return d;}
	private StudentDao() {}
	
//1. 학생등록(고연진)----------------------------------------
	public boolean studentJoin(StudentDto dto) {
		String sql = "insert into student(sno,sname,saddress,sphone,lno)values(?,?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,dto.getSno());
			ps.setString(2,dto.getSname());
			ps.setString(3,dto.getSaddress());
			ps.setString(4,dto.getSphone());
			ps.setInt(5,dto.getLno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("Dao 학생등록 실패이유: "+e) ;}
		return false;
	}//studentJoin()

	
	
//2-1 전체 학생 정보조회(이진형)------------------------------------------------------------
	public ArrayList<StudentDto> studentAllSelect() {
		ArrayList<StudentDto> list = new ArrayList<>();
		try {
			String sql = "select * from student"; 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				 StudentDto dto = new StudentDto(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),
						   rs.getInt(5));
				   
				   list.add(dto);
			}

		}catch(Exception e) {
			System.out.println("Dao 학생관리 실패 사유"+e);
			}
		return list;
	}
	
//2-2. 학생별 상세 조회(고연진)------------------------------
	public StudentDto studentInfo(int sno) {
		try {
			String sql= "select sno,sname,saddress,sphone,lno,lname from student natural join lesson where sno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sno);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				StudentDto dto = new StudentDto(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5),rs.getString(6) 
						);
				return dto;
			}//if
		}//try 
		catch (Exception e) {System.out.println("dao오류: "+e);}
		return null;
		}//catch	
	

//3. 학생정보수정(고연진)------------------------------------------------------------------	
	public boolean studentUpdate(StudentDto dto) {
		try {
			// v
			String sql = "update student set sname = ? , saddress = ? , sphone = ? , lno = ?  where sno = ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getSname());
			ps.setString(2, dto.getSaddress());
			ps.setString(3, dto.getSphone());
			ps.setInt(4, dto.getLno());
			ps.setInt(5, dto.getSno());
			ps.executeUpdate(); 
			return true;
		}catch (Exception e) {System.out.println("studentUpdate()DAO 오류: "+e);
		}
		return false;
		}//f()
	
	
//4. 학생삭제(이진형)---------------------------------------------------------------------
	public boolean studentDelete(int sno) {
		try {			
			String sql = "delete from student where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,sno);

			int row = ps.executeUpdate(); 
			if(row == 1) return true;
		   }catch (Exception e) {
			   System.out.println(e);
		   }
		return false;
		}


	
	

}//class



