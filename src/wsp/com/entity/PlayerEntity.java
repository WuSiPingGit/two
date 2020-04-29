package wsp.com.entity;

import java.sql.Date;

public class PlayerEntity {
	private String count;
	private String ciper;
	private String name;
	private String team;
	private Date day; 
	private String pictureWay;
	private int yearOld;
	private boolean canLoad;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCiper() {
		return ciper;
	}
	public void setCiper(String ciper) {
		this.ciper = ciper;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getPictureWay() {
		return pictureWay;
	}
	public void setPictureWay(String pictureWay) {
		this.pictureWay = pictureWay;
	}
	public int getYearOld() {
		return yearOld;
	}
	public void setYearOld(int yearOld) {
		this.yearOld = yearOld;
	}
	public boolean getCanLoad() {
		return canLoad;
	}
	public void setCanLoad(boolean canLoad) {
		this.canLoad = canLoad;
	}
}
