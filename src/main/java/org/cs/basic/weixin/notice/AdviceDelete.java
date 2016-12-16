package org.cs.basic.weixin.notice;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.notice.model.MsgId;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 删除群发信息�?
 *@author xuxile 
 **/
public class AdviceDelete {
	// http客户�?
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户�?
	}
	
	/**
	 * 根据消息msgid删除群发信息
	 * @param accessToken 微信验证�?
	 * @param msgid 已群发信息的ID
	 */
	public static String deleteAdviceByMsgId(String msgid,String accessToken) throws Exception{
		MsgId msg_id=new MsgId(msgid);
		String msgid_json=net.sf.json.JSONObject.fromObject(msg_id).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com//cgi-bin/message/mass/delete?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(msgid_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		return errcode;
	}
}