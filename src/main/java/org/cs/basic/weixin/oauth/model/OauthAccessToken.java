package org.cs.basic.weixin.oauth.model;

/**
 * 通过code换取网页授权access_token信息
 * @author xuxile
 *
 */
public class OauthAccessToken {

	private String access_token;//网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	private int expires_in;//access_token接口调用凭证超时时间，单位（秒）
	private String refresh_token;//用户刷新access_token
	private String openid;//用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	private String scope;//用户授权的作用域，使用逗号（,）分隔
	
	
	public OauthAccessToken(String accessToken, int expiresIn,
			String refreshToken, String openid, String scope) {
		this.access_token = accessToken;
		this.expires_in = expiresIn;
		this.refresh_token = refreshToken;
		this.openid = openid;
		this.scope = scope;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expiresIn) {
		expires_in = expiresIn;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refreshToken) {
		refresh_token = refreshToken;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

}