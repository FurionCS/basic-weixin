package org.cs.basic.weixin.notice.model.openid;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据OpenID进行群发图片消息类
 * @author xuxile 
 **/
public class AdviceImageOpenIDMsg extends AdviceOpenIDMsg{

	private Mptype image;//用于设定即将发送的图片消息

	public Mptype getImage() {
		return image;
	}

	public void setImage(Mptype image) {
		this.image = image;
	}
	
}
