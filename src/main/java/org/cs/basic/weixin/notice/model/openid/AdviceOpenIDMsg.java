package org.cs.basic.weixin.notice.model.openid;

import java.util.List;

/**
 * 根据OpenID进行群发文字对象父类
 * @author xuxile 
 **/
public class AdviceOpenIDMsg {

	private List<String> touser;
	private String msgtype;
	
	public List<String> getTouser() {
		return touser;
	}
	public void setTouser(List<String> touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	
	
}
