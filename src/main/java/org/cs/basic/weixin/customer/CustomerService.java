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
 * �ͷ���Ϣ����
 * @author xuxile
 *
 */
public class CustomerService {
	// http�ͻ���
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // �����κ�֤���������ͻ���
	}
	
	/**
	 * �����ı��ͷ���Ϣ
	 * @param openID ΢���û�OPENID
	 * @param content �ı�����
	 * @param accessToken ΢����֤��
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
	 * ����ͼƬ�ͷ���Ϣ
	 * @param openID ΢���û�OPENID
	 * @param mediaId ͼƬ����mediaId
	 * @param accessToken ΢����֤��
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
	 * ���������ͷ���Ϣ
	 * @param openID ΢���û�OPENID
	 * @param mediaId ��������mediaId
	 * @param accessToken ΢����֤��
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
	 * ������Ƶ�ͷ���Ϣ
	 * @param openID ΢���û�OPENID
	 * @param accessToken ΢����֤��
	 * @param mediaId ���͵���Ƶ��ý��ID
	 * @param title ��Ƶ��Ϣ�ı���
	 * @param description ��Ƶ��Ϣ������
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
	 * �������ֿͷ���Ϣ
	 * @param openID ΢���û�OPENID
	 * @param accessToken ΢����֤��
	 * @param title ���ֱ���
	 * @param description ������Ϣ������
	 * @param musicurl ��������
	 * @param hqmusicurl ��Ʒ���������ӣ�wifi��������ʹ�ø����Ӳ�������
	 * @param thumbMediaId ����ͼ��ý��ID
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
	 * ����ͼ����Ϣ
	 * @param openID ΢���û�OPENID
	 * @param accessToken ΢����֤��
	 * @param articles ��ͼ�ļ���
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
	 * ��ȡĳ���ͻ��Ŀͷ������¼�ӿ�
	 * @param accessToken ΢����֤�� 
	 * @param openid ��ͨ�û��ı�ʶ���Ե�ǰ���ں�Ψһ
	 * @param starttime ��ѯ��ʼʱ�䣬UNIXʱ���
	 * @param endtime ��ѯ����ʱ�䣬UNIXʱ�����ÿ�β�ѯ���ܿ��ղ�ѯ
	 * @param pagesize ÿҳ��С��ÿҳ�����ȡ1000��
	 * @param pageindex ��ѯ�ڼ�ҳ����1��ʼ
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