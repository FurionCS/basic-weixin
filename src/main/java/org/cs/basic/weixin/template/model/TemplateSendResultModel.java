package org.cs.basic.weixin.template.model;

/**
 * 发送模板消息
 * @author YoYo
 *
 */
public class TemplateSendResultModel {
	private String errcode; 
	private String errmsg;
	private String msgid;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public TemplateSendResultModel(String errcode, String errmsg, String msgid) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.msgid = msgid;
	}
	public TemplateSendResultModel() {
		super();
	}
	
	

}
