package org.cs.basic.test.util;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.cs.basic.weixin.common.AccessToken;

public class WXUtils {
	static String accessToken=null;
	public static String appid="wx2b1b15e0e9bf193a";
	public static String secret="f6fc6b4f3b57bde35bdf02e85f74c5a6";
	public static Date createTime;
	
	/**
	 * token
	 * @return
	 */
	public static String getAccessToken(){
		if(StringUtils.isNotEmpty(accessToken)&&DateUtils.secondOfDate(new Date(), createTime)<7200){
	    	return accessToken;
	    }else{
	    	try {
	    		accessToken = AccessToken.getAccessToken(appid, secret);
	    		createTime=new Date();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return accessToken;
	    }
	}
}
