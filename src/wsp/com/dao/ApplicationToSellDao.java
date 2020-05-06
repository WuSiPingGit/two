package wsp.com.dao;

import java.util.LinkedList;
import wsp.com.entity.ChangeTeamEntity;

public class ApplicationToSellDao {
	private CommonMethodDao<ChangeTeamEntity> com = new CommonMethodDao<>();
	private ChangeTeamEntity changeTeamEntity = new ChangeTeamEntity();
	private LinkedList<ChangeTeamEntity> linkedList = new LinkedList<>();
	
	public int changeMyApply(String count, String myChange, String willChangeName) {
		return com.changeOne(myChange, willChangeName, "apply", "count", count);
	}
	
	public LinkedList<ChangeTeamEntity> getChangeTeam(String count) {
			return com.selectMassager(changeTeamEntity, linkedList, "apply", count, "count");
	}
	
	public int addApply(ChangeTeamEntity change) {
		return com.addData(change, "apply");
	}
	
	public int removeApply(String count) {
		return com.removeOne("apply", "count", count);
	}
}
