package org.cs.basic.weixin.msg.model.send;

import org.jdom.Document;

/**
 * 发�?视频消息
 * @author xuxile 
 **/
public class WxSendVideoMsg extends WxSendMsg {
	private String mediaId;
	private String title;
	private String description;
	
	public WxSendVideoMsg(WxSendMsg msg,String mediaId,String title,String description) {
		super(msg);
		setMsgType("video");
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}
	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Document toDocument() {
		Document doc = super.toDocument();
		createElement(doc.getRootElement(), "MediaId", getMediaId());
		createElement(doc.getRootElement(), "Title", getTitle());
		createElement(doc.getRootElement(), "Description", getDescription());
		return doc;
	}
}
