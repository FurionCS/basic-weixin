package org.cs.basic.weixin.notice;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.notice.model.Filter;
import org.cs.basic.weixin.notice.model.Mptext;
import org.cs.basic.weixin.notice.model.Mptype;
import org.cs.basic.weixin.notice.model.Mpvideo;
import org.cs.basic.weixin.notice.model.group.AdviceImageGroupMsg;
import org.cs.basic.weixin.notice.model.group.AdviceMpnewsGroupMsg;
import org.cs.basic.weixin.notice.model.group.AdviceMpvideoGroupMsg;
import org.cs.basic.weixin.notice.model.group.AdviceTextGroupMsg;
import org.cs.basic.weixin.notice.model.group.AdviceVoiceGroupMsg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 根据分组进行群发信息类
 *@author xuxile 
 **/
public class AdviceByGroup {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	
	/**
	 * 根据分组进行群发文本消息
	 * @throws Exception 
	 * @param group_id 分组ID
	 * @param accessToken 微信验证码
	 * @param content 文字内容
	 */
	public static AdviceJsonMsg sendTextbyGroup(String group_id,String content,String accessToken) throws Exception{
		AdviceTextGroupMsg adviceTextMsg=new AdviceTextGroupMsg();
		adviceTextMsg.setFilter(new Filter(group_id));
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
	 * 根据分组进行群发图片消息
	 * @throws Exception 
	 * @param group_id 分组ID
	 * @param accessToken 微信验证码
	 * @param media_id 图片media_id
	 */
	public static AdviceJsonMsg sendImagebyGroup(String group_id,String media_id,String accessToken) throws Exception{
		AdviceImageGroupMsg adviceImageMsg=new AdviceImageGroupMsg();
		adviceImageMsg.setFilter(new Filter(group_id));
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
	 * 根据分组进行群发语音消息
	 * @throws Exception 
	 * @param group_id 分组ID
	 * @param accessToken 微信验证码
	 * @param media_id 语音media_id
	 */
	public static AdviceJsonMsg sendVoicebyGroup(String group_id,String media_id,String accessToken) throws Exception{
		AdviceVoiceGroupMsg adviceVoiceMsg=new AdviceVoiceGroupMsg();
		adviceVoiceMsg.setFilter(new Filter(group_id));
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
	 * 根据分组进行群发图文消息
	 * @throws Exception 
	 * @param group_id 分组ID
	 * @param accessToken 微信验证码
	 * @param media_id 图文media_id
	 */
	public static AdviceJsonMsg sendMpnewsbyGroup(String group_id,String media_id,String accessToken) throws Exception{
		AdviceMpnewsGroupMsg adviceMpnewsMsg=new AdviceMpnewsGroupMsg();
		adviceMpnewsMsg.setFilter(new Filter(group_id));
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
	 * 根据分组进行群发视频消息
	 * @throws Exception 
	 * @param group_id 分组ID
	 * @param accessToken 微信验证码
	 * @param title 消息标题
	 * @param description 消息描述
	 * @param media_id 已上传的视频media_id
	 */
	public static AdviceJsonMsg sendMpvideobyGroup(String title,String media_id,String description,String group_id,String accessToken) throws Exception{
		Mpvideo mpvideo=new Mpvideo();
		mpvideo.setTitle(title);
		mpvideo.setMedia_id(media_id);
		mpvideo.setDescription(description);
		String new_media_id=getMpvideoNewMediaId(mpvideo, accessToken);
		
		AdviceMpvideoGroupMsg adviceMpvideoMsg=new AdviceMpvideoGroupMsg();
		adviceMpvideoMsg.setFilter(new Filter(group_id));
		adviceMpvideoMsg.setMsgtype("mpvideo");
		adviceMpvideoMsg.setMpvideo(new Mptype(new_media_id));
		
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