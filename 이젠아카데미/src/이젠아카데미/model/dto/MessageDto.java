package 이젠아카데미.model.dto;
	
	public class MessageDto {
		//필드
		int mon;
		int eno;
		String sname;
		String mcontent;
		int sno;
		String ename;

//생성자----------------------------------------------------------------------		
	//빈생성자
		public MessageDto() {}
		
	//풀생성자
		public MessageDto(int eno, int sno, String mcontent) {
			super();
			this.eno = eno;
			this.sno = sno;
			this.mcontent = mcontent;
		}

		//메세지 전송
		public MessageDto(int eno, String mcontent, int sno) {
			super();
			this.eno = eno;
			this.mcontent = mcontent;
			this.sno = sno;
		}
		
		//보낸메세지함
		public MessageDto(int mon, String sname, String mcontent) {
			super();
			this.mon = mon;
			this.sname = sname;
			this.mcontent = mcontent;
		}
	
		//개별메세지출력

		public MessageDto(String sname, String mcontent) {
			super();
			this.sname = sname;
			this.mcontent = mcontent;
		}

		

		
		
//메소드-------------------------------------------------------------




		public String getEname() {
			return ename;
		}



		public void setEname(String ename) {
			this.ename = ename;
		}

		//메소드--------------------------------------------------------------
		@Override
		public String toString() {
			return "MessageDto [mon=" + mon + ", eno=" + eno + ", sno=" + sno + ", mcontent=" + mcontent + "]";
		}


		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public int getMon() {
			return mon;
		}

		public void setMon(int mon) {
			this.mon = mon;
		}

		public int getEno() {
			return eno;
		}

		public void setEno(int eno) {
			this.eno = eno;
		}

		public int getSno() {
			return sno;
		}

		public void setSno(int sno) {
			this.sno = sno;
		}

		public String getMcontent() {
			return mcontent;
		}

		public void setMcontent(String mcontent) {
			this.mcontent = mcontent;
		}
		
		
		
}//class
