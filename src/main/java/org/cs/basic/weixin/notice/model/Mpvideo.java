package org.cs.basic.weixin.notice.model;

/**
 * 群发消息：视频信�?
 * @author xuxile 
 **/
public class Mpvideo {

	private String media_id;//用于群发的消息的media_id
	private String title;//消息的标�?
	private String description;//消息的描�?
	
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String mediaId) {
		media_id = mediaId;
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
	
	
}
