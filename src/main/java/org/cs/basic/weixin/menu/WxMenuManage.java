package org.cs.basic.weixin.menu;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**自定义菜单管�?
 * @param xuxile
 * */
public class WxMenuManage {

	// http客户�?
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户�?
	}
	
	/**
	 * 创建菜单,MenuButtonHelper类可以获得create_menu_json
	 */
	public static String createMenu(String create_menu_json, String accessToken) throws Exception {
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(create_menu_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		return errcode;
	}
	
	/**
	 * 
	 * 查询菜单
	 */
	public static String getMenuInfo(String accessToken) throws Exception {
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		return jsonStr;
	}
	
	/**
	 * 删除自定义菜�?
	 */
	public static String getAccessToken(String accessToken) throws Exception {
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + accessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String errcode=object.getString("errcode");
		return errcode;
	}
}
