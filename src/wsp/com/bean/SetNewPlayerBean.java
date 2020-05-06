package wsp.com.bean;

import java.sql.Timestamp;

import wsp.com.entity.PlayerEntity;
public class SetNewPlayerBean {
	public static PlayerEntity setPlayerEntity(String count, String ciper, String name, String team, String date, String pictureWay, int old, String readme, String clickmail) {
		PlayerEntity player = new PlayerEntity();
		Timestamp d = new Timestamp(System.currentTimeMillis());
		d = Timestamp.valueOf(date);
		d =Timestamp.valueOf(date);
		player.setCount(count);
		player.setCiper(ciper);
		player.setName(name);
		player.setTeam(team);
		player.setDay(d);
		player.setPicture_way(pictureWay);
		player.setOld(old);
		player.setClickmail(clickmail);
		player.setSucceed(false);
		player.setReadme(readme);
		return player;
	}
}
