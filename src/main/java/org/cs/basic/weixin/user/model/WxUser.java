package org.cs.basic.weixin.user.model;
/**
 * 微信用户基本信息
 * @author xuxile 
 * */
public class WxUser {

	private String subscribe;//用户是否订阅该公众号标识，�?�?时，代表此用户没有关注该公众号，拉取不到其余信息�?
	private String openid;//用户的标识，对当前公众号唯一
	private String nickname;//用户的昵�?
	private String sex;//用户的�?别，值为1时是男�?，�?�?时是女�?，�?�?时是未知
	private String city;//用户�?��城市
	private String country;//用户�?��国家
	private String province;//用户�?��省份
	private String language;//用户的语�?���?��中文为zh_CN
	private String headimgurl;//用户头像，最后一个数值代表正方形头像大小
	                           //（有0�?6�?4�?6�?32数�?可�?�?代表640*640正方形头像）�?
	                           //用户没有头像时该项为�?
	private String subscribe_time;//用户关注时间，为时间戳�?如果用户曾多次关注，则取�?��关注时间
	

	public String getSubscribe() {
		return subscribe;
	}
	
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(String subscribeTime) {
		subscribe_time = subscribeTime;
	}
}
