package 이젠아카데미.model.dto;

public class InstructorDto {
	//필드
	int sno;
	int lno;
	String sname;
	String saddress;
	String sphone;
	

	//빈생성자
	public InstructorDto() {}

	//풀생성자
	public InstructorDto(int sno, int lno, String sname, String saddress, String sphone) {
		super();
		this.sno = sno;
		this.lno = lno;
		this.sname = sname;
		this.saddress = saddress;
		this.sphone = sphone;
	}

	
// 메소드----------------------------------------------------------------------------------	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	@Override
	public String toString() {
		return "InstructorDto [sno=" + sno + ", lno=" + lno + ", sname=" + sname + ", saddress=" + saddress
				+ ", sphone=" + sphone + "]";
	}

	
	
	
}//c
