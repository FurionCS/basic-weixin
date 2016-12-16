package org.cs.basic.weixin.user.model;

import java.util.List;

/**
 * 微信用户集合
 * @author xuxile 
 * */
public class WxUserClump {

	private int total;//关注该公众账号的总用户数
	private int count;//拉取的OPENID个数，最大�?�?0000
	private List<WxUser> wxUsers;//列表数据，OPENID的列�?
	private String next_openid;//拉取列表的后�?��用户的OPENID
	
	public WxUserClump(int total, int count, List<WxUser> wxUsers,
			String nextOpenid) {
		this.total = total;
		this.count = count;
		this.wxUsers = wxUsers;
		this.next_openid = nextOpenid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<WxUser> getWxUsers() {
		return wxUsers;
	}
	public void setWxUsers(List<WxUser> wxUsers) {
		this.wxUsers = wxUsers;
	}
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String nextOpenid) {
		next_openid = nextOpenid;
	}
	
}
