package wsp.com.dao;

import wsp.com.entity.PlayerEntity;

/**
 * 通用操作
 * @author WSP
 */
public class CommonDao {
	CommonMethodDao<Object> com = new CommonMethodDao<>();
	public String checkCiper(String count ,String tabelName) {
		return com.getCiper(count, tabelName);
	}
}
