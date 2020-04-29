package wsp.com.control;

import wsp.com.service.CommonService;

/**
 * 
 * @author WSP
 */
public class CommonControl {
	CommonService commonService = new CommonService();
	public boolean canLoad(String count, String ciper, String who) {
			return commonService.canLoad(count, ciper, who);
	}
}
