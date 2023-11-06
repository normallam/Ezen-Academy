package 이젠아카데미.model.dto;

public class StudentDto {
   
   int sno;
   String sname;
   String saddress;
   String sphone;
   int lno;
   String lname;
   int ltotalday;

// 생성자
   //1. 기본생성자
   public StudentDto() {}
   //2. 풀생성자
   public StudentDto(int sno, String sname, String saddress, String sphone, int lno, String lname) {
      super();
      this.sno = sno;
      this.sname = sname;
      this.saddress = saddress;
      this.sphone = sphone;
      this.lno = lno;
      this.lname = lname;
   }
   //3. 상세정보 출력을 위해 , 출석률 계산
   public StudentDto(String sname, String saddress, String sphone, String lname, int ltotalday) {
      super();
      this.sname = sname;
      this.saddress = saddress;
      this.sphone = sphone;
      this.lname = lname;
      this.ltotalday = ltotalday;
   }
   //4. 학생 등록
   public StudentDto(String sname, String saddress, String sphone, int lno) {
      super();
      this.sname = sname;
      this.saddress = saddress;
      this.sphone = sphone;
      this.lno = lno;
   }
   //5. 학생업데이트
   public StudentDto(int sno, String sname, String saddress, String sphone, int lno) {
      super();
      this.sno = sno;
      this.sname = sname;
      this.saddress = saddress;
      this.sphone = sphone;
      this.lno = lno;
   }

//메소드--------------------------------------------------------------
   public int getSno() {
      return sno;
   }
   public void setSno(int sno) {
      this.sno = sno;
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
   public int getLtotalday() {
      return ltotalday;
   }
   public void setLtotalday(int ltotalday) {
      this.ltotalday = ltotalday;
   }
   @Override
   public String toString() {
      return "StudentDto [sno=" + sno + ", sname=" + sname + ", saddress=" + saddress + ", sphone=" + sphone
            + ", lno=" + lno + ", lname=" + lname + ", ltotalday=" + ltotalday + "]";
   }
   
   
   
   
}