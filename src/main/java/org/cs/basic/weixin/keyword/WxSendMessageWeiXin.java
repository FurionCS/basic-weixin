package org.cs.basic.weixin.keyword;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.cs.basic.weixin.msg.model.recv.WxRecvMsg;
import org.cs.basic.weixin.msg.model.send.WxSendMsg;
import org.cs.basic.weixin.msg.model.send.WxSendMusicMsg;
import org.cs.basic.weixin.msg.model.send.WxSendNewsMsg;
import org.cs.basic.weixin.msg.model.send.WxSendNewsMsgItem;
import org.cs.basic.weixin.msg.model.send.WxSendPicMsg;
import org.cs.basic.weixin.msg.model.send.WxSendTextMsg;
import org.cs.basic.weixin.msg.model.send.WxSendVideoMsg;
import org.cs.basic.weixin.msg.model.send.WxSendVoiceMsg;
import org.cs.basic.weixin.server.WeiXin;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;

/**
 * 公众平台，返回信息处理
 * @author xuxile
 *
 */
public class WxSendMessageWeiXin {	
	protected String text; // 收到的用户的文本消息
	protected WxSendMsg sendMsg; // 消息回复对象
	protected HttpServletResponse response;
	protected Map<String, String> mapPath; // 微信中需要的URL
	protected WxRecvMsg msg; // 接受到的消息对象
	protected ServletContext servletContext; // servlet
	
	public WxSendMessageWeiXin() {}
	public WxSendMessageWeiXin(String text, WxSendMsg sendMsg, HttpServletResponse response, Map<String, String> mapPath, WxRecvMsg msg, ServletContext servletContext) {
		this.text = text;
		this.sendMsg = sendMsg;
		this.response = response;
		this.mapPath = mapPath;
		this.msg = msg;
		this.servletContext = servletContext;
	}
	
	
	/**
	 * 返回文本信息给公众平台
	 * @param formUser 微信用户OpenID 
	 * @param toUser 公众号OpenID 
	 * @param keyWord 关键字内容
	 * @throws JDOMException 
	 */
	public void showReturnText(String keyWord) throws JDOMException, IOException {						
			sendMsg = new WxSendTextMsg(sendMsg,keyWord);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	

	/**
	 * 返回单图文给公众平台
	 * @param keyWord 关键字内容
	 * @param formUser 微信用户OpenID 
	 * @param toUser 公众号OpenID
	 * @param description 图文消息描述  
	 * @param picUrl 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 * @param url 点击图文消息跳转链接
	 */
	public void  showReturnGraphic(String title,String description,String picUrl,String url)throws JDOMException, IOException {
		sendMsg = new WxSendNewsMsg(sendMsg)
        .addItem(title,description,picUrl,url);
		WeiXin.send(sendMsg, response.getOutputStream());
	}
	
	/**
	 * 返回多图文给公众平台
	 * @param keyWord 关键字内容
	 * @param items 多条图文消息，
	 * 多图文事例：
	 * List<WxSendNewsMsgItem> items=new ArrayList<WxSendNewsMsgItem>(); 
	 * items.add(wxSendNewsMsgItem);
	 */
	public void  showReturnGraphics(List<WxSendNewsMsgItem> items)throws JDOMException, IOException {
		WxSendNewsMsg  sendNewsMsg= new WxSendNewsMsg(sendMsg);
		sendNewsMsg.setItems(items);
		WeiXin.send(sendNewsMsg, response.getOutputStream());
	}
	
	/**
	 * 返回图片信息给公众平台
	 * @param formUser 微信用户OpenID 
	 * @param toUser 公众号OpenID 
	 * @param mediaId 图片ID
	 * @throws JDOMException 
	 */
	public void showReturnPic(String mediaId) throws JDOMException, IOException {						
			sendMsg = new WxSendPicMsg(sendMsg,mediaId);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * 返回语音信息给公众平台
	 * @param formUser 微信用户OpenID 
	 * @param toUser 公众号OpenID 
	 * @param mediaId 语音ID
	 * @throws JDOMException 
	 */
	public void showReturnVoice(String mediaId) throws JDOMException, IOException {						
			sendMsg = new WxSendVoiceMsg(sendMsg,mediaId);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * 返回音乐信息给公众平台
	 * @param formUser 微信用户OpenID 
	 * @param toUser 公众号OpenID 
	 * @param title 音乐标题
	 * @param description 音乐描述
	 * @param musicUrl 音乐链接
	 * @param hqMusicUrl 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 * @param thumbMediaId 缩略图的媒体id，通过上传多媒体文件，得到的id
	 * @throws JDOMException 
	 */
	public void showReturnMusic(String title,String description,String musicUrl,String hqMusicUrl,String thumbMediaId) throws JDOMException, IOException {						
			sendMsg = new WxSendMusicMsg(sendMsg, title, description, musicUrl, hqMusicUrl, thumbMediaId);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * 返回视频信息给公众平台
	 * @param formUser 微信用户OpenID 
	 * @param toUser 公众号OpenID 
	 * @param mediaId 视频ID
	 * @param title 视频消息的标题
	 * @param description 视频消息的描述
	 * @throws JDOMException 
	 */
	public void showReturnVideo(String mediaId,String title,String description) throws JDOMException, IOException {						
			sendMsg = new WxSendVideoMsg(sendMsg, mediaId, title, description);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * 将消息转发到多客服
	 * @param keyWord 关键字内容
	 * @throws Exception 
	 */
	public void  TransferCustomerServiceMsgToWeiXin(String toUser,String fromUser) throws Exception{
		WxSendMsg wxSendMsg=new WxSendMsg(toUser, fromUser, 
		              String.valueOf(new Date().getTime()),
		              "transfer_customer_service", true);
		Document doc = wxSendMsg.toDocument();
		if(null != doc) {
			new XMLOutputter().output(doc, response.getOutputStream());
		} else {
			Logger.getAnonymousLogger().warning("发送消息时,解析出dom为空 msg :"+msg);
		}
	}
}
