package org.cs.basic.weixin.media;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.cs.basic.weixin.common.AccessToken;

/**
 * 微信上传文件接口
 *@author xuxile 
 **/
public class WXUploadFile {
	
	/**
	 * 上传下载多媒体文件
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String accessToken =AccessToken.getAccessToken("wxee3c721dfbbfe208","7b350f238c7e8cf1d30c30699fb0f754");
			String respStr=uploadFile_MediaId("C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg","thumb", accessToken);
			
			System.out.println(respStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/** 微信上传文件接口，返回微信已上传文件地址
	 * @param filePath 上传文件路径 例如：C:\\Documents and Settings\\Administrator\\桌面\\4.JPG
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param access_token 调用接口凭证
	 * @param return 返回微信已上传文件地址
	 * @throws Exception 
	 * */
	public static String uploadFile_Url(String filePath,String type,String access_token) throws Exception{
		String media_id=uploadFile_MediaId(filePath, type, access_token);
		String file_url="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
			            +access_token+"&media_id="+media_id;
		return file_url;
	}
	
	/** 微信上传文件接口，返回微信media_id
	 * @param filePath 上传文件路径 例如：C:\\Documents and Settings\\Administrator\\桌面\\4.JPG
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param access_token 调用接口凭证
	 * @param return 返回微信媒体文件media_id
	 * @throws Exception 
	 * */
	public static String uploadFile_MediaId(String filePath,String type,String access_token) throws Exception{
		String respStr=get_media_id(filePath, type, access_token);
		org.json.JSONObject jsons = new org.json.JSONObject(respStr);
		String media_id="";
		if(!jsons.isNull("media_id")){
			media_id=(String)jsons.get("media_id");
		}else if(!jsons.isNull("thumb_media_id")){
			media_id=(String)jsons.get("thumb_media_id");
		}
		return media_id;
	}
	

	/** 微信上传文件接口，返回media_id
	 * @param filePath 上传文件路径 例如：C:\\Documents and Settings\\Administrator\\桌面\\4.JPG
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param access_token 调用接口凭证
	 * @param return media_id
	 * */
	private static String get_media_id(String filePath,String type,String access_token) throws Exception {
		 File file = new File(filePath);
	        if (!file.exists() || !file.isFile()) {
	            return "文件路径错误";
	        }
	        /**
	         * 第一部分
	         */
	        String url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+access_token+"&type="+type;
	        URL urlObj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
	        /**
	         * 设置关键值
	         */
	        con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
	        con.setDoInput(true);
	        con.setDoOutput(true);
	        con.setUseCaches(false); // post方式不能使用缓存
	        // 设置请求头信息
	        con.setRequestProperty("Connection", "Keep-Alive");
	        con.setRequestProperty("Charset", "UTF-8");
	
	        // 设置边界
	        String BOUNDARY = "----------" + System.currentTimeMillis();
	        con.setRequestProperty("content-type", "multipart/form-data; boundary=" + BOUNDARY);
	        //con.setRequestProperty("Content-Type", "multipart/mixed; boundary=" + BOUNDARY);
	        //con.setRequestProperty("content-type", "text/html");
	        // 请求正文信息
	
	        // 第一部分：
	        StringBuilder sb = new StringBuilder();
	        sb.append("--"); // ////////必须多两道线
	        sb.append(BOUNDARY);
	        sb.append("\r\n");
	        sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
	                + file.getName() + "\"\r\n");
	        sb.append("Content-Type:application/octet-stream\r\n\r\n");
	        byte[] head = sb.toString().getBytes("utf-8");
	        // 获得输出流
	        OutputStream out = new DataOutputStream(con.getOutputStream());
	        out.write(head);
	        
	        // 文件正文部分
	        DataInputStream in = new DataInputStream(new FileInputStream(file));
	        int bytes = 0;
	        byte[] bufferOut = new byte[1024];
	        while ((bytes = in.read(bufferOut)) != -1) {
	            out.write(bufferOut, 0, bytes);
	        }
	        in.close();
	        // 结尾部分
	        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
	        out.write(foot);
	        out.flush();
	        out.close();
	        /**
	         * 读取服务器响应，必须读取,否则提交不成功
	         */
	       // con.getResponseCode();

	        /**
	         * 下面的方式读取也是可以的
	         */

	         try {

	         // 定义BufferedReader输入流来读取URL的响应
	        	 StringBuffer buffer = new StringBuffer();
		         BufferedReader reader = new BufferedReader(new InputStreamReader(
		         con.getInputStream(),"UTF-8"));
		         String line = null;
		         while ((line = reader.readLine()) != null) {
		            //System.out.println(line);
		            buffer.append(line);
		         }
		         //System.out.println(buffer.toString());
		         return buffer.toString();
	         } catch (Exception e) {
	        	 System.out.println("发送POST请求出现异常！" + e);
	        	 e.printStackTrace();
	         }
	         return "-1";
	}
}