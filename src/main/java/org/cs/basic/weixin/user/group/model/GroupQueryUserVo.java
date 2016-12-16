package org.cs.basic.weixin.user.group.model;


/**
 * 查询用户�?��分组
 * @author xuxile
 *
 */
public class GroupQueryUserVo {

	private String openid;//用户的OpenID

	public GroupQueryUserVo(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	
	
}
