package wsp.com.entity;

public class ChangeTeamEntity {
	private String count;
	private String stand;
	private String readme;
	private String pictureWay;
	private boolean auction;
	private boolean hasPass;
	public String getStand() {
		return stand;
	}
	public void setStand(String stand) {
		this.stand = stand;
	}
	public String getReadme() {
		return readme;
	}
	public void setReadme(String readme) {
		this.readme = readme;
	}
	public String getPictureWay() {
		return pictureWay;
	}
	public void setPictureWay(String pictureWay) {
		this.pictureWay = pictureWay;
	}
	public String getPlayerId() {
		return count;
	}
	public void setPlayerId(String count) {
		this.count = count;
	}
	public boolean getAuction() {
		return auction;
	}
	public void setAuction(boolean auction) {
		this.auction = auction;
	}
	public boolean getHasPass() {
		return hasPass;
	}
	public void setHasPass(boolean hasPass) {
		this.hasPass = hasPass;
	}
}
