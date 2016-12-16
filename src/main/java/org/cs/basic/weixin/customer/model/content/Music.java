package org.cs.basic.weixin.customer.model.content;

/**
 * 音乐客服消息内容
 * @author xuxile
 *
 */
public class Music {
	
	private String title;//音乐标题
	private String description;//音乐描述
	private String musicurl;//音乐链接
	private String hqmusicurl;//高品质音乐链接，wifi环境优先使用该链接播放音乐
	private String thumb_media_id;//缩略图的媒体ID

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

	public String getMusicurl() {
		return musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	public String getHqmusicurl() {
		return hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumbMediaId) {
		thumb_media_id = thumbMediaId;
	}
	
}
