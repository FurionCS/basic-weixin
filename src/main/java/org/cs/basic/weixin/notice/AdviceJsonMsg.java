package org.cs.basic.weixin.notice;

/**
 * 群发消息返回结果
 *@author xuxile 
 **/
public class AdviceJsonMsg {

	private String errcode;//错误�?
	private String errmsg;//错误信息
	private String msg_id;//消息ID
	
	public AdviceJsonMsg(String errcode,String errmsg,String msg_id){
		this.errcode=errcode;
		this.errmsg=errmsg;
		this.msg_id=msg_id;
	}
	
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
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msgId) {
		msg_id = msgId;
	}
	
	
	
}
