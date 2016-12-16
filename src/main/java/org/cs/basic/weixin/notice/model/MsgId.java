package org.cs.basic.weixin.notice.model;

/**
 * 删除群发消息POST�?
 * @author xuxile 
 **/
public class MsgId {
	
	private String msgid;

	public MsgId(String msgid){
		this.msgid=msgid;
	}
	
	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
	
}
