package org.cs.basic.weixin.customer.model.content;

/**
 * 视频客服消息内容
 * @author xuxile
 *
 */
public class Video {

	private String media_id;
	private String title;
	private String description;

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
