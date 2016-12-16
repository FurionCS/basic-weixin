package org.cs.basic.weixin.msg.model.recv;

/**
 * 文本消息
 * @author xuxile 
 **/
public class WxRecvTextMsg extends WxRecvMsg {
	private String content;
	
	public WxRecvTextMsg(WxRecvMsg msg,String content) {
		super(msg);
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
