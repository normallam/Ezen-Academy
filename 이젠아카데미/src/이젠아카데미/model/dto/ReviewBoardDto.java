package 이젠아카데미.model.dto;

public class ReviewBoardDto {

	// 필드
	int rno;
	int sno;
	String rtitle;
	String rcontent;
	int lno;
	int rgrade;

	//생성자
	public ReviewBoardDto() {
	// TODO Auto-generated constructor stub
	}

	public ReviewBoardDto(int rno, int sno, String rtitle, String rcontent, int lno, int rgrade) {
		super();
		this.rno = rno;
		this.sno = sno;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.lno = lno;
		this.rgrade = rgrade;
	}
	
	
// 글 전체조회 
	public ReviewBoardDto(int rno, int sno, String rtitle, int rgrade) {
		super();
		this.rno = rno;
		this.sno = sno;
		this.rtitle = rtitle;
		this.rgrade = rgrade;
	}

	public ReviewBoardDto(String rtitle, String rcontent, int rgrade) {
		super();
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rgrade = rgrade;
	}

// 글 개별조회	
	public ReviewBoardDto(int rno, int sno, String rtitle, String rcontent, int rgrade) {
		super();
		this.rno = rno;
		this.sno = sno;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rgrade = rgrade;
	}
	
	
	//메소드
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getRgrade() {
		return rgrade;
	}

	public void setRgrade(int rgrade) {
		this.rgrade = rgrade;
	}

	@Override
	public String toString() {
		return "ReviewBoardDto [rno=" + rno + ", sno=" + sno + ", rtitle=" + rtitle + ", rcontent=" + rcontent
				+ ", lno=" + lno + ", rgrade=" + rgrade + "]";
	}

	



} //class e
	