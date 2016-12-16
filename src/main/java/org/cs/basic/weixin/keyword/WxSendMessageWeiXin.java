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
 * ����ƽ̨��������Ϣ����
 * @author xuxile
 *
 */
public class WxSendMessageWeiXin {	
	protected String text; // �յ����û����ı���Ϣ
	protected WxSendMsg sendMsg; // ��Ϣ�ظ�����
	protected HttpServletResponse response;
	protected Map<String, String> mapPath; // ΢������Ҫ��URL
	protected WxRecvMsg msg; // ���ܵ�����Ϣ����
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
	 * �����ı���Ϣ������ƽ̨
	 * @param formUser ΢���û�OpenID 
	 * @param toUser ���ں�OpenID 
	 * @param keyWord �ؼ�������
	 * @throws JDOMException 
	 */
	public void showReturnText(String keyWord) throws JDOMException, IOException {						
			sendMsg = new WxSendTextMsg(sendMsg,keyWord);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	

	/**
	 * ���ص�ͼ�ĸ�����ƽ̨
	 * @param keyWord �ؼ�������
	 * @param formUser ΢���û�OpenID 
	 * @param toUser ���ں�OpenID
	 * @param description ͼ����Ϣ����  
	 * @param picUrl ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ360*200��Сͼ200*200
	 * @param url ���ͼ����Ϣ��ת����
	 */
	public void  showReturnGraphic(String title,String description,String picUrl,String url)throws JDOMException, IOException {
		sendMsg = new WxSendNewsMsg(sendMsg)
        .addItem(title,description,picUrl,url);
		WeiXin.send(sendMsg, response.getOutputStream());
	}
	
	/**
	 * ���ض�ͼ�ĸ�����ƽ̨
	 * @param keyWord �ؼ�������
	 * @param items ����ͼ����Ϣ��
	 * ��ͼ��������
	 * List<WxSendNewsMsgItem> items=new ArrayList<WxSendNewsMsgItem>(); 
	 * items.add(wxSendNewsMsgItem);
	 */
	public void  showReturnGraphics(List<WxSendNewsMsgItem> items)throws JDOMException, IOException {
		WxSendNewsMsg  sendNewsMsg= new WxSendNewsMsg(sendMsg);
		sendNewsMsg.setItems(items);
		WeiXin.send(sendNewsMsg, response.getOutputStream());
	}
	
	/**
	 * ����ͼƬ��Ϣ������ƽ̨
	 * @param formUser ΢���û�OpenID 
	 * @param toUser ���ں�OpenID 
	 * @param mediaId ͼƬID
	 * @throws JDOMException 
	 */
	public void showReturnPic(String mediaId) throws JDOMException, IOException {						
			sendMsg = new WxSendPicMsg(sendMsg,mediaId);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * ����������Ϣ������ƽ̨
	 * @param formUser ΢���û�OpenID 
	 * @param toUser ���ں�OpenID 
	 * @param mediaId ����ID
	 * @throws JDOMException 
	 */
	public void showReturnVoice(String mediaId) throws JDOMException, IOException {						
			sendMsg = new WxSendVoiceMsg(sendMsg,mediaId);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * ����������Ϣ������ƽ̨
	 * @param formUser ΢���û�OpenID 
	 * @param toUser ���ں�OpenID 
	 * @param title ���ֱ���
	 * @param description ��������
	 * @param musicUrl ��������
	 * @param hqMusicUrl �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
	 * @param thumbMediaId ����ͼ��ý��id��ͨ���ϴ���ý���ļ����õ���id
	 * @throws JDOMException 
	 */
	public void showReturnMusic(String title,String description,String musicUrl,String hqMusicUrl,String thumbMediaId) throws JDOMException, IOException {						
			sendMsg = new WxSendMusicMsg(sendMsg, title, description, musicUrl, hqMusicUrl, thumbMediaId);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * ������Ƶ��Ϣ������ƽ̨
	 * @param formUser ΢���û�OpenID 
	 * @param toUser ���ں�OpenID 
	 * @param mediaId ��ƵID
	 * @param title ��Ƶ��Ϣ�ı���
	 * @param description ��Ƶ��Ϣ������
	 * @throws JDOMException 
	 */
	public void showReturnVideo(String mediaId,String title,String description) throws JDOMException, IOException {						
			sendMsg = new WxSendVideoMsg(sendMsg, mediaId, title, description);
			WeiXin.send(sendMsg, response.getOutputStream());
		
	}
	
	/**
	 * ����Ϣת������ͷ�
	 * @param keyWord �ؼ�������
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
			Logger.getAnonymousLogger().warning("������Ϣʱ,������domΪ�� msg :"+msg);
		}
	}
}
