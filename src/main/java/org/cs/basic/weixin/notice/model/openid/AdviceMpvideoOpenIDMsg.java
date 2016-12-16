package org.cs.basic.weixin.notice.model.openid;


import org.cs.basic.weixin.notice.model.Mpvideo;

/**
 * 根据OpenID进行群发视频消息类
 * @author xuxile 
 **/
public class AdviceMpvideoOpenIDMsg extends AdviceOpenIDMsg{

	private Mpvideo video;//用于设定即将发送的视频消息

	public Mpvideo getVideo() {
		return video;
	}

	public void setVideo(Mpvideo video) {
		this.video = video;
	}
	
}
