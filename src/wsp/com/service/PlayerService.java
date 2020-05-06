package wsp.com.service;

import java.util.LinkedList;

import wsp.com.dao.PlayerDao;
import wsp.com.entity.PlayerEntity;

/**
 * 选手操作
 * @author WSP
 */
public class PlayerService {
	PlayerDao playerDao = new PlayerDao();
	LinkedList<PlayerEntity> pl = null;
	public boolean newPlayer(PlayerEntity player) {
		if (playerDao.newPlayer(player)>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasThis(String count) {
		LinkedList<PlayerEntity> pl = playerDao.getPlayerMassager(count);
		if (pl!=null&&!pl.getFirst().getSucceed()) {
			pl = null;
			return true;
		}
		pl = null;
		return false;
	}
	
	public boolean relifeUser(String count, String check) {
		pl = playerDao.getPlayerMassager(count);
		if (pl!=null&&(pl.getFirst().getSucceed()||pl.getFirst().getClickmail().equals(check))) {
			return true;
		} else {
			return false;
		}
	}
}
