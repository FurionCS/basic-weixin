package org.cs.basic.weixin.user.group.model;

import org.cs.basic.weixin.user.group.util.GroupDeleteBase;

public class GroupDeleteVo {

	private GroupDeleteBase group;

	public GroupDeleteBase getGroup() {
		return group;
	}

	public void setGroup(GroupDeleteBase group) {
		this.group = group;
	}

	public GroupDeleteVo(GroupDeleteBase group) {
		super();
		this.group = group;
	}

	public GroupDeleteVo() {
		super();
	}
	
}
