package org.cs.basic.weixin.notice.model.group;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据分组进行群发视频消息�?
 * @author xuxile 
 **/
public class AdviceMpvideoGroupMsg extends AdviceGroupMsg{

	private Mptype mpvideo;//用于设定即将发�?的视频消�?

	public Mptype getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(Mptype mpvideo) {
		this.mpvideo = mpvideo;
	}

	
	
}
