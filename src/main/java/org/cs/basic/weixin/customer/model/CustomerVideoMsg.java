package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Video;

/**
 * ��Ƶ�ͷ���Ϣ
 * @author xuxile
 *
 */
public class CustomerVideoMsg extends CustomerMsg{

	private Video video;//��Ƶ��Ϣ����

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
}
