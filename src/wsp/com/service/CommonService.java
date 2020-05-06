package wsp.com.service;

import wsp.com.dao.CommonDao;

/**
 * 
 * @author WSP
 */
public class CommonService {
	private CommonDao commonDao = new CommonDao();
	public boolean canLoad(String count, String ciper, String who) {
		String tabelName = null; 
		if (who.equals("职业选手")) {
			tabelName = "player";
		} else if (who.equals("管理员")) {
			tabelName = "manager";
		} else {
			tabelName = "team_manager";
		}
		String model = commonDao.checkCiper(count, tabelName);
		if (model!=null&&model.equals(ciper)) {
			return true;
		};
		return false;
	}
}
