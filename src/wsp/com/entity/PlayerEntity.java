package wsp.com.entity;

import java.sql.Timestamp;

public class PlayerEntity {
	private String count;
	private String ciper;
	private String name;
	private String team;
	private Timestamp day; 
	private String picture_way;
	private int old;
	private boolean can_load;
	private boolean succeed;
	private String clickmail;
	private String readme;
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
	public Timestamp getDay() {
		return day;
	}
	public void setDay(Timestamp day) {
		this.day = day;
	}
	public String getPicture_way() {
		return picture_way;
	}
	public void setPicture_way(String pictureWay) {
		this.picture_way = pictureWay;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int yearOld) {
		this.old = yearOld;
	}
	public boolean getCan_load() {
		return can_load;
	}
	public void setCan_load(boolean canLoad) {
		this.can_load = canLoad;
	}
	public String getClickmail() {
		return clickmail;
	}
	public void setClickmail(String clickmail) {
		this.clickmail = clickmail;
	}
	public boolean getSucceed() {
		return succeed;
	}
	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}
	public String getReadme() {
		return readme;
	}
	public void setReadme(String readme) {
		this.readme = readme;
	}
}
