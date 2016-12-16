package org.cs.basic.weixin.notice.model.openid;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据OpenID进行群发图文消息类
 * @author xuxile 
 **/
public class AdviceMpnewsOpenIDMsg extends AdviceOpenIDMsg{

	private Mptype mpnews;//用于设定即将发送的图文消息
	
	public Mptype getMpnews() {
		return mpnews;
	}

	public void setMpnews(Mptype mpnews) {
		this.mpnews = mpnews;
	}
	
	
}
