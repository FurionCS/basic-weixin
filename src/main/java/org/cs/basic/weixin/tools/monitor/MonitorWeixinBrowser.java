package org.cs.basic.weixin.tools.monitor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 模拟微信浏览器请求
 * @author xuxile
 */
public class MonitorWeixinBrowser {

	
	public static void main(String[] args) {
		String url = "https://mp.weixin.qq.com/cgi-bin/home?t=home/index&lang=zh_CN&token=1826755776";
		String html =  getHttpClientHtml(url, "uft-8");
		System.out.println(html);
	}
	/**
	 * 根据URL获得所有的html信息
	 */
	public static String getHttpClientHtml(String url,String code) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
		HttpGet httpget = new HttpGet(url);// 以get方式请求该URL
		httpget.setHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 6_1_2 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Mobile/10B146 MicroMessenger/5.0");
		try {
			HttpResponse responce = httpClient.execute(httpget);// 得到responce对象
			int resStatu = responce.getStatusLine().getStatusCode();// 返回码
			if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
				// 获得相应实体
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = new String(EntityUtils.toString(entity));// 获得html源代码
				}
			}
		} catch (Exception e) {
			System.out.println("访问【" + url + "】出现异常!");
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
}
