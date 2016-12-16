package org.cs.basic.weixin.user.group.model;

import org.cs.basic.weixin.user.group.util.GroupCreateBase;


/**
 * 创建分组
 * @author xuxile
 *
 */
public class GroupCreateVo {

	private GroupCreateBase group;//分组信息

	public GroupCreateVo(GroupCreateBase group) {
		this.group = group;
	}

	public GroupCreateBase getGroup() {
		return group;
	}

	public void setGroup(GroupCreateBase group) {
		this.group = group;
	}

	
	
}
