package org.cs.basic.weixin.qr;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.http.HttpException;
import org.cs.basic.weixin.qr.model.QrActionInfo;
import org.cs.basic.weixin.qr.model.QrForeverMsg;
import org.cs.basic.weixin.qr.model.QrScene;
import org.cs.basic.weixin.qr.model.QrSnapMsg;
import org.cs.basic.weixin.qr.util.MySSLProtocolSocketFactory;
import org.json.JSONObject;

/**
 * ���ɴ������Ķ�ά��
 * @author xuxile
 */
public class QrManage {
	
	/**
	 * ����http����,��post��ʽ
	 * @param url
	 */
	@SuppressWarnings("deprecation")
	public static String doPost(String url,String responeJsonStr) throws IOException,HttpException{
		
		//ǿ�����ÿ�����֤��,������Ҫʹ���κ�֤�����https��ҳʱ��ֻ�����������κ�֤��
		Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
		Protocol.registerProtocol("https", myhttps);
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.setRequestBody(responeJsonStr);
		post.getParams().setContentCharset("utf-8");
		//����http����
		String respStr = "";
		
		client.executeMethod(post);
		respStr = post.getResponseBodyAsString();
		
		return respStr;
	}
	
	/**
	 * ������ʱ��������ά��
	 * @param ACCESS_TOKEN
     * @param expire_seconds	 �ö�ά����Чʱ�䣬����Ϊ��λ�� ��󲻳���1800��
     * @param scene_id	 ����ֵID����ʱ��ά��ʱΪ32λ��0���ͣ����ö�ά��ʱ���ֵΪ100000��Ŀǰ����ֻ֧��1--100000��
	 */
	@SuppressWarnings("deprecation")
	public static String getUrlQRCode(String ACCESS_TOKEN,int expire_seconds,int scene_id){
		QrScene scene=new QrScene(scene_id);
		QrActionInfo actionInfo=new QrActionInfo(scene);
		QrSnapMsg snapMsg=new QrSnapMsg(expire_seconds, "QR_SCENE", actionInfo);
		String snap_json=net.sf.json.JSONObject.fromObject(snapMsg).toString();
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ACCESS_TOKEN;
		String ticket_json="";//��ȡ�Ķ�ά��ticket json����
		String ticket="";//��ȡ�Ķ�ά��ticket��ƾ���ticket��������Чʱ���ڻ�ȡ��ά�롣
		String encode_ticket = "";//����UrlEncode֮���TICKET
		String qrurl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";//��ά���ַ
		try {
		  ticket_json = doPost(url,snap_json);
		  JSONObject object = new JSONObject(ticket_json);
		  ticket = object.getString("ticket");
		  encode_ticket= URLEncoder.encode(ticket);/**TICKET�ǵý���UrlEncode**/
		  qrurl+=encode_ticket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrurl;
	}
	
	/**
	 * �������ô�������ά��
	 * @param ACCESS_TOKEN
     * @param scene_id	 ����ֵID����ʱ��ά��ʱΪ32λ��0���ͣ����ö�ά��ʱ���ֵΪ100000��Ŀǰ����ֻ֧��1--100000��
	 */
	@SuppressWarnings("deprecation")
	public static String getQRCode(String ACCESS_TOKEN,int scene_id){
		
		QrScene scene=new QrScene(scene_id);
		QrActionInfo actionInfo=new QrActionInfo(scene);
		QrForeverMsg foreverMsg=new QrForeverMsg( "QR_LIMIT_SCENE", actionInfo);
		String forever_json=net.sf.json.JSONObject.fromObject(foreverMsg).toString();
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ACCESS_TOKEN;
		String ticket_json="";//��ȡ�Ķ�ά��ticket json����
		String ticket="";//��ȡ�Ķ�ά��ticket��ƾ���ticket��������Чʱ���ڻ�ȡ��ά�롣
		String encode_ticket = "";//����UrlEncode֮���TICKET
		String qrurl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";//��ά���ַ
		try {
		  ticket_json = doPost(url,forever_json);
		  JSONObject object = new JSONObject(ticket_json);
		  ticket = object.getString("ticket");
		  encode_ticket= URLEncoder.encode(ticket);/**TICKET�ǵý���UrlEncode**/
		  qrurl+=encode_ticket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrurl;
	}
	
}
