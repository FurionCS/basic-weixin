package org.cs.basic.weixin.notice.model.group;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据分组进行群发图片消息�?
 * @author xuxile 
 **/
public class AdviceImageGroupMsg extends AdviceGroupMsg{

	private Mptype image;//用于设定即将发�?的图片消�?

	public Mptype getImage() {
		return image;
	}

	public void setImage(Mptype image) {
		this.image = image;
	}
	
}
