package org.cs.basic.weixin.notice.model.group;

import org.cs.basic.weixin.notice.model.Filter;


/**
 * ���ݷ������Ⱥ�����ֶ�����
 * @author xuxile 
 **/
public class AdviceGroupMsg {

	private Filter filter;
	private String msgtype;
	
	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
}
