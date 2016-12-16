package org.cs.basic.weixin.msg;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;


/**
 * 接收消息父类
 *@author xuxile 
 **/
public abstract class WxRecvMsgBaseParser implements WxRecvMsgParser {

	public WxRecvMsg parser(Document doc) throws JDOMException {
		/*try {
			new XMLOutputter().output(doc, System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Element root = doc.getRootElement();
		String toUserName = getElementText(root, "ToUserName");
		String fromUserName = getElementText(root, "FromUserName");
		String createTime = getElementText(root, "CreateTime");
		String msgType = getElementText(root, "MsgType");
		String msgId = getElementText(root, "MsgId");
		
		return parser(root,new WxRecvMsg(toUserName,fromUserName,createTime,msgType,msgId));
	}
	
	protected abstract WxRecvMsg parser(Element root,WxRecvMsg msg) throws JDOMException;
	
	protected String getElementText(Element elem,String xpath) throws JDOMException {
		/*Text text = ((Text)XPath.selectSingleNode(elem, xpath+"/text()"));
		if(null == text) {
			return "";
		}
		return text.getText();*/
		
		return elem.getChildText(xpath);
	}

}
