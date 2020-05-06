package wsp.com.bean;
import wsp.com.entity.ChangeTeamEntity;
/**
 * 设置新的(或修改)转会信息
 * @author WSP
 */
public class SetChangeTeamBean {
	public static ChangeTeamEntity setChangeeTeamBean(String playerCount, String stand, String readme, String pictureWay, boolean auction) {
		ChangeTeamEntity change = new ChangeTeamEntity();
		change.setAuction(auction);
		change.setPictureWay(pictureWay);
		change.setReadme(readme);
		change.setStand(stand);
		change.setPlayerId(playerCount);
		change.setHasPass(false);
		return change;
	}
}
