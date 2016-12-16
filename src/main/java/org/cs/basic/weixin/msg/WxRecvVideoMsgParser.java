package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvVideoMsg;
import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * 接收视频消息�?
 * @author xuxile 
 **/
public class WxRecvVideoMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvVideoMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String mediaId = getElementText(root, "MediaId");
		String thumbMediaId = getElementText(root, "ThumbMediaId");
		return new WxRecvVideoMsg(msg, mediaId, thumbMediaId);
	}

}
