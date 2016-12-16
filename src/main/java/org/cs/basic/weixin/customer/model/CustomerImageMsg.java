package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Image;

/**
 * 图片客服消息
 * @author xuxile
 *
 */
public class CustomerImageMsg extends CustomerMsg{

	private Image image;//图片消息内容

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
