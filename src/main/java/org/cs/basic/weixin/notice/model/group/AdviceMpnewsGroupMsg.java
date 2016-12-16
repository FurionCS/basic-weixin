package org.cs.basic.weixin.notice.model.group;

import org.cs.basic.weixin.notice.model.Mptype;

/**
 * 根据分组进行群发图文消息�?
 * @author xuxile 
 **/
public class AdviceMpnewsGroupMsg extends AdviceGroupMsg{

	private Mptype mpnews;//用于设定即将发�?的图文消�?
	
	public Mptype getMpnews() {
		return mpnews;
	}

	public void setMpnews(Mptype mpnews) {
		this.mpnews = mpnews;
	}
	
	
}
