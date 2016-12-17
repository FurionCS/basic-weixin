package org.cs.basic.weixin.user.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.user.model.WxUser;




import org.cs.basic.weixin.user.model.WxUserClump;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 关注者管理类
 * @author xuxile 
 * */
public class UserManage {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	
	/**
	 * 获取关注者基本信息
	 * @throws Exception
	 */
	public static WxUser getUserInfo(String OpenID,String accessToken) throws Exception{
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+accessToken+"&openid="+OpenID+"&lang=zh_CN");
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String sex=object.getString("sex");
		if("1".equals(sex)){
			sex="男";
		}else if ("2".equals(sex)) {
			sex="女";
		}else if ("0".equals(sex)) {
			sex="未知";
		}
		String language=object.getString("language");
		if("zh_CN".equals(language)){
			language="简体";
		}else if ("zh_TW".equals(language)) {
			language="繁体";
		}else if ("en".equals(language)) {
			language="英语";
		}
		String subscribe=object.getString("subscribe");
		if("0".equals(subscribe)){
			subscribe="未订阅";
		}else{
			subscribe="已订阅";
		}
		String subscribeTime=object.getString("subscribe_time");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		subscribeTime = sdf.format(new Date(Long.valueOf(subscribeTime)*1000L));
		
		WxUser user=new WxUser();
		user.setCity(object.getString("city"));
		user.setCountry(object.getString("country"));
		user.setHeadimgurl(object.getString("headimgurl"));
		user.setLanguage(language);
		user.setNickname(object.getString("nickname"));
		user.setOpenid(object.getString("openid"));
		user.setProvince(object.getString("province"));
		user.setSex(sex);
		user.setSubscribe(subscribe);
		user.setSubscribe_time(subscribeTime);
		return user;
	}
	
	/**
	 * 一次性拉取获取关注者列表 最多拉取10000个关注者信息
	 * @param NEXT_OPENID 拉取列表的后一个用户的OPENID
	 */
	public static WxUserClump getUserList(String NEXT_OPENID,String accessToken) throws Exception{
		String url="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken;
		if(NEXT_OPENID!=null&&!"".equals(NEXT_OPENID)){
		   url+="&next_openid="+NEXT_OPENID;
		}
		HttpGet get = HttpClientConnectionManager.getGetMethod(url);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		int total=object.getIntValue("total");
		int count=object.getIntValue("count");
		String next_openid=object.getString("next_openid");
		
		if("".equals(next_openid)){
			return new WxUserClump(total, count, null, next_openid);
		}
		JSONObject obj= JSON.parseObject(object.getString("data"));
		String open_id_string=obj.getString("openid").toString();
		List<String> data = JSON.parseArray(open_id_string, String.class);	
		List<WxUser> wxUsers=new ArrayList<WxUser>();
		for(int i=0;i<data.size();i++){
			wxUsers.add(getUserInfo(data.get(i), accessToken));
		}
		
		WxUserClump wxUserClump=new WxUserClump(total, count, wxUsers, next_openid);
		return wxUserClump;
	}
	
	/**
	 * 获取全部关注者列表
	 * @param NEXT_OPENID 拉取列表的后一个用户的OPENID
	 */
	public static WxUserClump getAllUserList(String accessToken) throws Exception{
		int total=0;//关注该公众账号的总用户数
		int count=0;//拉取的OPENID个数，最大值为10000
		String nextOpenid=null;//拉取列表的后一个用户的OPENID
		List<WxUser> wxUsers=new ArrayList<WxUser>();//用户集合
		while (nextOpenid==null||!"".equals(nextOpenid)) {
				WxUserClump clump=getUserList(nextOpenid, accessToken);
				if(clump.getWxUsers()!=null){
					wxUsers.addAll(clump.getWxUsers());
					nextOpenid=clump.getNext_openid();
				}else {
					nextOpenid="";
				}
				total=clump.getTotal();
				count=total;
		}
		WxUserClump wxUserClump=new WxUserClump(total, count, wxUsers, nextOpenid);
		return wxUserClump;
	}
	
}
