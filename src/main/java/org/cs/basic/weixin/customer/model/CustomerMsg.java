package org.cs.basic.weixin.customer.model;

/**
 * �ͷ���Ϣ����
 * @author xuxile
 *
 */
public class CustomerMsg {
	
	private String touser;//������OpenID
	private String msgtype;//��Ϣ����
	
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
