package org.cs.basic.weixin.oauth.model;

import com.alibaba.fastjson.JSONArray;

/**
 * 授权者基本信息
 * @author xuxile 
 * */
public class OauthUser {

	
	private String openid;//用户的标识，对当前公众号唯一
	private String nickname;//用户的昵称
	private String sex;//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String city;//用户所在城市
	private String country;//用户所在国家
	private String province;//用户所在省份
	private String headimgurl;//用户头像，最后一个数值代表正方形头像大小
	                           //（有0、46、64、96、132数值可选，0代表640*640正方形头像），
	                           //用户没有头像时该项为空
	private JSONArray privilege;//用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	
	
	
	public OauthUser(String openid, String nickname,
			String sex, String city, String country,
			String province, String headimgurl,
			JSONArray privilege) {
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.city = city;
		this.country = country;
		this.province = province;
		this.headimgurl = headimgurl;
		this.privilege = privilege;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public JSONArray getPrivilege() {
		return privilege;
	}
	public void setPrivilege(JSONArray privilege) {
		this.privilege = privilege;
	}
	
}