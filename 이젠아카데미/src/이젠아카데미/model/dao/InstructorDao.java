package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.model.dto.InstructorDto;

public class InstructorDao extends Dao {

	private static InstructorDao instructor = new InstructorDao();
	public static InstructorDao getInstance() {return instructor;}
	private InstructorDao() {}
	
	
// 1. 강사vs행정을 구분하는 함수(고연진)----------------------------	
		public boolean instructorMain(int jno){
			try {
				String sql = "select * from employee natural join signup  where era like'강사%' and jno = ?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, jno);
				rs= ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			}catch (Exception e) {System.out.println("dao오류: "+e);}
			 	return false;
		
		}//f()	
	

//2.강사면 수업을 듣는 학생 전체를 보여주는 view(고연진)---------------------------

	public ArrayList<InstructorDto> SManagement(int jno) {
		ArrayList<InstructorDto>list=new ArrayList<>();
			try {
				String sql="select sno, lno, sname, saddress, sphone from student natural join lesson where lno =?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, jno);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					InstructorDto dto = new InstructorDto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
					list.add(dto);
				}
			}catch (Exception e) {System.out.println("다오오류: "+e);}
			return list;
		};
		
		
		
	
}//c
