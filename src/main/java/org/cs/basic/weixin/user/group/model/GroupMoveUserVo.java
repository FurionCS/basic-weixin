package org.cs.basic.weixin.user.group.model;


/**
 * 移动用户分组
 * @author xuxile
 *
 */
public class GroupMoveUserVo{

	private String openid;//用户唯一标识�?
	private String to_groupid;//分组id
	
	public GroupMoveUserVo(String openid, String to_groupid) {
		this.openid = openid;
		this.to_groupid = to_groupid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getTo_groupid() {
		return to_groupid;
	}
	public void setTo_groupid(String toGroupid) {
		to_groupid = toGroupid;
	}
	
	
	
}
