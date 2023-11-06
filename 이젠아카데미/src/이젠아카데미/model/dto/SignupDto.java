package 이젠아카데미.model.dto;

public class SignupDto {

	private int eno; //등록된 강사의 코드
	private String jid;	//강사 아이디
	private String jpw;// 강사비밀번호
	
//생성자-----------------------------------
	public SignupDto() {	}

	//2. 풀생성자, 회원가입
	public SignupDto(int eno, String jid, String jpw) {
		super();
		this.eno = eno;
		this.jid = jid;
		this.jpw = jpw;
	}

	//3. 로그인 생성자
	
	public SignupDto(String jid, String jpw) {
		super();
		this.jid = jid;
		this.jpw = jpw;
	}
	
	
//메소드-------------------------------------	
	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getJpw() {
		return jpw;
	}

	public void setJpw(String jpw) {
		this.jpw = jpw;
	}

	@Override
	public String toString() {
		return "SignupDto [eno=" + eno + ", jid=" + jid + ", jpw=" + jpw + "]";
	}

	
	
	
}
