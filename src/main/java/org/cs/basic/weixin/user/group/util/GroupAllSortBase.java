package org.cs.basic.weixin.user.group.util;

import java.io.Serializable;


/**
 * 分组信息
 * @author xuxile
 *
 */
public class GroupAllSortBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;//分组id，由微信分配
	private String name;//分组名字，UTF8编码
	private String count;//分组内用户数
	
	private Integer num;//剩余次数
	public GroupAllSortBase(String id, String name, String count) {
		this.id = id;
		this.name = name;
		this.count = count;
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
