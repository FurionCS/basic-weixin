package org.cs.basic.weixin.qr.model;

/**
 * 永久二维码类
 * @author xuxile
 */
public class QrForeverMsg {

	private String action_name;//二维码类型，QR_SCENE为临�?QR_LIMIT_SCENE为永�?
	private QrActionInfo action_info;//二维码详细信�?
	
	public QrForeverMsg(String actionName, QrActionInfo actionInfo) {
		action_name = actionName;
		action_info = actionInfo;
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
