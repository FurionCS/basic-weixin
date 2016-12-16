package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.MapOperCode;

/**
 * 客服消息记录接收类
 * @author xuxile
 *
 */
public class CustomerRecvRecordMsg {

	private String worker;//客服账号
	private String openid;//用户的标识，对当前公众号唯一
	private String opercode;//操作ID（会话状态），具体说明见下文
	private String time;//操作时间，UNIX时间戳
	private String text;//聊天记录
	
	public CustomerRecvRecordMsg(String worker, String openid, String opercode,
			String time, String text) {
		this.worker = worker;
		this.openid = openid;
		this.opercode = MapOperCode.getOperCodeDescription(opercode);
		this.time = time;
		this.text = text;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOpercode() {
		return opercode;
	}
	public void setOpercode(String opercode) {
		this.opercode = MapOperCode.getOperCodeDescription(opercode);
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
