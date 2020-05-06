package wsp.com.util;
/**
 * 密码处理
 * @author WSP
 */
public class encryptionutil {
	/**
	 * 加密
	 * @param saveCiper
	 * 返回密码
	 * @return
	 */
	 public static String changeCiper(String saveCiper) {
	    	String newString;																		
	    	final int START = 2;
	    	final int END = 9;
	    	final int MATH_START = 0;
	    	final int MATH_END = 7;
	    	byte [] b = saveCiper.getBytes();
	    	int i = 0;
	    	int length = b.length;
	    	boolean hasChange = true;
	    	int first = GetRamomMathUtil.GetRamdom(START, END, true);
	    	int second = GetRamomMathUtil.GetRamdom(MATH_START, MATH_END, false);
	    	int third = GetRamomMathUtil.GetRamdom(MATH_START, MATH_END, false);
	    	for(;i<length;i++) {
	    		if ((b[i]>='a'&&b[i]<='z')||(b[i]>='A'&&b[i]<='Z')) {
					if(hasChange) {
						b[i] = (byte)(b[i]+first);
						hasChange = false;
					}
				} else {
					if (((int)b[i]%2)==0) {
						b[i] = (byte)(b[i]+second);
					} else {
						b[i] = (byte)(b[i]-third);
					}
				}
	    	}
	    	newString = new String(b);
	    	newString = first+newString+third+second;	
			return newString;
		}
	    
	   
	    
	 /**
	  * 保存的密码
	  * @param changeCiper
	  * 真正的密码
	  * @return
	  */
	    public static String getTrueCiper(String changeCiper) {
	    	if (changeCiper==null) {
				return null;
			}
	    	String newString;
	    	boolean bool = true;
	    	byte[] b = changeCiper.getBytes();
	    	char[] stringChar = new char[changeCiper.length()-3];
	    	int j = b.length-2;
	    	int i=1;
	    	for(;i<j;i++) {
	    		if (b[i]>='A') {
					if(bool)  {
						b[i] = (byte)(b[i]-b[0]+48);
						bool = false;
					}
				} else {
					if (b[i]%2!=0) {
						b[i] = (byte)(b[i]-b[b.length-1]+48);
					} else {
						b[i]= (byte)(b[i]+b[b.length-2]-48);
					}
				}
	    		stringChar[i-1] =(char)b[i];
	    	}
	    	newString = new String(stringChar);
	    	System.out.println(newString);
	    	return newString;
	    }
}
