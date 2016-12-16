package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvTextMsg;
import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * 接收文本消息�?
 * @author xuxile 
 **/
public class WxRecvTextMsgParser extends WxRecvMsgBaseParser{

	@Override
	protected WxRecvTextMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvTextMsg(msg, getElementText(root, "Content"));
	}

	
}
