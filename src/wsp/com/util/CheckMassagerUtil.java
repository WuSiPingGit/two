package wsp.com.util;
/**
 * 数据校验，判断是否正确
 * @author WSP
 */
public class CheckMassagerUtil {
	private CheckMassagerUtil() {}
	/**
	 * 模板
	 * @param model
	 * 带校验数据
	 * @param willCheck
	 * 校验方式
	 * @param isMatches
	 * 是否通过
	 * @return
	 */
	public static boolean checkMassager(String model, String willCheck, boolean isMatches) {
		if (isMatches) {
			if (willCheck.matches(model)) {
				return true;
			}
		} else {
			if (willCheck.equals(model)) {
				return true;
			}
		}
		return false;
	}
}
