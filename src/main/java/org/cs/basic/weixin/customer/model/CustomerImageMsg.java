package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Image;

/**
 * ͼƬ�ͷ���Ϣ
 * @author xuxile
 *
 */
public class CustomerImageMsg extends CustomerMsg{

	private Image image;//ͼƬ��Ϣ����

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
