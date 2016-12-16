package org.cs.basic.weixin.notice.model;

/**
 * 群发父类属�?：用于设定图文消息的接收�?
 * @author xuxile 
 **/
public class Filter {

	private String group_id;
	
	public Filter(String group_id){
		this.group_id=group_id;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String groupId) {
		group_id = groupId;
	}
	
}
