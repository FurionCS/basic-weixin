package org.cs.basic.weixin.notice.model.openid;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据OpenID进行群发语音消息类
 * @author xuxile 
 **/
public class AdviceVoiceOpenIDMsg extends AdviceOpenIDMsg{

	private Mptype voice;//用于设定即将发送的语音消息

	public Mptype getVoice() {
		return voice;
	}

	public void setVoice(Mptype voice) {
		this.voice = voice;
	}
	
	
	
}
