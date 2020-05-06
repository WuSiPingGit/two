package wsp.com.control;

import java.util.LinkedList;

import wsp.com.entity.ChangeTeamEntity;
import wsp.com.entity.PlayerEntity;
import wsp.com.service.PlayerService;

/**
 * 
 * @author WSP
 */
public class PlayerControl {
	private PlayerService playerService = new PlayerService();
	public boolean newPlayer(PlayerEntity player) {
		return playerService.newPlayer(player);
	}
	
	
	public boolean hasIt(String count) {
		return playerService.hasThis(count);
	}
	
	public boolean relife(String count, String check) {
		return playerService.relifeUser(count, check);
	}
//	public LinkedList<PlayerEntity> getPlayerEntity(String count) {
//		playerService.
//	}
//	
//	public LinkedList<ChangeTeamEntity> changeTeam(String count) {
//		
//	}
}
