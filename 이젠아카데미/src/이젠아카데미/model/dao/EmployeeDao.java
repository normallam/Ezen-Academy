package 이젠아카데미.model.dao;

import java.util.ArrayList;

import 이젠아카데미.controller.EmployeeController;
import 이젠아카데미.model.dto.EmployeeDto;
import 이젠아카데미.model.dto.LessonDto;

public class EmployeeDao extends Dao{

// 0. 싱글톤
	private static EmployeeDao EmployeeDao = new EmployeeDao();
	public static EmployeeDao getInstance() { return EmployeeDao; }
	private EmployeeDao() {}
	
//1. 직원등록------------------------------------------------------------------			

	public boolean employeewriteView(EmployeeDto employeeDto) {
		
		try {
			String sql = "insert into employee(era,ename,epay) values (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, employeeDto.getEra());
			ps.setString(2, employeeDto.getEname());
			ps.setInt(3, employeeDto.getEpay());
			int row = ps.executeUpdate();
			if(row==1) return true;
		}catch(Exception e) {System.out.println("dao오류: "+e);}
		return false;
		}

//2-1. 직원전체조회------------------------------------------------------------------
	
		public ArrayList<EmployeeDto> employeeprintView() {
			ArrayList<EmployeeDto> list = new ArrayList<>();
			
			try {
				String sql = "select * from employee";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					EmployeeDto dto = new EmployeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					
						list.add(dto);
				}// while e
			}catch(Exception e) {
				System.out.println("Dao 직원관리 실패 사유"+e);
				
			}
			return list;
			
			
		}

//2-2. 직원개별조회------------------------------------------------------------------
		
		
		public EmployeeDto employeedetailView(int eno) {
			
			
			try {
				String sql = "select * from employee where eno = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, eno);
				rs = ps.executeQuery();
				
				
				if(rs.next()) {
					EmployeeDto dto = new EmployeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					
					return dto;
				}
			
			}catch(Exception e) {System.out.println("Dao 수업관리 실패 사유" +e);}
			
			return null;
			}
		
		
//3. 직원수정------------------------------------------------------------------		
		
		public boolean employeeupdateView(EmployeeDto dto) {
			
			
			EmployeeDto oldDto = employeedetailView(dto.getEno());
		
			try {
				String sql = "update employee set era = ? , ename = ? , epay = ? where eno =?"; 
				ps=conn.prepareStatement(sql);
				ps.getConnection().prepareStatement(sql);
				ps.setInt(4, dto.getEno());
				ps.setString(1, dto.getEra().equals("") ? oldDto.getEra() : dto.getEra());
				ps.setString(2, dto.getEname().equals("") ? oldDto.getEname() : dto.getEname());
				ps.setInt(3, dto.getEpay());
				ps.executeUpdate();
				return true;
				
			}catch(Exception e) {System.out.println("employeeupdateView()Dao오류: "+e);}
			
			return false;
			}
		
//4. 직원삭제------------------------------------------------------------------

		public boolean employeedeleteView(int eno) {
	
			try {
			
				String sql = "delete from employee where eno = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, eno);
				
				int row = ps.executeUpdate();
				if(row == 1) return true;
			}catch(Exception e) {System.out.println("employeedeleteView()DAO오류: "+e);	
			}
			return false;
			}
		
		
	
		
	
}// class e
