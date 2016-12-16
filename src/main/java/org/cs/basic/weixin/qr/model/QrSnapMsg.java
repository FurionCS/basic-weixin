package org.cs.basic.weixin.qr.model;

/**
 * 临时二维码类
 * @author xuxile
 */
public class QrSnapMsg {

	private int expire_seconds;//该二维码有效时间，以秒为单位�?�?��不超�?800�?
	private String action_name;//二维码类型，QR_SCENE为临�?QR_LIMIT_SCENE为永�?
	private QrActionInfo action_info;//二维码详细信�?
	
	public QrSnapMsg(int expireSeconds, String actionName,
			QrActionInfo actionInfo) {
		expire_seconds = expireSeconds;
		action_name = actionName;
		action_info = actionInfo;
	}
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expireSeconds) {
		expire_seconds = expireSeconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String actionName) {
		action_name = actionName;
	}
	public QrActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(QrActionInfo actionInfo) {
		action_info = actionInfo;
	}
	
}
