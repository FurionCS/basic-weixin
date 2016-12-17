package org.cs.basic.weixin.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.template.model.IndustryModel;
import org.cs.basic.weixin.template.model.TemplateModel;
import org.cs.basic.weixin.template.model.TemplateSendResultModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Template {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	/**
	 * 获得设置的行业信息
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public static List<IndustryModel> getIndustry(String accessToken) throws Exception{
		HttpGet httpget = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + accessToken);
		HttpResponse response= httpclient.execute(httpget);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String primary_industry=object.getString("primary_industry");
		JSONObject pobj=JSON.parseObject(primary_industry);
		String secondary_industry=object.getString("secondary_industry");
		JSONObject sobj=JSON.parseObject(secondary_industry);
		List<IndustryModel> lim=Arrays.asList(new IndustryModel(pobj.getString("first_class"),pobj.getString("second_class"),1), new IndustryModel(sobj.getString("first_class"),sobj.getString("second_class"),2));
		return lim;
	}
	
	/**
	 * 获得模板列表
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public static List<TemplateModel> getAllPrivateTemplate(String accessToken) throws Exception{
		HttpGet httpget = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=" + accessToken);
		HttpResponse response= httpclient.execute(httpget);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String template_list=object.getString("template_list");
		JSONArray array=JSON.parseArray(template_list);
		List<TemplateModel> ltm=new ArrayList<TemplateModel>();
		for(int i=0;i<array.size();i++){
			JSONObject obj=(JSONObject) array.get(i);
			ltm.add(new TemplateModel(obj.getString("template_id"),obj.getString("title"),obj.getString("primary_industry"),obj.getString("deputy_industry"),obj.getString("content"),obj.getString("example")));
		}
		return ltm;
	}
	
	/**
	 * 获得模板列表
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public static TemplateSendResultModel sendTemplate(String templSenddatestr,String accessToken) throws Exception{
		HttpPost httppost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken);
		httppost.setEntity(new StringEntity(templSenddatestr, "UTF-8"));
		HttpResponse response= httpclient.execute(httppost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		TemplateSendResultModel tsrm=new TemplateSendResultModel(object.getString("errcode"),object.getString("errmsg"),object.getString("msgid"));
		return tsrm;
	}
	
}
