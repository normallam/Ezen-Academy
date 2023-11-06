package 이젠아카데미.model.dto;

public class LessonDto {
	
	// 1. 필드
	private int lno;
	private String lname;
	private String ltname;
	private	String ltotalday;
	private String lopenday;
	
	// 2. 생성자
	public LessonDto() {}

	public LessonDto(int lno, String lname, String ltname, String ltotalday, String lopenday) {
		super();
		this.lno = lno;
		this.lname = lname;
		this.ltname = ltname;
		this.ltotalday = ltotalday;
		this.lopenday = lopenday;
	}

	
	// 3. 매소드
	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLtname() {
		return ltname;
	}

	public void setLtname(String ltname) {
		this.ltname = ltname;
	}

	public String getLtotalday() {
		return ltotalday;
	}

	public void setLtotalday(String ltotalday) {
		this.ltotalday = ltotalday;
	}

	public String getLopenday() {
		return lopenday;
	}

	public void setLopenday(String lopenday) {
		this.lopenday = lopenday;
	}

	@Override
	public String toString() {
		return "LessonDto [lname=" + lname + ", ltname=" + ltname + ", ltotalday=" + ltotalday + ", lopenday="
				+ lopenday + "]";
	}
	

	
	
	
	

	
	
	
	
}
