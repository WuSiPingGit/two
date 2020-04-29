package wsp.com.entity;

public class ChangeTeamEntity {
	private int playerId;
	private String stand;
	private String readme;
	private String pictureWay;
	private boolean auction;
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
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public boolean isAuction() {
		return auction;
	}
	public void setAuction(boolean auction) {
		this.auction = auction;
	}
}
