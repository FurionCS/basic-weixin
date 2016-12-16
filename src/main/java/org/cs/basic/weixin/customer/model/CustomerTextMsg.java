package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Text;

/**
 * 文本客服消息
 * @author xuxile
 *
 */
public class CustomerTextMsg extends CustomerMsg{

	private Text text;//文本消息内容

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	
	
}
