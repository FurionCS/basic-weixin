package org.cs.basic.weixin.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cs.basic.weixin.keyword.WxSendMessageWeiXin;
import org.cs.basic.weixin.msg.model.recv.WxRecvEventMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvGeoMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvLinkMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvPicMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvTextMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvVideoMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvVoiceMsg;

/**
 * post请求 用户发来的信息之逻辑处理类
 * @author xuxile
 *
 */
public class ServerWeiXin extends WxSendMessageWeiXin{
	
	/**
	 * 解析微信发来的文本消息内容
	 **/
	public static String getTextMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxRecvMsg msg = WeiXin.recv(request.getInputStream());//获得消息
		WxRecvTextMsg m = (WxRecvTextMsg) msg;
		String text = m.getContent().trim();//获得文本消息
		return text;
	}
	
	/**
	 * 解析微信发来的事件类型 subscribe(订阅)、unsubscribe(取消订阅) SCAN(扫描带参数二维码事件) LOCATION(上报地理位置事件) CLICK(点击菜单)
	 **/
	public static String getEventMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxRecvMsg msg = WeiXin.recv(request.getInputStream());//获得消息
		WxRecvEventMsg m = (WxRecvEventMsg) msg;
		String event = m.getEvent().toLowerCase();//获得事件类型
		return event;
	}
	
	/**
	 * 解析接收消息类型 text_文本消息,image_图片消息,voice_语音消息,video_视频信息,location_地理位置消息,event_事件消息
	 **/
	public static String getMsgType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxRecvMsg msg = WeiXin.recv(request.getInputStream());//获得消息
		String MsgType="";
		/** -------------------1.文本消息发送，回复处理-------------------------- */
		if(msg instanceof WxRecvTextMsg) {
			MsgType="text";
		}
		/** -------------------2.被关注之后的事件-------------------------- */
		else if(msg instanceof WxRecvEventMsg) {
			MsgType="event";
		}
		/** -------------------3.地理位置信息-------------------------- */
		else if(msg instanceof WxRecvGeoMsg) {	
			MsgType="location";
		}
		/** -------------------4.语音消息-------------------------- */
		else if(msg instanceof WxRecvVoiceMsg) {
			MsgType="voice";
		}
		/** -------------------5.图片消息-------------------------- */
		else if(msg instanceof WxRecvPicMsg) {
			MsgType="image";
		}
		/** -------------------6.视频消息-------------------------- */
		else if(msg instanceof WxRecvVideoMsg) {
			MsgType="video";
		}
		/** -------------------7.链接消息-------------------------- */
		else if(msg instanceof WxRecvLinkMsg) {
			MsgType="link";
		}
		/** -------------------8.未能识别的消息-------------------- */
		else {
			MsgType="unknown";
		}		
		return MsgType;
	}
}
