package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.recv.WxRecvPicMsg;
import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * 接收图片消息�?
 * @author xuxile 
 **/
public class WxRecvPicMsgParser extends WxRecvMsgBaseParser {
	@Override
	protected WxRecvPicMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String picUrl=getElementText(root, "PicUrl");
		String mediaId=getElementText(root, "MediaId");
		return new WxRecvPicMsg(msg, picUrl,mediaId);
	}

}
