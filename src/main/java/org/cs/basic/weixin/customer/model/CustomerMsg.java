package org.cs.basic.weixin.customer.model;

/**
 * 客服消息父类
 * @author xuxile
 *
 */
public class CustomerMsg {
	
	private String touser;//接收者OpenID
	private String msgtype;//消息类型
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	
}
