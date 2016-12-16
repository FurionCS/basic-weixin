package org.cs.basic.weixin.material;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.material.model.WxArticle;
import org.cs.basic.weixin.material.model.WxJsonMsg;
import org.cs.basic.weixin.material.model.WxNews;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 上传图文消息素材
 *@author xuxile 
 **/
public class WxUploadNews {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	
	/**
	 * 上传图文消息素材
	 * @param accessToken 微信验证码
	 * @param articles 图文素材集合
	 */
	public static WxJsonMsg uploadnews(List<WxArticle> articles,String accessToken) throws Exception{
		WxNews wxNews=new WxNews(articles);
		String wxNews_json=net.sf.json.JSONObject.fromObject(wxNews).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(wxNews_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String type=object.getString("type");
		String media_id=object.getString("media_id");
		String created_at=object.getString("created_at");
		WxJsonMsg wxJsonMsg=new WxJsonMsg(type, media_id, created_at);
		return wxJsonMsg;
	}
}
