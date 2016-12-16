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
 * post���� �û���������Ϣ֮�߼�������
 * @author xuxile
 *
 */
public class ServerWeiXin extends WxSendMessageWeiXin{
	
	/**
	 * ����΢�ŷ������ı���Ϣ����
	 **/
	public static String getTextMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxRecvMsg msg = WeiXin.recv(request.getInputStream());//�����Ϣ
		WxRecvTextMsg m = (WxRecvTextMsg) msg;
		String text = m.getContent().trim();//����ı���Ϣ
		return text;
	}
	
	/**
	 * ����΢�ŷ������¼����� subscribe(����)��unsubscribe(ȡ������) SCAN(ɨ���������ά���¼�) LOCATION(�ϱ�����λ���¼�) CLICK(����˵�)
	 **/
	public static String getEventMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxRecvMsg msg = WeiXin.recv(request.getInputStream());//�����Ϣ
		WxRecvEventMsg m = (WxRecvEventMsg) msg;
		String event = m.getEvent().toLowerCase();//����¼�����
		return event;
	}
	
	/**
	 * ����������Ϣ���� text_�ı���Ϣ,image_ͼƬ��Ϣ,voice_������Ϣ,video_��Ƶ��Ϣ,location_����λ����Ϣ,event_�¼���Ϣ
	 **/
	public static String getMsgType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxRecvMsg msg = WeiXin.recv(request.getInputStream());//�����Ϣ
		String MsgType="";
		/** -------------------1.�ı���Ϣ���ͣ��ظ�����-------------------------- */
		if(msg instanceof WxRecvTextMsg) {
			MsgType="text";
		}
		/** -------------------2.����ע֮����¼�-------------------------- */
		else if(msg instanceof WxRecvEventMsg) {
			MsgType="event";
		}
		/** -------------------3.����λ����Ϣ-------------------------- */
		else if(msg instanceof WxRecvGeoMsg) {	
			MsgType="location";
		}
		/** -------------------4.������Ϣ-------------------------- */
		else if(msg instanceof WxRecvVoiceMsg) {
			MsgType="voice";
		}
		/** -------------------5.ͼƬ��Ϣ-------------------------- */
		else if(msg instanceof WxRecvPicMsg) {
			MsgType="image";
		}
		/** -------------------6.��Ƶ��Ϣ-------------------------- */
		else if(msg instanceof WxRecvVideoMsg) {
			MsgType="video";
		}
		/** -------------------7.������Ϣ-------------------------- */
		else if(msg instanceof WxRecvLinkMsg) {
			MsgType="link";
		}
		/** -------------------8.δ��ʶ�����Ϣ-------------------- */
		else {
			MsgType="unknown";
		}		
		return MsgType;
	}
}
