package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Text;

/**
 * �ı��ͷ���Ϣ
 * @author xuxile
 *
 */
public class CustomerTextMsg extends CustomerMsg{

	private Text text;//�ı���Ϣ����

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	
	
}
