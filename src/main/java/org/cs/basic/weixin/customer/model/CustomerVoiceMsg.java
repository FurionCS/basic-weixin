package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Voice;

/**
 * �����ͷ���Ϣ
 * @author xuxile
 *
 */
public class CustomerVoiceMsg extends CustomerMsg{

	private Voice voice;//������Ϣ����

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	
	
}
