package 이젠아카데미.model.dao;

import 이젠아카데미.model.dto.SignupDto;

public class SignupDao extends Dao {

	private static SignupDao sign = new SignupDao();
	public static SignupDao getInstance() {return sign;}
	private SignupDao() {}
	
	
	
// 1.강사회원가입(고연진)-----------------------------------------------
	public boolean signup(SignupDto dto) {
		try {
			String sql="insert into signup(eno,jid,jpw) values (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, dto.getEno());
			ps.setString(2, dto.getJid());
			ps.setString(3, dto.getJpw());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("dao실패이유: "+e);}
		return false;
	}//f()	
	
//2. 로그인(고연진)---------------------------------------------
	public int login(SignupDto dto) {
		try {
			String sql = "select * from signup where jid= ?  and jpw= ? ";
			ps= conn.prepareStatement(sql);
			ps.setString(1, dto.getJid());
			ps.setString(2, dto.getJpw());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch (Exception e) {System.out.println("doa쪽 오류: "+e);}
		
		return 0;
			
		}//f()	
	
	
	
	
	
}//c
