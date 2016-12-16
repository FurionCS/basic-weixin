package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Video;

/**
 * 视频客服消息
 * @author xuxile
 *
 */
public class CustomerVideoMsg extends CustomerMsg{

	private Video video;//视频消息内容

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
}
