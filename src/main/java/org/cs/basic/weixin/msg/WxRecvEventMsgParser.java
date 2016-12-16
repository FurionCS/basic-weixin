package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvEventMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * 接收事件消息�?
 * @author xuxile 
 **/
public class WxRecvEventMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvEventMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String event = getElementText(root, "Event");
		String eventKey = getElementText(root, "EventKey");
		
		return new WxRecvEventMsg(msg, event,eventKey);
	}

}
