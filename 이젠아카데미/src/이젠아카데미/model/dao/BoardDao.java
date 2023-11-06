package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.model.dto.BoardDto;





public class BoardDao extends Dao{
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}
	public ArrayList<BoardDto> boardPrint() {
		 ArrayList<BoardDto> list = new ArrayList<>();
		 try {
			 String sql = "select * from board order by bday desc";
			 ps = conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 
			 while(rs.next()) {
				 BoardDto dto = new BoardDto(
						 rs.getInt(1),rs.getInt(2),rs.getString(3),
						 rs.getString(4),rs.getString(5),rs.getInt(6));
						 list.add(dto);
			 }
			 
		 }catch (Exception e) {System.out.println(e);}
		 return list;
	}
	public BoardDto boardView(int bno) {
		try {
			String sql ="select b.*,s.sno from board b natural join student s where b.bno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			if(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1),rs.getInt(2),rs.getString(3),
						 rs.getString(4),rs.getString(5),rs.getInt(6));
				boardViewCount(dto.getBno());
				return dto;
			}

		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	  // 11-2. 조회수 증가 함수
    public boolean boardViewCount(int bno) {
       try {
	          String sql = "update board set bview =bview + 1 where bno = ?";
	          ps = conn.prepareStatement(sql);
	          ps.setInt(1, bno);
	          ps.executeUpdate();
       		}catch (Exception e) {System.out.println(e);}
       
       
       return false;
       
    }
	// 게시글 번호 받아서 삭제
	public boolean boardDelete(int bno ) {
		try {
			String sql = "delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if(row == 1) return true;
		} catch (Exception e) {System.out.println("오류이유: "+e);}
		
		return false;
	}
	
	public boolean MyboardDelete(int bno) {
		try {
			String sql="delete from board where bno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int row = ps.executeUpdate();
			if(row==1) {return true;}
			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	

	
	public int information(String name, String phone) {
		try {
			String sql = "select * from student where sname=? and sphone=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {System.out.println(e);}
		return 0;
	}
	public boolean boardWrite(BoardDto boardDto) {
	      try {
	         String sql = "insert into board(btitle,bcontent,sno) values(?,?,?)";
	         
	         ps = conn.prepareStatement(sql);
	         ps.setString(1,boardDto.getBtitle());
	         ps.setString(2,boardDto.getBcontent());
	         ps.setInt(3, boardDto.getSno());

	         int row = ps.executeUpdate();
	         if(row==1) return true;
	         
	         
	      }catch (Exception e) {System.out.println(e);}
	      return false;
	   }
	//  내글보기 
	public ArrayList<BoardDto> myWriting(int sno) {
	    ArrayList<BoardDto> list = new ArrayList<>();
	    try {
	        String sql = "select * from board where sno =?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, sno);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            BoardDto dto = new BoardDto(
	                rs.getInt(1), rs.getInt(2), rs.getString(3),
	                rs.getString(4), rs.getString(5), rs.getInt(6));
	            list.add(dto);
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return list;
	}

	public boolean boardUpdate( BoardDto boardDto ) {
		try {
			String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
			ps = conn.prepareStatement(sql); 	
			ps.setString( 1 , boardDto.getBtitle());	 	
			ps.setString( 2 , boardDto.getBcontent());
			ps.setInt( 3 , boardDto.getBno()); 
			
			int row = ps.executeUpdate(); 
			if( row == 1 ) return true;	
		}catch (Exception e) {System.out.println(e);}
		return false;    
	} 
}
