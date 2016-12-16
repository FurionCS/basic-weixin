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
import org.cs.basic.weixin.material.model.WxMaterial;
import org.cs.basic.weixin.material.model.WxNews;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class WxMaterialList {
	// http客户端
	@SuppressWarnings("deprecation")
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	/**
	 * 获得永久素材列表
	 * @param accessToken 微信验证码
	 * @param articles 图文素材集合
	 */
	public static JSONObject getMaterialList(String type,String offset,String count,String accessToken) throws Exception{
		WxMaterial wxMaterial=new WxMaterial(type,offset,count);
		String wxMaterial_json=net.sf.json.JSONObject.fromObject(wxMaterial).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(wxMaterial_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object;
	}
}
