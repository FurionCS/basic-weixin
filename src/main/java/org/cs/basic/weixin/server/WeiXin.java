package org.cs.basic.weixin.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.cs.basic.weixin.msg.WxMsgKit;
import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.send.WxSendMsg;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;


/**
 * 帮助类说明
 * @author xuxile
 *
 */
public final class WeiXin {
	
	/**
	 * 验证信息说明
	 * @param token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	// check signature，加密程序
		// signature=29ba6d9ea244e799091f8525ca8d1ee480f2a583&echostr=5877301187008054751&timestamp=1368966622&nonce=1368415815
	public static boolean access(String token,String signature,String timestamp,String nonce) {
		List<String> ss = new ArrayList<String>();
		ss.add(timestamp);
		ss.add(nonce);
		ss.add(token);
		
		Collections.sort(ss);
		
		StringBuilder builder = new StringBuilder();
		for(String s : ss) {
			builder.append(s);
		}
		return signature.equalsIgnoreCase(HashKit.sha1(builder.toString()));
	}
	
	public static WxRecvMsg recv(InputStream in) throws JDOMException, IOException {
		return WxMsgKit.parse(in);
	}
	
	public static void send(WxSendMsg msg,OutputStream out) throws JDOMException,IOException {
		Document doc = WxMsgKit.parse(msg);
		if(null != doc) {
			new XMLOutputter().output(doc, out);
		} else {
			Logger.getAnonymousLogger().warning("发送消息时,解析出dom为空 msg :"+msg);
		}
	}
	
	public static WxSendMsg builderSendByRecv(WxRecvMsg msg) {
		WxRecvMsg m = new WxRecvMsg(msg);
		String from = m.getFromUser();
		m.setFromUser(m.getToUser());
		m.setToUser(from);
		m.setCreateDt((System.currentTimeMillis() / 1000) + "");
		return new WxSendMsg(m);
	}
	
	
	
}