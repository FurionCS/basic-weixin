package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvVoiceMsg;
import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * 接收语音消息�?
 * @author xuxile 
 **/
public class WxRecvVoiceMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvVoiceMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String mediaId = getElementText(root, "MediaId");
		String format = getElementText(root, "Format");
		String recognition = getElementText(root, "Recognition");
		return new WxRecvVoiceMsg(msg, mediaId, format, recognition);
	}

}
