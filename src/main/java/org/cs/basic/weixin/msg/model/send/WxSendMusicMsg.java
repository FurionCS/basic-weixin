package org.cs.basic.weixin.msg.model.send;

import org.jdom.Document;
import org.jdom.Element;

/**
 * 发�?音乐信息
 * @author xuxile 
 **/
public class WxSendMusicMsg extends WxSendMsg {
	private String musicUrl;
	private String hqMusicUrl;
	private String description;
	private String title;
	private String thumbMediaId;
	
	public WxSendMusicMsg(WxSendMsg msg,String title,String description,String musicUrl,String hqMusicUrl,String thumbMediaId) {
		super(msg);
		setMsgType("music");
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hqMusicUrl = hqMusicUrl;
		this.thumbMediaId = thumbMediaId;
	}
	
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	@Override
	public Document toDocument() {
		Document doc = super.toDocument();
		Element music = createElement(doc.getRootElement(), "Music", "");
		createElement(music, "Description", getDescription());
		createElement(music, "Title", getTitle());
		createElement(music, "MusicUrl", getMusicUrl());
		createElement(music, "HQMusicUrl", getHqMusicUrl());
		createElement(music, "ThumbMediaId", getThumbMediaId());
		return doc;
	}
}
