package org.cs.basic.weixin.notice;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.notice.model.Mptext;
import org.cs.basic.weixin.notice.model.Mptype;
import org.cs.basic.weixin.notice.model.Mpvideo;
import org.cs.basic.weixin.notice.model.openid.AdviceImageOpenIDMsg;
import org.cs.basic.weixin.notice.model.openid.AdviceMpnewsOpenIDMsg;
import org.cs.basic.weixin.notice.model.openid.AdviceMpvideoOpenIDMsg;
import org.cs.basic.weixin.notice.model.openid.AdviceTextOpenIDMsg;
import org.cs.basic.weixin.notice.model.openid.AdviceVoiceOpenIDMsg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 根据OpenID进行群发信息类
 * @author xuxile 
 **/
public class AdviceByOpenID {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	
	
	/**
	 * 根据OpenID进行群发文本消息
	 * @throws Exception 
	 * @param touser 微信用户OpenID集合
	 * @param accessToken 微信验证码
	 * @param content 文字内容
	 */
	public static AdviceJsonMsg sendTextbyOpenID(List<String> touser,String content,String accessToken) throws Exception{
		AdviceTextOpenIDMsg adviceTextMsg=new AdviceTextOpenIDMsg();
		adviceTextMsg.setTouser(touser);
		adviceTextMsg.setMsgtype("text");
		adviceTextMsg.setText(new Mptext(content));
		String text_json=net.sf.json.JSONObject.fromObject(adviceTextMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(text_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		String errmsg=object.getString("errmsg");
		String msg_id=object.getString("msg_id");
		AdviceJsonMsg adviceJsonMsg=new AdviceJsonMsg(errcode, errmsg, msg_id);
		return adviceJsonMsg;
	}
	
	/**
	 * 根据OpenID进行群发图片消息
	 * @throws Exception 
	 * @param touser 微信用户OpenID集合
	 * @param accessToken 微信验证码
	 * @param media_id 图片media_id
	 */
	public static AdviceJsonMsg sendImagebyOpenID(List<String> touser,String media_id,String accessToken) throws Exception{
		AdviceImageOpenIDMsg adviceImageMsg=new AdviceImageOpenIDMsg();
		adviceImageMsg.setTouser(touser);
		adviceImageMsg.setMsgtype("image");
		adviceImageMsg.setImage(new Mptype(media_id));
		String image_json=net.sf.json.JSONObject.fromObject(adviceImageMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(image_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		String errmsg=object.getString("errmsg");
		String msg_id=object.getString("msg_id");
		AdviceJsonMsg adviceJsonMsg=new AdviceJsonMsg(errcode, errmsg, msg_id);
		return adviceJsonMsg;
	}
	
	/**
	 * 根据OpenID进行群发语音消息
	 * @throws Exception 
	 * @param touser 微信用户OpenID集合
	 * @param accessToken 微信验证码
	 * @param media_id 语音media_id
	 */
	public static AdviceJsonMsg sendVoicebyOpenID(List<String> touser,String media_id,String accessToken) throws Exception{
		AdviceVoiceOpenIDMsg adviceVoiceMsg=new AdviceVoiceOpenIDMsg();
		adviceVoiceMsg.setTouser(touser);
		adviceVoiceMsg.setMsgtype("voice");
		adviceVoiceMsg.setVoice(new Mptype(media_id));
		String voice_json=net.sf.json.JSONObject.fromObject(adviceVoiceMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(voice_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		String errmsg=object.getString("errmsg");
		String msg_id=object.getString("msg_id");
		AdviceJsonMsg adviceJsonMsg=new AdviceJsonMsg(errcode, errmsg, msg_id);
		return adviceJsonMsg;
	}
	
	/**
	 * 根据OpenID进行群发图文消息
	 * @throws Exception 
	 * @param touser 微信用户OpenID集合
	 * @param accessToken 微信验证码
	 * @param media_id 图文media_id
	 */
	public static AdviceJsonMsg sendMpnewsbyOpenID(List<String> touser,String media_id,String accessToken) throws Exception{
		AdviceMpnewsOpenIDMsg adviceMpnewsMsg=new AdviceMpnewsOpenIDMsg();
		adviceMpnewsMsg.setTouser(touser);
		adviceMpnewsMsg.setMsgtype("mpnews");
		adviceMpnewsMsg.setMpnews(new Mptype(media_id));
		String mpnews_json=net.sf.json.JSONObject.fromObject(adviceMpnewsMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(mpnews_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		String errmsg=object.getString("errmsg");
		String msg_id=object.getString("msg_id");
		AdviceJsonMsg adviceJsonMsg=new AdviceJsonMsg(errcode, errmsg, msg_id);
		return adviceJsonMsg;
	}
	
	/**
	 * 根据OpenID进行群发视频消息
	 * @throws Exception 
	 * @param touser 微信用户OpenID集合
	 * @param accessToken 微信验证码
	 * @param title 消息标题
	 * @param description 消息描述
	 * @param media_id 已上传的视频media_id
	 */
	public static AdviceJsonMsg sendMpvideobyOpenID(String title,String media_id,String description,List<String> touser,String accessToken) throws Exception{
		Mpvideo mpvideo=new Mpvideo();
		mpvideo.setTitle(title);
		mpvideo.setMedia_id(media_id);
		mpvideo.setDescription(description);
		String new_media_id=getMpvideoNewMediaId(mpvideo, accessToken);
		
		Mpvideo video=new Mpvideo();
		video.setTitle(title);
		video.setMedia_id(new_media_id);
		video.setDescription(description);
		
		AdviceMpvideoOpenIDMsg adviceMpvideoMsg=new AdviceMpvideoOpenIDMsg();
		adviceMpvideoMsg.setTouser(touser);
		adviceMpvideoMsg.setMsgtype("video");
		adviceMpvideoMsg.setVideo(video);
		
		String mpvideo_json=net.sf.json.JSONObject.fromObject(adviceMpvideoMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(mpvideo_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		String errmsg=object.getString("errmsg");
		String msg_id=object.getString("msg_id");
		AdviceJsonMsg adviceJsonMsg=new AdviceJsonMsg(errcode, errmsg, msg_id);
		return adviceJsonMsg;
	}
	
	/**
	 * 上传视频信息media_id处理
	 * @throws Exception 
	 * @param accessToken 微信验证码
	 * @param mpvideo 视频信息
	 */
	public static String getMpvideoNewMediaId(Mpvideo mpvideo,String accessToken) throws Exception{
		String video_json=net.sf.json.JSONObject.fromObject(mpvideo).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(video_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String new_media_id=object.getString("media_id");
		return new_media_id;
	}
}