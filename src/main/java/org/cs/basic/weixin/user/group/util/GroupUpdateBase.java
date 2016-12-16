package org.cs.basic.weixin.user.group.util;


/**
 * 修改分组基础�?
 * @author xuxile
 *
 */
public class GroupUpdateBase {

	private String id;//分组id，由微信分配
	private String name;//分组名字，UTF8编码
	
	public GroupUpdateBase(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
