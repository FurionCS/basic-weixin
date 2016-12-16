package org.cs.basic.weixin.notice.model.openid;

import org.cs.basic.weixin.notice.model.Mptext;

/**
 * 根据OpenID进行群发文字消息类
 * @author xuxile 
 **/
public class AdviceTextOpenIDMsg extends AdviceOpenIDMsg{

	private Mptext text;

	public Mptext getText() {
		return text;
	}

	public void setText(Mptext text) {
		this.text = text;
	}
	
	
	
}
