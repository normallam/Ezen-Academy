package 이젠아카데미.model.dto;

public class BoardDto {

    int bno; 
    int sno ;
    String btitle; 
    String bcontent; 
    String bday;
    int bview;
 
    public BoardDto() {}
   public BoardDto(int bno, int sno, String btitle, String bcontent, String bday ,int bview) {
      super();
      this.bno = bno;
      this.sno = sno;
      this.btitle = btitle;
      this.bcontent = bcontent;
      this.bday = bday;
      this.bview = bview;
   }


   public BoardDto(int bno, String bday, int bview) {
      super();
      this.bno = bno;
      this.bday = bday;
      this.bview = bview;
   }
   public BoardDto(int sno, String btitle, String bcontent) {
      super();
      this.sno = sno;
      this.btitle = btitle;
      this.bcontent = bcontent;
   }
   
   public BoardDto(String btitle, String bcontent) {
      super();
      this.btitle = btitle;
      this.bcontent = bcontent;
   }
   
   

   public BoardDto(int bno, int sno) {
      super();
      this.bno = bno;
      this.sno = sno;
   }

   
   public BoardDto( String btitle, String bcontent,int bno) {
      super();
      this.bno = bno;
      this.btitle = btitle;
      this.bcontent = bcontent;
   } 
   
   

public int getBno() {
      return bno;
   }
   public void setBno(int bno) {
      this.bno = bno;
   }
   public int getSno() {
      return sno;
   }
   
   public void setSno(int sno) {
      this.sno = sno;
   }
   
   public String getBtitle() {
      return btitle;
   }
   public void setBtitle(String btitle) {
      this.btitle = btitle;
   }
   public String getBcontent() {
      return bcontent;
   }
   public void setBcontent(String bcontent) {
      this.bcontent = bcontent;
   }
   public String getBday() {
      return bday;
   }
   public void setBday(String bday) {
      this.bday = bday;
   }
   public int getBview() {
      return bview;
   }
   public void setBview(int bview) {
      this.bview = bview;
   }
   @Override
   public String toString() {
      return "BoardDto [bno=" + bno + ", sno=" + sno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bday="
            + bday + "]";
   }
   
}