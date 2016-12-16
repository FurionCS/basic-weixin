package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.jdom.Document;
import org.jdom.JDOMException;


/**
 * 接收消息公共接口
 *@author xuxile 
 **/
public interface WxRecvMsgParser {
	WxRecvMsg parser(Document doc) throws JDOMException;
}
