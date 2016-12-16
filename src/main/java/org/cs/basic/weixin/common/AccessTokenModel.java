package org.cs.basic.weixin.common;
/**
 * 获得accessToken的model
 * @author YoYo
 *
 */
public class AccessTokenModel {
	private String appid;
	private String secret;
	
	public AccessTokenModel() {
		super();
	}
	public AccessTokenModel(String appid, String secret) {
		super();
		this.appid = appid;
		this.secret = secret;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	

}
