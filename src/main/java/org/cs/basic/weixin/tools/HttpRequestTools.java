package org.cs.basic.weixin.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;



public class HttpRequestTools {

	/**
	 * 根据字节截取字符串
	 * 
	 * @param s
	 * @param length
	 * @return
	 */
	public static String byteSubstring(String s, int length) {
		String returnStr = null;
		byte[] bytes = null;
		int i = 2; // 要截取的字节数，从第3个字节开始
		try {
			bytes = s.getBytes("Unicode");
			int n = 0; // 表示当前的字节数
			for (; i < bytes.length && n < length; i++) {
				// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
				if (i % 2 == 1) {
					n++; // 在UCS2第二个字节时n加1
				} else {
					// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
					if (bytes[i] != 0) {
						n++;
					}
				}
			}
			// 如果i为奇数时，处理成偶数
			if (i % 2 == 1) {
				// 该UCS2字符是汉字时，去掉这个截一半的汉字
				if (bytes[i - 1] != 0)
					i = i - 1;
				// 该UCS2字符是字母或数字，则保留该字符
				else
					i = i + 1;
			}
			returnStr = new String(bytes, 0, i, "Unicode");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}

	

	/**
	 * 请求页面
	 * @param strUrl
	 * @param strPostRequest
	 * @param maxLength
	 * @param code
	 * @return
	 */
	public static String getPageContent(String strUrl, String strPostRequest, int maxLength, String code) {
		// 读取结果网页
		StringBuffer buffer = new StringBuffer();
		HttpURLConnection connection = null;
		try {
			URL url = new URL(strUrl);
			// 打开url连接
			connection = (HttpURLConnection) url.openConnection();
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod(strPostRequest);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");// IE代理进行下载  
			// 发送
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), code));
			int ch;
			for (int length = 0; (ch = in.read()) > -1 && (maxLength <= 0 || length < maxLength); length++) {
				buffer.append((char) ch);
				//System.out.print((char) ch);
			}
			in.close();
			connection.disconnect();
			return buffer.toString().trim();
		} catch (Exception e) {
			if(connection != null) {
				connection.disconnect();
			}
			System.out.println(strUrl + "，" + e.getMessage());
			//ExceptionTools.getExceptionDetail(e, "地址：" + strUrl + "请求失败！");
			return null;
		}
	}
	
	
	/**
	 * 根据URL获得所有的html信息
	 * 
	 * @param url
	 * @return
	 */
	public static String getHttpClientHtml(String url,String code) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
		HttpGet httpget = new HttpGet(url);// 以get方式请求该URL
		try {
			HttpResponse responce = httpClient.execute(httpget);// 得到responce对象
			int resStatu = responce.getStatusLine().getStatusCode();// 返回码
			if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
				// 获得相应实体
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = new String(EntityUtils.toString(entity).getBytes("ISO-8859-1"),code);// 获得html源代码
				}
			}
		} catch (Exception e) {
			System.out.println("访问【" + url + "】出现异常!");
			//e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
	
	
	/**
	 * 默认编码获取HTML代码
	 * @param url
	 * @return
	 */
	public static String getHttpClientHtml(String url) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
		HttpGet httpget = new HttpGet(url);// 以get方式请求该URL
		try {
			HttpResponse responce = httpClient.execute(httpget);// 得到responce对象
			int resStatu = responce.getStatusLine().getStatusCode();// 返回码
			if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
				// 获得相应实体
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = EntityUtils.toString(entity);// 获得html源代码
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
	
	
	public static void main(String[] args) {
		Math.random();
		
		double	rate1 = Double.parseDouble("10")/100;
		double	rate2 = Double.parseDouble("5")/100;
		double	rate3= Double.parseDouble("3")/100;
		double	rate4 = Double.parseDouble("4")/100;
		
		
		
		double randomNumber = Math.random();
		 System.out.println(randomNumber);
		if (randomNumber >= 0 && randomNumber <= rate1){
		    System.out.println(1);
		}else if (randomNumber > rate1 && randomNumber <= rate1 + rate2){
			System.out.println(2);
		}else if (randomNumber > rate1 + rate2 && randomNumber <= rate1 + rate2 + rate3){
			System.out.println(3);
		}else if (randomNumber > rate1 + rate2 + rate3 && randomNumber <= rate1 + rate2 + rate3 + rate4){
			System.out.println(4);
		}
		
		
		
		System.out.println(rate1);
		
		
		System.out.println(Math.random());
		String fsfsa="[xhb_wifi]http://42.96.135.183/winfind/NFCKQWEB/addvoucher.ashx?flag=4&codelen=4&usrid=zhangxu&usrkey=680127816323&nfcid=zhangxu";
		System.out.println(fsfsa.length());
		
		System.out.println(fsfsa.indexOf("[xhb_wifi]"));
		System.out.println( fsfsa.substring("[xhb_wifi]".length()));
		//String sbUrl="http://42.96.135.183/winfind/NFCKQWEB/addvoucher.ashx?flag=4&codelen=4&usrid=zhangxu&usrkey=680127816323&nfcid=zhangxu";
        String pageContext = HttpRequestTools.getHttpClientHtml(fsfsa.substring("[xhb_wifi]".length()),"UTF-8");
		System.out.println("号"+pageContext);
	}
	
	
	public static String byteSubstring(String str) {
		try {
			if (str.getBytes("utf-8").length > 2037) {
				str = HttpRequestTools.byteSubstring(str, 1358) + "\n......";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	/**
	 * 通过HTTP获取JSON字符串
	 * 
	 * @param requestUrl
	 * @param charFormat
	 * @return
	 */
	public static String getJsonByHttp(String requestUrl, String charFormat) {
		StringBuffer returnStrBuffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();

			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, charFormat);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				returnStrBuffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStrBuffer.toString();
	}
	
	
	
}
