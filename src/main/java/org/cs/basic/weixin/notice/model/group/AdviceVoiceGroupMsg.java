package org.cs.basic.weixin.notice.model.group;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据分组进行群发语音消息�?
 * @author xuxile 
 **/
public class AdviceVoiceGroupMsg extends AdviceGroupMsg{

	private Mptype voice;//用于设定即将发�?的语音消�?

	public Mptype getVoice() {
		return voice;
	}

	public void setVoice(Mptype voice) {
		this.voice = voice;
	}
	
	
	
}
