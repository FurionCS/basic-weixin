package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvLinkMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.jdom.Element;
import org.jdom.JDOMException;
/**
 * 接收链接消息�?
 * @author xuxile 
 **/
public class WxRecvLinkMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvLinkMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		
		String title = getElementText(root, "Title");
		String description = getElementText(root, "Description");
		String url = getElementText(root, "Url");
		return new WxRecvLinkMsg(msg, title, description, url);
	}

}
