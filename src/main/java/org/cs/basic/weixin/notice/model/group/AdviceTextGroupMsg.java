package org.cs.basic.weixin.notice.model.group;

import org.cs.basic.weixin.notice.model.Mptext;

/**
 * 根据分组进行群发文字消息�?
 * @author xuxile 
 **/
public class AdviceTextGroupMsg extends AdviceGroupMsg{

	private Mptext text;

	public Mptext getText() {
		return text;
	}

	public void setText(Mptext text) {
		this.text = text;
	}
	
	
	
}
