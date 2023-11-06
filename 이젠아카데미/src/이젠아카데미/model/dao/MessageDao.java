package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.model.dto.MessageDto;

public class MessageDao extends Dao{

	private static MessageDao M = new MessageDao();
	public static MessageDao getInstance() {return M;}
	private MessageDao() {}
	
//1. 메세지 보내기--------------------------------------------------------------
	public boolean messageSend(MessageDto dto) {
		try {
			String sql="insert into Message (eno,mcontent,sno) values (?,?,?);";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, dto.getEno());
			ps.setString(2, dto.getMcontent());
			ps.setInt(3, dto.getSno());
			int row= ps.executeUpdate();
			if(row==1) {return true;}
		} catch (Exception e) {System.out.println("Dao오류:"+e);}
		return false;
	}
	

//2. 메세지 보기----------------------------------------------------
	public MessageDto messageView(int mno) {
		try {
			String sql = "select sname,mcontent from student natural join message where mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs= ps.executeQuery();
			if(rs.next()) {
				
			MessageDto dto = new MessageDto(rs.getString(1), rs.getString(2));
			return dto;
			}
		}catch (Exception e) {System.out.println("dao이유: "+e);}
		return null;
	}
	
	
//3. 전체 메세지 보기 -------------------------------------------------
	public ArrayList<MessageDto> messageAllView(int eno) {
		ArrayList<MessageDto>list = new ArrayList<>();
		try {
			String sql="select mno,eno,sname,mcontent,mday from student natural join message where eno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, eno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				MessageDto dto = new MessageDto(rs.getInt(1), rs.getString(3), rs.getString(4));
				list.add(dto);
				
			}//w
			return list;
		}catch (Exception e) {System.out.println("dao오류:"+e);}
		return null;
	}
	
	
//4. 메세지 수정
	public void messageUpdate() {
		
	}
	
//5. 메세지 삭제
	public void messageDelete() {
		
	}


}//c
