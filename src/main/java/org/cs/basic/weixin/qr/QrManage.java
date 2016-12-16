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
 * 生成带参数的二维码
 * @author xuxile
 */
public class QrManage {
	
	/**
	 * 发送http请求,以post方式
	 * @param url
	 */
	@SuppressWarnings("deprecation")
	public static String doPost(String url,String responeJsonStr) throws IOException,HttpException{
		
		//强制设置可信任证书,当不需要使用任何证书访问https网页时，只需配置信任任何证书
		Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
		Protocol.registerProtocol("https", myhttps);
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.setRequestBody(responeJsonStr);
		post.getParams().setContentCharset("utf-8");
		//发送http请求
		String respStr = "";
		
		client.executeMethod(post);
		respStr = post.getResponseBodyAsString();
		
		return respStr;
	}
	
	/**
	 * 创建临时带参数二维码
	 * @param ACCESS_TOKEN
     * @param expire_seconds	 该二维码有效时间，以秒为单位。 最大不超过1800。
     * @param scene_id	 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	@SuppressWarnings("deprecation")
	public static String getUrlQRCode(String ACCESS_TOKEN,int expire_seconds,int scene_id){
		QrScene scene=new QrScene(scene_id);
		QrActionInfo actionInfo=new QrActionInfo(scene);
		QrSnapMsg snapMsg=new QrSnapMsg(expire_seconds, "QR_SCENE", actionInfo);
		String snap_json=net.sf.json.JSONObject.fromObject(snapMsg).toString();
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ACCESS_TOKEN;
		String ticket_json="";//获取的二维码ticket json数据
		String ticket="";//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
		String encode_ticket = "";//进行UrlEncode之后的TICKET
		String qrurl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";//二维码地址
		try {
		  ticket_json = doPost(url,snap_json);
		  JSONObject object = new JSONObject(ticket_json);
		  ticket = object.getString("ticket");
		  encode_ticket= URLEncoder.encode(ticket);/**TICKET记得进行UrlEncode**/
		  qrurl+=encode_ticket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrurl;
	}
	
	/**
	 * 创建永久带参数二维码
	 * @param ACCESS_TOKEN
     * @param scene_id	 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	@SuppressWarnings("deprecation")
	public static String getQRCode(String ACCESS_TOKEN,int scene_id){
		
		QrScene scene=new QrScene(scene_id);
		QrActionInfo actionInfo=new QrActionInfo(scene);
		QrForeverMsg foreverMsg=new QrForeverMsg( "QR_LIMIT_SCENE", actionInfo);
		String forever_json=net.sf.json.JSONObject.fromObject(foreverMsg).toString();
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ACCESS_TOKEN;
		String ticket_json="";//获取的二维码ticket json数据
		String ticket="";//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
		String encode_ticket = "";//进行UrlEncode之后的TICKET
		String qrurl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";//二维码地址
		try {
		  ticket_json = doPost(url,forever_json);
		  JSONObject object = new JSONObject(ticket_json);
		  ticket = object.getString("ticket");
		  encode_ticket= URLEncoder.encode(ticket);/**TICKET记得进行UrlEncode**/
		  qrurl+=encode_ticket;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrurl;
	}
	
}
