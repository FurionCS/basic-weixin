package org.cs.basic.weixin.user.group.model;

import org.cs.basic.weixin.user.group.util.GroupUpdateBase;

/**
 * 修改分组
 * @author xuxile
 *
 */
public class GroupUpdateVo {

	private GroupUpdateBase group;
	
	public GroupUpdateVo(GroupUpdateBase group) {
		super();
		this.group = group;
	}

	public GroupUpdateBase getGroup() {
		return group;
	}

	public void setGroup(GroupUpdateBase group) {
		this.group = group;
	}
	
	
}
