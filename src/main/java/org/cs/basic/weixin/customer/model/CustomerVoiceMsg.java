package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Voice;

/**
 * 语音客服消息
 * @author xuxile
 *
 */
public class CustomerVoiceMsg extends CustomerMsg{

	private Voice voice;//语音消息内容

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	
	
}
