package org.cs.basic.weixin.msg.model.send;

import org.jdom.Document;

/**
 * 发�?语音消息
 * @author xuxile 
 **/
public class WxSendVoiceMsg extends WxSendMsg {
	private String mediaId;
	
	public WxSendVoiceMsg(WxSendMsg msg,String mediaId) {
		super(msg);
		setMsgType("voice");
		this.mediaId = mediaId;
	}
	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public Document toDocument() {
		Document doc = super.toDocument();
		createElement(doc.getRootElement(), "MediaId", getMediaId());
		return doc;
	}
}
