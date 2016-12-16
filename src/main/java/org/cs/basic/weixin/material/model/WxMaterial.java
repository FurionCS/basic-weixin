package org.cs.basic.weixin.material.model;

public class WxMaterial {
	private String type;
	private String offset;
	private String count;
	public WxMaterial() {
		super();
	}
	public WxMaterial(String type, String offset, String count) {
		super();
		this.type = type;
		this.offset = offset;
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
