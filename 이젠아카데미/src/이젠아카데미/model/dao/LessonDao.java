package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.model.dto.LessonDto;

public class LessonDao extends Dao{
//0.싱글톤
	private static LessonDao LessonDao = new LessonDao();
	public static LessonDao getInstance() { return LessonDao; }
	private LessonDao() {}
				
//1. 수업등록------------------------------------------------------------------			
	public boolean lessonWriteView(LessonDto lessonDto) {
	
		try {
			String sql = "insert into lesson(lname,ltname,ltotalday,lopenday) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, lessonDto.getLname());
			ps.setString(2, lessonDto.getLtname());
			ps.setString(3, lessonDto.getLtotalday());
			ps.setString(4, lessonDto.getLopenday());
			int row = ps.executeUpdate();
			if(row ==1) return true; 
		}catch (Exception e) {System.out.println("dao오류: "+e);}
		return false;
	}


	
	
//2-1. 수업전체조회------------------------------------------------------------------
	
	public ArrayList<LessonDto> lessonprintView() {
		ArrayList<LessonDto> list = new ArrayList<>();
		
		try{
			String sql = "select * from lesson";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				LessonDto dto = new LessonDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
					list.add(dto);
			}// while e
			
		}catch(Exception e) {
			System.out.println("Dao 수업관리 실패 사유"+e);
		}
		return list;
		
	}
	
//2-2. 수업개별조회------------------------------------------------------------------
	
		public LessonDto lessondetailView(int lno) {
				
				
			try{
				String sql = "select * from lesson where lno = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, lno);
				rs = ps.executeQuery();
					
					
				if(rs.next()) {
					LessonDto dto = new LessonDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
						
					return dto;
				}// while e
					
			}catch(Exception e) {
				System.out.println("Dao 수업관리 실패 사유"+e);
			}
			return null;
				
		}	
	
	
//3. 수업수정------------------------------------------------------------------
	
	public boolean lessonupdateView(LessonDto dto ) {
		
		LessonDto oldDto = lessondetailView( dto.getLno() );
		
		try {
			String sql = "update lesson set lname = ? , ltname = ? , ltotalday = ? , lopenday = ? where lno = ?";
			ps=conn.prepareStatement(sql);
			ps.getConnection().prepareStatement(sql);
			ps.setString(1, dto.getLname().equals("") ? oldDto.getLname() : dto.getLname());
			ps.setString(2, dto.getLtname().equals("") ? oldDto.getLtname() : dto.getLtname() );
			ps.setString(3, dto.getLtotalday().equals("") ? oldDto.getLtotalday() : dto.getLtotalday());
			ps.setString(4, dto.getLopenday().equals("") ? oldDto.getLopenday() : dto.getLopenday());
			ps.setInt(5, dto.getLno());	
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("lessonupdateView()DAO오류: "+e);
		}
		return false;
		}
	



//4. 수업삭제------------------------------------------------------------------

	public boolean lessondeleteView(int lno) {
	
		try {
			
			String sql = "delete from lesson where lno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lno);
			
			int row = ps.executeUpdate();
			if(row == 1) return true;
		}catch(Exception e) {System.out.println("lessondeleteView()DAO오류: "+e);	
		}
		return false;
		}




}










