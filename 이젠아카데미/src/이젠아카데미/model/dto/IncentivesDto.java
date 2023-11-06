package 이젠아카데미.model.dto;

import java.sql.Date;

public class IncentivesDto {

	private int sno;
	private int tno;
	private int tepisode;
	private String tday;
    
	
	public IncentivesDto() {
		// TODO Auto-generated constructor stub
	}


	public IncentivesDto(int sno, int tno, int tepisode, String tday) {
		super();
		this.sno = sno;
		this.tno = tno;
		this.tepisode = tepisode;
		this.tday = tday;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public int getTno() {
		return tno;
	}


	public void setTno(int tno) {
		this.tno = tno;
	}


	public int getTepisode() {
		return tepisode;
	}


	public void setTepisode(int tepisode) {
		this.tepisode = tepisode;
	}


	public String getTday() {
		return tday;
	}


	public void setTday(String tday) {
		this.tday = tday;
	}
	
	
}
