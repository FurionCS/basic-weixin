package org.cs.basic.weixin.customer;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.customer.model.CustomerImageMsg;
import org.cs.basic.weixin.customer.model.CustomerMusicMsg;
import org.cs.basic.weixin.customer.model.CustomerNewsMsg;
import org.cs.basic.weixin.customer.model.CustomerRecvRecordMsg;
import org.cs.basic.weixin.customer.model.CustomerSendRecordMsg;
import org.cs.basic.weixin.customer.model.CustomerTextMsg;
import org.cs.basic.weixin.customer.model.CustomerVideoMsg;
import org.cs.basic.weixin.customer.model.CustomerVoiceMsg;
import org.cs.basic.weixin.customer.model.content.Articles;
import org.cs.basic.weixin.customer.model.content.Image;
import org.cs.basic.weixin.customer.model.content.Music;
import org.cs.basic.weixin.customer.model.content.News;
import org.cs.basic.weixin.customer.model.content.Text;
import org.cs.basic.weixin.customer.model.content.Video;
import org.cs.basic.weixin.customer.model.content.Voice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * 客服消息服务
 * @author xuxile
 *
 */
public class CustomerService {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	
	/**
	 * 发送文本客服消息
	 * @param openID 微信用户OPENID
	 * @param content 文本内容
	 * @param accessToken 微信验证码
	 * @throws Exception 
	 * */
	public static String sendCustomerText(String content,String openID,String accessToken) throws Exception{
		Text text=new Text();
		text.setContent(content);
		CustomerTextMsg customerTextMsg=new CustomerTextMsg();
		customerTextMsg.setText(text);
		customerTextMsg.setMsgtype("text");
		customerTextMsg.setTouser(openID);
		String text_json=net.sf.json.JSONObject.fromObject(customerTextMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(text_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String code=object.getString("errcode");
		return code;
	}
	
	/**
	 * 发送图片客服消息
	 * @param openID 微信用户OPENID
	 * @param mediaId 图片内容mediaId
	 * @param accessToken 微信验证码
	 * @throws Exception 
	 * */
	public static String sendCustomerImage(String mediaId,String openID,String accessToken) throws Exception{
		Image image=new Image();
		image.setMedia_id(mediaId);
		CustomerImageMsg customerImageMsg=new CustomerImageMsg();
		customerImageMsg.setImage(image);
		customerImageMsg.setMsgtype("image");
		customerImageMsg.setTouser(openID);
		String image_json=net.sf.json.JSONObject.fromObject(customerImageMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(image_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String code=object.getString("errcode");
		return code;
	}
	
	/**
	 * 发送语音客服消息
	 * @param openID 微信用户OPENID
	 * @param mediaId 语音内容mediaId
	 * @param accessToken 微信验证码
	 * @throws Exception 
	 * */
	public static String sendCustomerVoice(String mediaId,String openID,String accessToken) throws Exception{
		Voice voice=new Voice();
		voice.setMedia_id(mediaId);
		
		CustomerVoiceMsg customerVoiceMsg=new CustomerVoiceMsg();
		customerVoiceMsg.setVoice(voice);
		customerVoiceMsg.setMsgtype("voice");
		customerVoiceMsg.setTouser(openID);
		String voice_json=net.sf.json.JSONObject.fromObject(customerVoiceMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(voice_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String code=object.getString("errcode");
		return code;
	}
	
	/**
	 * 发送视频客服消息
	 * @param openID 微信用户OPENID
	 * @param accessToken 微信验证码
	 * @param mediaId 发送的视频的媒体ID
	 * @param title 视频消息的标题
	 * @param description 视频消息的描述
	 * @throws Exception 
	 * */
	public static String sendCustomerVideo(String mediaId,String title,String description,String openID,String accessToken) throws Exception{
		Video video=new Video();
		video.setMedia_id(mediaId);
		video.setTitle(title);
		video.setDescription(description);
		
		CustomerVideoMsg customerVideoMsg=new CustomerVideoMsg();
		customerVideoMsg.setVideo(video);
		customerVideoMsg.setMsgtype("video");
		customerVideoMsg.setTouser(openID);
		String video_json=net.sf.json.JSONObject.fromObject(customerVideoMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(video_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String code=object.getString("errcode");
		return code;
	}
	
	/**
	 * 发送音乐客服消息
	 * @param openID 微信用户OPENID
	 * @param accessToken 微信验证码
	 * @param title 音乐标题
	 * @param description 音乐消息的描述
	 * @param musicurl 音乐链接
	 * @param hqmusicurl 高品质音乐链接，wifi环境优先使用该链接播放音乐
	 * @param thumbMediaId 缩略图的媒体ID
	 * @throws Exception 
	 * */
	public static String sendCustomerMusic(String title,String description,String musicurl,String hqmusicurl,String thumbMediaId,String openID,String accessToken) throws Exception{
		Music music=new Music();
		music.setTitle(title);
		music.setDescription(description);
		music.setHqmusicurl(hqmusicurl);
		music.setMusicurl(hqmusicurl);
		music.setThumb_media_id(thumbMediaId);
		
		CustomerMusicMsg customerMusicMsg=new CustomerMusicMsg();
		customerMusicMsg.setMusic(music);
		customerMusicMsg.setMsgtype("music");
		customerMusicMsg.setTouser(openID);
		String music_json=net.sf.json.JSONObject.fromObject(customerMusicMsg).toString();
		System.out.println(music_json);
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(music_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String code=object.getString("errcode");
		return code;
	}
	
	/**
	 * 发送图文消息
	 * @param openID 微信用户OPENID
	 * @param accessToken 微信验证码
	 * @param articles 多图文集合
	 * @throws Exception 
	 * */
	public static String sendCustomerNews(List<Articles> articles,String openID,String accessToken) throws Exception{
		News news=new News();
		news.setArticles(articles);
		CustomerNewsMsg customerNewsMsg=new CustomerNewsMsg();
		customerNewsMsg.setNews(news);
		customerNewsMsg.setMsgtype("news");
		customerNewsMsg.setTouser(openID);
		String news_json=net.sf.json.JSONObject.fromObject(customerNewsMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(news_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String code=object.getString("errcode");
		return code;
	}
	
	/**
	 * 获取某个客户的客服聊天记录接口
	 * @param accessToken 微信验证码 
	 * @param openid 普通用户的标识，对当前公众号唯一
	 * @param starttime 查询开始时间，UNIX时间戳
	 * @param endtime 查询结束时间，UNIX时间戳，每次查询不能跨日查询
	 * @param pagesize 每页大小，每页最多拉取1000条
	 * @param pageindex 查询第几页，从1开始
	 * */
	public static List<CustomerRecvRecordMsg> getCustomerRecordMsgs(String starttime,String endtime,String openid,String pagesize,String pageindex,String accessToken) throws Exception{
		CustomerSendRecordMsg recordMsg=new CustomerSendRecordMsg(starttime, endtime, openid, pagesize, pageindex);
		String record_json=net.sf.json.JSONObject.fromObject(recordMsg).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken);
		httpost.setEntity(new StringEntity(record_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		com.alibaba.fastjson.JSONArray array=object.getJSONArray("recordlist");
		List<CustomerRecvRecordMsg> list=new ArrayList<CustomerRecvRecordMsg>();
		for(int i=0;i<array.size();i++){
			com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSON.parseObject(array.get(i).toString());
			String worker=obj.getString("worker");
			String new_openid=obj.getString("openid");
			String opercode=obj.getString("opercode");
			String time=obj.getString("time");
			String text=obj.getString("text");
			CustomerRecvRecordMsg customerRecvRecordMsg=new CustomerRecvRecordMsg(worker, new_openid, opercode, time, text);
			list.add(customerRecvRecordMsg);
		}
		return list;
	}
}