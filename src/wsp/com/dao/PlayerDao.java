package wsp.com.dao;

import java.util.LinkedList;

import wsp.com.entity.PlayerEntity;

/**
 * 选手操作
 * @author WSP
 */
public class PlayerDao {
	private CommonMethodDao<PlayerEntity> com = new CommonMethodDao<>();
	private PlayerEntity eMake = new PlayerEntity();
	
	public int newPlayer(PlayerEntity player) {
		return com.addData(player, "palyer");
	}
	
	public LinkedList<PlayerEntity> getPlayerMassager(String count) {
		LinkedList<PlayerEntity> linkedList = new LinkedList<>();
		return com.selectMassager(eMake, linkedList, "player", count, "count");
	}
	
	public int changeMassager(String count, String willChangeName, String myChange) {
		return com.changeOne(myChange, willChangeName, "player", "count", count);
	}
}
