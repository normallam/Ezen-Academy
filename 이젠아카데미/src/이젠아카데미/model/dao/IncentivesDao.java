package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.model.dto.StudentDto;

public class IncentivesDao extends Dao{

	private static IncentivesDao incentivesDao = new IncentivesDao();
	public static IncentivesDao getInstance() { return incentivesDao; }
	private IncentivesDao() {}
	
	public ArrayList<StudentDto> 훈련장려금목록() {
		ArrayList<StudentDto> list = new ArrayList<>();
		try {
			String sql = "select * from student natural join attendance";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				 StudentDto dto = new StudentDto(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),
						   rs.getInt(5));
				   
				   list.add(dto);
			}

		}catch(Exception e) {
			System.out.println("Dao 실패 사유"+e);
			}
		return list;
		
		
	}
	
	public void 훈련장려금지급() {
		try {
			String sql = "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
