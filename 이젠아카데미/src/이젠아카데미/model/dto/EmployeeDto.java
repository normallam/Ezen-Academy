package 이젠아카데미.model.dto;

public class EmployeeDto {

	// 1. 필드
	private int eno;
	private String era;
	private String ename;
	private	int epay;
	
	
	// 2. 생성자
	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}


	public EmployeeDto(int eno, String era, String ename, int epay) {
		super();
		this.eno = eno;
		this.era = era;
		this.ename = ename;
		this.epay = epay;
	}


	public EmployeeDto(String era, String ename, int epay) {
		super();
		this.era = era;
		this.ename = ename;
		this.epay = epay;
	}

	// 3. 메소드
	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public String getEra() {
		return era;
	}


	public void setEra(String era) {
		this.era = era;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public int getEpay() {
		return epay;
	}


	public void setEpay(int epay) {
		this.epay = epay;
	}


	@Override
	public String toString() {
		return "EmployeeDto [eno=" + eno + ", era=" + era + ", ename=" + ename + ", epay=" + epay + "]";
	}
}

