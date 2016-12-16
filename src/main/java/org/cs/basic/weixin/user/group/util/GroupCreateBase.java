package org.cs.basic.weixin.user.group.util;


/**
 * 创建分组基础�?
 * @author xuxile
 *
 */
public class GroupCreateBase {

	private String name;//分组名字，UTF8编码
	
	public GroupCreateBase(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
